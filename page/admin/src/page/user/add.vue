<template>
	<el-row :gutter="20">
		<el-col :span="12">
			<el-form :model="user" :rules="rules" ref="user" label-width="100px" class="add-form user-add-form">
				<el-form-item label="昵称" prop="nickname">
					<el-input v-model="user.nickname"></el-input>
				</el-form-item>
				<el-form-item label="手机号码" prop="phone">
					<el-input v-model="user.phone"></el-input>
				</el-form-item>
				<el-form-item label="邮箱" prop="email">
					<el-input v-model="user.email"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" size="small" @click="submitForm('user')">提交</el-button>
					<el-button size="small" @click="resetForm('user')">重置</el-button>
				</el-form-item>
			</el-form>
			</div>
		</el-col>
	</el-row>
</template>

<script>
	import { addUser } from "../../api/api.js";
	import { isMobile, isEmail } from '../../validate/regex.js';
	import {validatePhone,validateEmail} from '../../validate/elementValidateExtend.js';
	import {remoteCheckUserPhoneUsable,remoteCheckUserEmailUsable} from "../../validate/userValidate.js";
	export default {
		data() {
			return {
				user: {
					nickname: '',
					phone: '',
					email: ''
				},
				rules: {
					nickname: [
						{required: true,	message: '请输入昵称',trigger: 'blur'}
					],
					phone:[
						{required:true,message:"请输入手机号码",trigger:'blur'},
						{validator:validatePhone,trigger:'blur'},
						{validator:remoteCheckUserPhoneUsable,trigger:'blur'}
					],
					email:[
						{required:true,message:"请输入邮箱",trigger:'blur'},
						{validator:validateEmail,trigger:'blur'},
						{validator:remoteCheckUserEmailUsable,trigger:'blur'}
					]
				}

			};
		},
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
						var user = this.user;
						var self = this;
						addUser(user).then(function(response) {
							if(response.status) {
								self.$message({
									showClose: true,
									message: response.msg,
									type: 'success'
								});
								self.$router.push({
									path:'/home/user/list'
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

</style>