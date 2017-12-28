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
			<el-button type="primary" @click="submitForm('category')">提交</el-button>
			<el-button @click="resetForm('category')">重置</el-button>
		</el-form-item>
	</el-form>
  </div></el-col>
</el-row>
	
</template>
<script>
	import { addCategory } from "../../api/api.js";
	export default {
		data() {
			return {
				category: {
					name: '',
					remark: ''
				},
				rules:{
					name: [{
						required: true,
						message: '请输入名称',
						trigger: 'blur'
					}]
				}
				
			};
		},
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
//						var category = {
//							'category.name': this.category.name,
//							'category.remark':this.category.remark
//						}
						var category = this.category;
						var self = this;
						addCategory(category).then(function(response){
							if(response.status){
								self.$message({
									showClose: true,
									message: response.msg,
									type: 'success'
								});
							}else{
								self.$message({
									showClose: true,
									message: response.msg,
									type: 'error'
								});
							}
						},function(response){
							self.$message({
									showClose: true,
									message: '新增失败',
									type: 'error'
								});
						});
					} else {
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
		}
	}
</script>
<style>
	.category-add-form{
		margin: 15px;
	}
	.el-form-item button{
		width: 60px;
	}
</style>