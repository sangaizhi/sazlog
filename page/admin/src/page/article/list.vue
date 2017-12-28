<template>
	<div id="article" class="table-container">
		<div class="table-top-op">
			 <el-select v-model='selectCategory' size="small" @change="selectCatgoryChange" placeholder="请选择" :clearable="selectCategoryClear">
			    <el-option
			      v-for="item in categoryList"
			      :key="item.id"
			      :label="item.name"
			      :value="item.id">
			    </el-option>
			  </el-select>
			<el-button size='small' type='primary' @click.native.prevent="addArticle()">新增文章</el-button>
		</div>
		<div class="artilce-list table-list">
			<el-table :data="articleList" v-loading.body="loading" stripe border height="100%" style="width: auto">
				<el-table-column prop="title" label="标题" width="180">
				</el-table-column>
				<el-table-column prop="summary" label="概要" :formatter='substringFormat'>
				</el-table-column>
				<el-table-column prop="categoryName" width="150" label="所属分类" :filters="filterCategoryList" :filter-method="filterCategory">
				</el-table-column>
				<el-table-column prop="star" width="80" label="星数">
				</el-table-column>
				<el-table-column prop="labelSet" label="标签" width="auto">
					<template scope="scope">
						<el-tag class='article-tag' v-for="tag in scope.row.labelSet" :closable="true" type="success" @close="deletaLabel(scope.row.id, scope.$index, tag)" close-transition>{{tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="userName" width="100" label="作者">
				</el-table-column>
				<el-table-column prop="createTime" width="180" label="发布时间" :formatter='dateFormat'>
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="120">
					<template scope="scope">
						<el-button @click.native.prevent="handleDelete(scope.$index, scope.row.id, articleList)" type="text" size="small">移除
						</el-button>
						<el-button @click.native.prevent="handleEdit(scope.$index, scope.row.id, articleList)" type="text" size="small">编辑
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
		<div class="block page-bar">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="page.pageNum" :page-size="page.pageSize" layout="prev, pager, next, jumper,total" :total="page.recordCount">
			</el-pagination>
		</div>
	</div>

</template>

<script>
	import $ from 'jquery';
	import * as types from '../../store/types';
	import { requestArticleList,requestCategoryList,deleteArticle, deleteArticleLabel } from "../../api/api.js";
	import { Loading } from 'element-ui';

	export default {
		data() {
			return {
				articleList:[],
				categoryList:[],
				selectCategory:'',
				selectCategoryClear:true,
				filterCategoryList:[],
				page: {},
				loading: true
			}
		},
		mounted() {
			var self = this;
			var token = this.$store.state.token;
			var tokenParam = {
				'token': self.token
			}
			var loadingOptions = {
				fullscreen: true
			}
			requestArticleList(tokenParam).then(function(response) {
				if(response.status) {
					self.articleList = response.data.list;
					self.page = response.data.page;
					self.loading = false;
				} else {
					self.$router.push({
						path: "/login"
					})
				}
			}, function(response) {
				self.$message({
					showClose: true,
					message: "加載失敗",
					type: 'error'
				});
			});
			requestCategoryList(tokenParam).then(function(response) {
				if(response.status) {
					var responseData = response.data;
					self.categoryList = responseData;
					for(var temp in responseData){
						var category = {
							value:responseData[temp].id,
							text:responseData[temp].name
						}
						self.filterCategoryList.push(category);
					}
					self.loading = false;
				} else {
					self.$router.push({
						path: "/login"
					})
				}
			}, function(response) {
				self.$message({
					showClose: true,
					message: "加載失敗",
					type: 'error'
				});
			});
		},
		methods: {
			//时间格式化  
			dateFormat: function(row, column) {
				var date = row[column.property];
				if(date == undefined) {
					return "";
				}
				return this.$moment(date).format("YYYY-MM-DD HH:mm:ss");
			},
			//
			substringFormat: function(row, column) {
				var val = row[column.property];
				if(val == undefined) {
					return "";
				}
				if(val.length >= 50) {
					val = val.substring(0, 49);
				}
				return val;
			},
			deletaLabel(id, rowIndex, label) {
				this.$confirm('确认删除该标签吗?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					var self = this;
					var params = {
						'id': id,
						'label': label
					}
					deleteArticleLabel(params).then(function(response) {
						if(response.status) {
							self.articleList[rowIndex].labelSet.splice(self.articleList[rowIndex].labelSet.indexOf(label), 1);
						} else {
							self.$message({
								showClose: true,
								message: response.msg,
								type: 'error'
							});
						}
					}, function(response) {
						self.$message({
							showClose: true,
							message: "删除失败",
							type: 'error'
						});
					});
				}).catch(() => {});
			},
			addArticle() {
				this.$router.push({
					path: "/home/article/add"
				})
			},
			handleEdit(index, id, rows) {
				this.$router.push({
					path: "/home/article/edit/" + id
				})
			},
			handleDelete(index, id, rows) {
				var self = this;
				this.$confirm('确认删除该文章吗?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					var self = this;
					deleteArticle(id).then(function(response) {
						if(response.status) {
							self.$message({
								showClose: true,
								message: "删除成功",
								type: 'success'
							});
							rows.splice(index, 1);
						} else {
							self.$message({
								showClose: true,
								message: response.msg,
								type: 'error'
							});
						}
					}, function(response) {
						self.$message({
							showClose: true,
							message: "删除失败",
							type: 'error'
						});
					});
				}).catch(() => {});
			},
			handleSizeChange() {

			},
			handleCurrentChange(val) {
				var self = this;
				var token = this.$store.state.token;
				var params = {
					'token': self.token,
					'pageNum':val,
					'pageSize':self.page.pageSize,
					'categoryId':self.selectCategory
				}
				requestArticleList(params).then(function(response) {
					if(response.status) {
						self.articleList = response.data.list;
						self.page = response.data.page;
						self.loading = false;
					} else {
						self.$router.push({
							path: "/login"
						})
					}
				}, function(response) {
					self.$message({
						showClose: true,
						message: "加載失敗",
						type: 'error'
					});
				});
			},
			filterCategory(value, row){
				return row.categoryId === value;
				
			},
			selectCatgoryChange(value){
				var self = this;
				var token = this.$store.state.token;
				var params = {
					'token': self.token,
					'categoryId':value
				}
				self.selectCategory = value;
				requestArticleList(params).then(function(response) {
					if(response.status) {
						self.articleList = response.data.list;
						self.page = response.data.page;
						self.loading = false;
					} else {
						self.$router.push({
							path: "/login"
						})
					}
				}, function(response) {
					self.$message({
						showClose: true,
						message: "加載失敗",
						type: 'error'
					});
				});
			}
		}
	}
</script>
<style>
	.article-tag {
		margin: 0 5px;
	}
</style>