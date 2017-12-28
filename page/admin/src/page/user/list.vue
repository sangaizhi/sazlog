<template>
	<div id="user" class="table-container">
		<div class="table-top-op">
		     <el-input v-model="keyword" size="small" class='search-text' placeholder="昵称、电话、邮箱"></el-input>
			 <el-select v-model='selectUserStatus' size="small" @change="selectUserStatusChange" placeholder="请选择" :clearable="canClearUserStatus">
			    <el-option
			      v-for="item in userStatus"
			      :key="item.value"
			      :label="item.text"
			      :value="item.value">
			    </el-option>
			  </el-select>
			<el-button size='small' type='primary' @click.native.prevent="search()">搜索</el-button>
			<el-button size='small' type='primary' @click.native.prevent="addUser()">新增用户</el-button>
			
		</div>
		<div class="user-list table-list" >
			<el-table :data="userList" v-loading.body="loading" stripe border height="100%" style="width: auto">
				<el-table-column prop="phone" label="电话" width="180">
				</el-table-column>
				<el-table-column prop="email" label="邮箱" :formatter='substringFormat'>
				</el-table-column>
				<el-table-column prop="nickname" width="150" label="昵称">
				</el-table-column>
				<el-table-column prop="profile" width="80" label="头像">
					<template scope="scope">
						<img v-if="null != scope.row.profile" v-bind:src="scope.row.profile" />
					</template>
				</el-table-column>
				<el-table-column prop="status" width="180" label="状态" :filters="userStatus" :filter-method="filterStatus" :formatter='statusFormat'>
				</el-table-column>
				<el-table-column prop="createTime" width="180" label="创建时间" :formatter='dateFormat'>
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="200">
					<template scope="scope">
						<el-button v-if='scope.row.status == userStatusDict.INIT.value' @click.native.prevent="handleActive(scope.$index, scope.row.id, userList)" type="text" size="small">激活</el-button>
						<el-button v-if='scope.row.status == userStatusDict.ACTIVATED.value' @click.native.prevent="handleLock(scope.$index, scope.row.id, userList)" type="text" size="small">锁定</el-button>
						<el-button v-if='scope.row.status == userStatusDict.LOCKED.value' @click.native.prevent="handleUnLock(scope.$index, scope.row.id, userList)" type="text" size="small">解锁</el-button>
						<el-button v-if='scope.row.status == userStatusDict.ACTIVATED.value' @click.native.prevent="handleDisable(scope.$index, scope.row.id, userList)" type="text" size="small">禁用</el-button>
						<el-button v-if='scope.row.status == userStatusDict.DISABLED.value' @click.native.prevent="handleEnable(scope.$index, scope.row.id, userList)" type="text" size="small">启用</el-button>
						<el-button @click.native.prevent="handleDelete(scope.$index, scope.row.id, userList)" type="text" size="small">移除</el-button>
						<el-button @click.native.prevent="handleEdit(scope.$index, scope.row.id, userList)" type="text" size="small">编辑</el-button>
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
	import { requestUserList,deleteUser,activeUser,lockUser,unLockUser,disableUser,enableUser } from "../../api/api.js";
	import { Loading } from 'element-ui';
	import {UserStatus,SystemConstants} from '../../assets/js/constants.js';

	export default {
		data() {
			return {
				userList: [],
				loading: true,
				page:{},
				userStatusDict:UserStatus,
				userStatus:UserStatus.list,
				selectUserStatus:'',
				keyword:'',
				canClearUserStatus:true
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
			requestUserList(tokenParam).then(function(response) {
				if(response.status) {
					self.userList = response.data.list;
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
			statusFormat:function(row, column){
				var val = row[column.property];
				if(val == undefined) {
					return "";
				}
				for(let index in UserStatus.list){
					if(UserStatus.list[index].value === val){
						return UserStatus.list[index].text;
					}
				}
				return "";
			},
			search(){
				var self = this;
				var token = this.$store.state.token;
				var params = {
					'token': self.token,
					'keyword':self.keyword,					
					'status':self.selectUserStatus
				}
				var loadingOptions = {
					fullscreen: true
				}
				requestUserList(params).then(function(response) {
					if(response.status) {
						self.userList = response.data.list;
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
			addUser() {
				this.$router.push({
					path: "/home/user/add"
				})
			},
			handleEdit(index, id, rows) {
				this.$router.push({
					path: "/home/user/edit/"+id
				})
			},
			handleDelete(index, id, rows) {
				var self = this;
				this.$confirm('确认删除该用户吗?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					var self = this;
					deleteUser(id).then(function(response) {
						if(response.status) {
							self.$message({
								showClose: true,
								message: "删除成功",
								type: 'success'
							});
							self.$router.go(0);
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
			handleActive(index, id, rows){
				var self = this;
				activeUser(id).then(function(response){
					if(response.status) {
						self.$message({
							showClose: true,
							message: "激活成功",
							type: 'success'
						});
						self.userList[index].status = UserStatus.ACTIVATED.value;
					} else {
						self.$message({
							showClose: true,
							message: response.msg,
							type: 'error'
						});
					}
				},function(rsponse){
					self.$message({
						showClose: true,
						message: "激活失败",
						type: 'error'
					});
				})
			},
			handleLock(index, id, rows){
				var self = this;
				lockUser(id).then(function(response){
					if(response.status) {
						self.$message({
							showClose: true,
							message: "锁定成功",
							type: 'success'
						});
						self.userList[index].status = UserStatus.LOCKED.value;
					} else {
						self.$message({
							showClose: true,
							message: response.msg,
							type: 'error'
						});
					}
				},function(response){
					self.$message({
						showClose: true,
						message: "锁定失败",
						type: 'error'
					});
				});
			},
			handleUnLock(index, id, rows){
				var self = this;
				unLockUser(id).then(function(response){
					if(response.status) {
						self.$message({
							showClose: true,
							message: "解锁成功",
							type: 'success'
						});
						self.userList[index].status = UserStatus.ACTIVATED.value;
					} else {
						self.$message({
							showClose: true,
							message: response.msg,
							type: 'error'
						});
					}
				},function(response){
					self.$message({
						showClose: true,
						message: "解锁失败",
						type: 'error'
					});
				});
			},
			handleDisable(index, id, rows){
				var self = this;
				disableUser(id).then(function(response){
					if(response.status) {
						self.$message({
							showClose: true,
							message: "禁用成功",
							type: 'success'
						});
						self.userList[index].status = UserStatus.DISABLED.value;
					} else {
						self.$message({
							showClose: true,
							message: response.msg,
							type: 'error'
						});
					}
				},function(response){
					self.$message({
						showClose: true,
						message: "禁用失败",
						type: 'error'
					});
				});
			},
			handleEnable(index, id, rows){
				var self = this;
				enableUser(id).then(function(response){
					if(response.status) {
						self.$message({
							showClose: true,
							message: "启用成功",
							type: 'success'
						});
						self.userList[index].status = UserStatus.ACTIVATED.value;
					} else {
						self.$message({
							showClose: true,
							message: response.msg,
							type: 'error'
						});
					}
				},function(response){
					self.$message({
						showClose: true,
						message: "启用失败",
						type: 'error'
					});
				});
			},
			handleSizeChange(){},
			handleCurrentChange(val){
				var self = this;
				var token = this.$store.state.token;
				var params = {
					'token': self.token,
					'pageNum':val,
					'pageSize':self.page.pageSize,
					'keyword':self.keyword
				}
				var loadingOptions = {
					fullscreen: true
				}
				requestUserList(params).then(function(response) {
					if(response.status) {
						self.userList = response.data.list;
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
			selectUserStatusChange(value){
				var self = this;
				var token = this.$store.state.token;
				var params = {
					'token': self.token,
					'keyword':self.keyword,					
					'status':value
				}
				var loadingOptions = {
					fullscreen: true
				}
				requestUserList(params).then(function(response) {
					if(response.status) {
						self.userList = response.data.list;
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
			filterStatus(value, row){
				return row.status === value;
			}
			
		}
	}
</script>
<style>
	.article-tag {
		margin: 0 5px;
	}
</style>