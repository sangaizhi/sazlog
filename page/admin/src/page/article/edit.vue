<template>
	<div id="article-add">
		<el-row :gutter="24">
			<el-col :span="24">
				<el-form :model="article" :rules="rules" ref="article" label-width="100px" class="article-add-form">
					<el-form-item label="分类:">
						<el-select v-model="article.categoryId" placeholder="请选择分类">
							<el-option v-for='category in categoryList' :value='category.id' :label="category.name" class='category-option'></el-option>
						</el-select>
					</el-form-item>
					<el-row :gutter="12">
						<el-col :span="15">
							<el-form-item label="名称:" prop="title">
								<el-input v-model="article.title" :span="6"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="12">
						<el-col :span="15">
							<el-form-item label="标签:">
								<el-input v-model="article.label" :span="6" placeholder="以 , 分隔"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="12">
						<el-col :span="15">
							<el-form-item label="概要:">
								<el-input v-model="article.summary" :span="6"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row :gutter="12">
						<el-col :span="15">
						<el-form-item label="内容:" prop='content' class='article-content'>
						<mavon-editor v-model="article.originalContent" :ishljs='true' />
					</el-form-item>
						</el-col>
					</el-row>
					
					<el-form-item>
						<el-button type="primary" @click="submitForm('article')">提交</el-button>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
		<!--<mavon-editor v-model="value" :ishljs='true' />-->
	</div>
</template>

<script>
	import mavonEditor from 'mavon-editor';
	import { requestCategoryList,getArticleById,editArticle } from "../../api/api.js";
	export default {
		data() {
			return {
				value: '',
				article: {
					id: this.$route.params.id,
					title: '',
					label: '',
					summary: '',
					categoryId: '',
					content: '',
					originalContent:''
				},
				categoryList: [{
						id: '1',
						name: 'Java'
					},
					{
						id: 2,
						name: 'Spring'
					}
				],
				rules: {
					title: [{
						required: true,
						message: '请输入标题',
						trigger: 'blur'
					}],
					content: [{
						required: true,
						message: '请输入内容',
						trigger: 'blur'
					}]
				}
			}
		},
		mounted() {
			var self = this;
			var token = this.$store.state.token;
			var tokenParam = {
				'token': self.token
			}
			getArticleById(self.article.id).then(function(response){
				if(response.status){
					self.article = response.data;
				}else{
					self.$message({
						showClose: true,
						message: "获取文章详情失败",
						type: 'error'
					});
				}
			},function(response){
				self.$message({
					showClose: true,
					message: "获取文章详情失败",
					type: 'error'
				});
			});
			
			requestCategoryList(tokenParam).then(function(response) {
				if(response.status) {
					self.categoryList = response.data;
					self.loading = false;
				} else {
					self.$router.push({
						path: "/login"
					})
				}
			}, function(response) {
				self.$message({
					showClose: true,
					message: "加载失败",
					type: 'error'
				});
			});

		},
		methods: {
			submitForm(formName) {
				var self = this;
				this.$refs[formName].validate((valid) => {
					if(valid) {
						var copyArticle = self.article;
						copyArticle.content = $(".v-show-content").html();
						editArticle(copyArticle).then(function(response){
							if(response.status){
								self.$message({
									showClose: true,
									message: "保存成功",
									type: 'success'
								});
								self.$router.go(-1);
							}else{
								self.$message({
									showClose: true,
									message: response.msg,
									type: 'error'
								});
							}
						},function(){
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
		},
		components: [mavonEditor]
	}
</script>

<style>
	.category-option {
		display: block;
	}
</style>