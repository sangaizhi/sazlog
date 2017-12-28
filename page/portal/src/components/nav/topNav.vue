<template>
	<header id="header" class="app-header navbar" role="menu">
		<!-- navbar collapse（顶部导航栏） -->
		<div class="top-nav">
			<!-- buttons -->
			<div class="nav navbar-nav hidden-xs">
				<a data-no-instant="" href="#" class="btn no-shadow navbar-btn" ui-toggle-class="app-aside-folded" target=".app">
					<i class="fa fa-dedent" @click="handleOpen()"></i>
					<i class="fa fa-iddedent hide"></i>
				</a>
				<!--<a href="#" class="btn no-shadow navbar-btn" ui-toggle-class="show" target="#aside-user">
						<i class="fa fa-user-o"></i>
					</a>-->
			</div>
			<!-- / buttons -->

			<!-- search form -->
			<div id="searchform" class="navbar-form navbar-form-sm navbar-left shift" method="get" role="search">
				<div class="form-group">
					<div class="input-group">
						<input data-instant="" id="keyword" type="search" name="s" class="form-control input-sm bg-light no-border rounded padder" required="" placeholder="输入关键词搜索…" onkeypress="$.getKey();">
						<span class="input-group-btn">
			                	<a data-instant="" id="soux" href="" class="btn btn-sm bg-light rounded">
			                		<i class="fa fa-search"></i></icon>
			                	</a>
              				</span>
					</div>
				</div>
			</div>
			<!-- / search form -->

			<!-- 右側菜單 -->
			<div class="right-menu" id="right-menu" v-if="isLogin">
				<ul>
					<li>
						<i class="fa fa-star-o"></i>
						<span v-if="envelopeCount > 0">{{envelopeCount}}</span>
					</li>
					<li>
						<i class="fa fa-bell-o"></i>
						<span v-if="messageCount > 0">{{messageCount}}</span>
					</li>
					<li>
						<i class="fa fa-pencil"></i>
					</li>
				</ul>
			</div>
			<!-- / 右側菜單 -->

			<!-- 用户信息，显示信息 -->
			<div id="user-info" v-if="isLogin">
				<div class="user-info-sh">
					<div class="user-profile">
						<img width="30px" height="30px" v-bind:src="user.profile" />
					</div>
					<div class="user-name">
						<span v-html="user.nickname"></span>
						<i class="fa fa-caret-down"></i>
					</div>
				</div>
			</div>
			<!-- / 用户信息，显示信息-->
			<div id="login-menu" class="login-menu" v-else="">
				<div id="login-btn">
					<router-link to="/login">登录</router-link>
				</div>
			</div>

		</div>
		<!-- / navbar collapse -->
	</header>
</template>

<script>
	import $ from 'jquery';
	export default {
		data() {
			return {
				isLogin: false,
				isCollapse: true,
				envelopeCount: 2,
				messageCount: 1,
				user: {
					profile: '',
					nickname: ''
				}
			};
		},
		mounted() {
			var token = window.localStorage.getItem("token");
			if(null != token && token != 'undefined') {
				var userInfo = JSON.parse(window.localStorage.getItem("userInfo"));
				console.log(userInfo);
				this.user.nickname = userInfo.nickname;
				this.user.profile = userInfo.profile;
				this.isLogin = true;
			}
		},
		methods: {
		}
	}
	
</script>

