<template>
	<el-row :gutter="20">
		<el-col :span="12">
			<el-form :model="category" :rules="rules" ref="category" label-width="100px" class="category-add-form">
				<el-form-item label="名称" prop="name">
					<el-input v-model="category.name"></el-input>
				</el-form-item>
				<el-form-item label="说明" prop="remark">
					<el-input type="textarea" v-model="category.remark"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button id='submitBtn' :disabled="btnDisabled" type="primary" @click="submitForm('category')">提交</el-button>
				</el-form-item>
			</el-form>
			</div>
		</el-col>
	</el-row>

</template>
<script>
	import { getCategoryById,editCategory } from "../../api/api.js";
	export default {
		data() {
			return {
				category: {
					id: this.$route.params.id,
					name: '',
					remark: ''

				},
				rules: {
					name: [{
						required: true,
						message: '请输入名称',
						trigger: 'blur'
					}]
				},
				btnDisabled: true

			};
		},
		mounted() {
			var self = this;
			var id = self.category.id;
			getCategoryById(id).then(function(response) {
				if(response.status) {
					var data  = JSON.parse(response.data);
					self.category.name=data.name;
					self.category.remark = data.remark;
					self.btnDisabled = false;
				} else {
					self.$message({
						showClose: true,
						message: response.msg,
						type: 'error',
						onclose:backToList()
					});
				}
			}, function(response) {
				self.$message({
					showClose: true,
					message: "查询失败",
					type: 'error'
				});
			});

		},
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
						var category = this.category;
						var self = this;
						editCategory(category).then(function(response) {
							if(response.status) {
								self.$message({
									showClose: true,
									message: response.msg,
									type: 'success'
								});
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
								message: '失败',
								type: 'error'
							});
						});
					} else {
						return false;
					}
				});
			},
			backToList() {
				
			}
		}
	}
</script>
<style>
	.category-add-form {
		margin: 15px;
	}
	
	.el-form-item button {
		width: 60px;
	}
</style>