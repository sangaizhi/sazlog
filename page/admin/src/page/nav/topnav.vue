<template>
	<el-row id='top-nav' class='top-nav'>
		<el-col :span="24" class='top-nav-col'>
			<div class="logo-text-container"> Z Blog</div>
			<div class='user-container'>
				<div class="user-avatar">
					<img width="30px" height="30px" v-bind:src="user.avatar" />
				</div>
				<div class="user-name" @click="userDownShow($event)">
					<p>
						<span v-html="user.name"></span>
						<i class="el-icon-arrow-down"></i>
					</p>
					<section class='user-down' style="display: none;">
						<p>
							<a @click="logout($event)">退出</a>
						</p>
					</section>
				</div>
			</div>
			<div class="clear"></div>
		</el-col>
	</el-row>
</template>
<script>
	import $ from 'jquery';
	import * as types from '../../store/types';
	import { userLogout } from "../../api/api.js";
	import { saveUser, saveToken, requestAndSaveUser } from "../../util/storage.js";
	import {SystemConstants} from "../../assets/js/constants.js";
	export default {
		data() {
			return {
				user: {
					avatar: '',
					name: ''
				}
			};
		},
		mounted() {
			var user = JSON.parse(window.localStorage.getItem("user"));
			this.user.name = user.name;
			if(user.avatar == undefined || user.avatar == ''){
				this.user.avatar = SystemConstants.DEFAULT_USER_AVATAR;
			}else{
				this.user.avatar = user.avatar;
			}
			
		},
		methods: {
			userDownShow: function(event) {
				if($('.user-down').is(":hidden")) {
					$('.user-down').slideDown();
				} else {
					$('.user-down').slideUp();
				}
			},
			logout:function(event){
				var token = this.$store.state.token;
				var self = this;
				console.log(userLogout);
				var params = {
					'token':token
				}
				userLogout(params).then(function(){
					self.$store.commit(types.LOGOUT);
					self.$router.push({
						path: "/login"
					})
				},function(){
					self.$message({
						showClose: true,
						message: "退出失败",
						type: 'error'
					});
				});
			}
		}
		
	}
</script>
<style>
	.top-nav {
		height: 50px;
		line-height: 50px;
		margin: 0;
		border-bottom: 1px solid #EFF2F7;
		box-sizing: border-box;
	}
	
	.top-nav .top-nav-col {
		/*border-bottom: ;*/
	}
	
	.top-nav div:not(.clear):not(.hide) {
		display: inline-block;
		height: 50px;
		line-height: 50px;
	}
	
	.logo-text-container {
		width: 200px;
		text-align: center;
		font-size: 20px;
		background: #13CE66;
		float: left;
	}
	
	.user-container {
		float: right;
	}
	
	.user-container .user-avatar {
		display: inline-block;
		height: 50px;
		width: 50px;
		float: left;
	}
	
	.user-container .user-avatar img {
		width: 30px;
		height: 30px;
		margin: 10px;
	}
	
	.user-container .user-name {
		float: right;
		width: 100px;
		height: 50px;
		line-height: 50px;
		position: relative;
		font-size: 14px;
		cursor: pointer;
		text-align: center;
	}
	
	.user-container .user-name i {
		font-size: 12px;
	}
	
	.user-down {
		position: absolute;
		width: 100px;
		text-align: center;
		z-index:999;
	}
</style>