<style>
	#header {
		position: absolute;
		top: 0;
		width: -moz-calc(100% - 200px);
		width: -webkit-calc(100% - 200px);
		width: calc(100% - 200px);
		height: 50px;
		left: 200px;
		border-bottom: 1px solid #EDF1F2;
		-moz-box-shadow: 0px 1px 1px #EDF1F2;
		/* 老的 Firefox */
		box-shadow: 0px 1px 1px #EDF1F2;
		background: #FFFFFF;
	}
	
	.top-nav {
		border-bottom: rgb(88, 102, 110);
		color: rgb(88, 102, 110);
		height: 50px;
		width: 100%;
		/*width: -moz-calc(100% - 201px);
		width: -webkit-calc(100% - 201px);
		width: calc(100% - 201px);*/
	}
	
	.top-nav .navbar-nav {
		height: 50px;
		float: left;
		line-height: 50px;
		display: inline-block;
		margin-left: 15px;
	}
	
	.top-nav .navbar-nav a {
		display: inline-block;
		height: 30px;
		line-height: 30px;
		margin: 10px auto;
	}
	
	.top-nav .navbar-nav a i {
		font-size: 16px;
		color: #58666E;
		margin-right: 15px;
	}
	
	.top-nav #searchform {
		display: inline-block;
		height: 50px;
		line-height: 50px;
		float: left;
	}
	
	.top-nav #searchform .form-group {
		height: 30px;
		line-height: 30px;
		margin: 10px auto;
	}
	
	.top-nav #searchform .form-group .input-group {}
	
	.top-nav #searchform .form-group .input-group input {
		height: 30px;
		line-height: 30px;
		background: #edf1f2;
		color: #58666E;
		border: #edf1f2;
		border-top-left-radius: 500px;
		border-bottom-left-radius: 500px;
		padding-left: 15px;
		float: left;
	}
	
	.top-nav #searchform .form-group .input-group input::-webkit-input-placeholder {
		color: #58666E;
	}
	
	.top-nav #searchform .form-group .input-group input:-moz-placeholder {
		/* Mozilla Firefox 4 to 18*/
		color: #58666E;
	}
	
	.top-nav #searchform .form-group .input-group input::-moz-placeholder {
		/* Mozilla Firefox 19+*/
		color: #58666E;
	}
	
	.top-nav #searchform .form-group .input-group input:-ms-input-placeholder {
		/* Internet Explorer 10+*/
		color: #58666E;
	}
	
	.top-nav #searchform .form-group .input-group input:focus {
		border: #edf1f2;
		border-top-left-radius: 500px;
		border-bottom-left-radius: 500px;
		outline: none;
	}
	
	.top-nav #searchform .form-group .input-group .input-group-btn {
		display: inline-block;
		border: #edf1f2;
		border-bottom-right-radius: 500px;
		border-top-right-radius: 500px;
		background: #edf1f2;
		width: 33px;
		margin-left: -3px;
		float: left;
	}
	
	.top-nav #searchform .form-group .input-group .input-group-btn i {
		color: #58666E;
		font-size: 14px;
	}
	
	#right-menu {
		float: right;
		margin-right: 150px;
	}
	
	#right-menu ul {
		margin: 0;
		list-style: none;
	}
	
	#right-menu ul li {
		display: inline-block;
		float: left;
		position: relative;
		color: #58666E;
		margin: 0;
	}
	
	#right-menu ul li i {
		height: 30px;
		width: 30px;
		margin: 10px;
		color: inherit;
		line-height: 30px;
		font-size: 16px;
	}
	
	#right-menu ul li:hover {
		color: #13CE66;
		background: #58666E;
	}
	
	#right-menu ul li span {
		position: absolute;
		top: 10px;
		right: 10px;
		background: #FF6C60;
		height: 15px;
		width: 15px;
		font-size: 12px;
		color: #FFFFFF;
		line-height: 16px;
	}
	
	#user-info {
		width: 150px;
		float: right;
		margin-right: 0;
		right: 0;
		position: absolute;
		height: 50px;
	}
	
	#user-info .user-info-sh {}
	
	#user-info .user-info-sh .user-profile {
		position: relative;
		float: left;
		width: 46px;
		height: 50px;
		display: inline-block;
	}
	
	#user-info .user-info-sh .user-profile:hover {
		background: #58666E;
	}
	
	#user-info .user-info-sh .user-profile img {
		height: 30px;
		width: 30px;
		margin: 10px 8px;
	}
	
	#user-info .user-info-sh .user-name {
		width: 98px;
		height: 50px;
		line-height: 50px;
		display: inline-block;
		float: right;
		cursor: pointer;
	}
	
	#user-info .user-info-sh .user-name:hover {
		color: #13CE66;
		background: #58666E;
	}
	#user-info .user-info-sh .user-name i{
		line-height: 50px;
	}
	#login-menu {
		text-align: center;
		display: inline-block;
		float: right;
		height: 50px;
		width: 100px;
		line-height: 50px;
	}
	
	#login-menu:hover {
		color: #13CE66;
		background: #58666E;
	}
</style>