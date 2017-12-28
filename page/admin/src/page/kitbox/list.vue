<template>
	<div id="kitbox" class="table-container">
		<div class="table-top-op">
			<el-button size='small' type='primary' @click.native.prevent="addKitBoxVisible = true">新增工具集</el-button>

		</div>
		<div class="kitbox-list table-list">
			<el-table :data="kitboxList" v-loading.body="loading" stripe border height="100%" style="width: auto">
				<el-table-column prop="name" label="名称" width="180">
				</el-table-column>
				<el-table-column prop="createTime" label="创建时间" :formatter='dateFormat'>
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="200">
					<template scope="scope">
						<el-button @click.native.prevent="handleDelete(scope.$index, scope.row.id, kitboxList)" type="text" size="small">移除</el-button>
						<el-button @click.native.prevent="handleEdit(scope.$index, scope.row.id, kitboxList)" type="text" size="small">编辑</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
		<el-dialog title="新增工具集" class='add-kitbox-dialog' :visible.sync="addKitBoxVisible">
			<el-form :model="addKitBoxForm" :rules="rules" ref="addKitBoxForm">
				<el-form-item label="名称" label-width="80px" prop="name">
					<el-input v-model="addKitBoxForm.name" size="small" auto-complete="off" class="large-input"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button type="primary" size="small" @click.native.prevent="addKitbox('addKitBoxForm')">确 定</el-button>
				<el-button size="small" @click="addKitBoxVisible = false">取 消</el-button>
			</div>
		</el-dialog>
		<el-dialog title="编辑工具集" class='add-kitbox-dialog' :visible.sync="editKitBoxVisible">
			<el-form :model="editKitBoxForm" :rules="rules" ref="editKitBoxForm">
				<el-form-item label="名称" label-width="80px" prop="name">
					<el-input v-model="editKitBoxForm.name" size="small" auto-complete="off" class="large-input"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button type="primary" size="small" @click.native.prevent="editKitbox('editKitBoxForm')">确 定</el-button>
				<el-button size="small" @click="editKitBoxVisible = false">取 消</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import { requestKitboxList, addKitbox, renameKitbox, deleteKitBox } from "../../api/api.js";
	import { Loading } from 'element-ui';
	export default {
		data() {
			return {
				loading: true,
				kitboxList: [],
				page: {},
				addKitBoxVisible: false,
				editKitBoxVisible: false,
				addKitBoxForm: {
					name: ''
				},
				editKitBoxForm: {
					id: '',
					name: ''
				},
				rules: {
					name: [{
						required: true,
						message: '请输入名称',
						trigger: 'blur'
					}]
				}
			}
		},
		mounted() {
			var self = this;
			var loadingOptions = {
				fullscreen: true
			}
			requestKitboxList().then(function(response) {
				if(response.status) {
					self.kitboxList = response.data.list;
					self.loading = false;
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
					message: "加载失敗",
					type: 'error'
				});
			});
		},
		methods: {
			dateFormat: function(row, column) {
				var date = row[column.property];
				if(date == undefined) {
					return "";
				}
				return this.$moment(date).format("YYYY-MM-DD HH:mm:ss");
			},
			addKitbox(formName) {
				var self = this;
				this.$refs[formName].validate((valid) => {
					if(valid) {
						var self = this;
						var addKitboxData = this.addKitBoxForm;
						addKitbox(addKitboxData).then(function(response) {
							if(response.status) {
								self.$message({
									showClose: true,
									message: "保存成功",
									type: 'error'
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
								message: "保存失败",
								type: 'error'
							});
						});
					} else {
						return false;
					}
				});
			},
			editKitbox(formName) {
				var self = this;
				this.$refs[formName].validate((valid) => {
					if(valid) {
						var self = this;
							var editKitbox = self.editKitBoxForm;
						var params = editKitbox.id + "/" + editKitbox.name;
						renameKitbox(params).then(function(response) {
							if(response.status) {
								self.$message({
									showClose: true,
									message: "保存成功",
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
								message: "保存失败",
								type: 'error'
							});
						});
					} else {
						return false;
					}
				});
			},
			handleDelete(index, id, rows) {
				var self = this;
				this.$confirm('确认删除该工具集吗?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					var self = this;
					deleteKitBox(id).then(function(response) {
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
			handleEdit(index, id, rows) {
				var self = this;
				self.editKitBoxForm = rows[index];
				self.editKitBoxVisible = true;
			},
			handleSizeChange() {},
			handleCurrentChange(val) {}
		}
	}
</script>

<style>
	.add-kitbox-dialog {}
	
	.add-kitbox-dialog .el-dialog {
		width: 400px;
	}
</style>