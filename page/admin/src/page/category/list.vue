<template>
	<div id="category" class="table-container">
		<div class="table-top-op">
			<el-button size='small' type='primary' @click.native.prevent="addCatrgory()">新增分类</el-button>
		</div>
		<div class="category-list table-list">
			<el-table :data="categoryList" v-loading.body="loading" stripe border height="100%" style="width: auto">
				<el-table-column prop="name" label="名称" width="180">
				</el-table-column>
				<el-table-column prop="remark" label="说明" width="180">
				</el-table-column>
				<el-table-column prop="createTime" label="创建时间"  :formatter="dateFormat"  >
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="120">
					<template scope="scope">
						<el-button @click.native.prevent="handleDelete(scope.$index, scope.row.id, categoryList)" type="text" size="small">移除
						</el-button>
						<el-button @click.native.prevent="handleEdit(scope.$index, scope.row.id, categoryList)" type="text" size="small">编辑
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>

	</div>

</template>

<script>
	import $ from 'jquery';
	import * as types from '../../store/types';
	import { requestCategoryList, deletrCategory } from "../../api/api.js";
	import { Loading } from 'element-ui';

	export default {
		data() {
			return {
				categoryList: [],
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
			requestCategoryList(tokenParam).then(function(response) {
				if(response.status) {
					self.categoryList = response.data;
					self.loading=false;
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
			addCatrgory() {
				this.$router.push({
					path: "/home/category/add"
				})
			},
			handleEdit(index, id, rows) {
				this.$router.push({
					path: "/home/category/edit/"+id
				})
			},
			handleDelete(index, id, rows) {
				var self = this;
				deletrCategory(id).then(function(response) {
					self.$message({
						showClose: true,
						message: "删除成功",
						type: 'success'
					});
					rows.splice(index, 1);
				}, function(response) {
					self.$message({
						showClose: true,
						message: "删除失败",
						type: 'error'
					});
				});
			}
		}
	}
</script>
<style>
	.category-list .el-table {
		margin: 0 15px;
		height: 100%;
		margin-bottom: 15px;
	}
</style>