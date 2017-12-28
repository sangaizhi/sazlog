<template>
	<div id="left-nav-container" class="left-nav-contianer">
		<!-- navbar header（交集处） -->
		<div class="navbar-header">
			<a href="https://www.baidu.com" class="navbar-brand text-lt">
				<!--<span class="hidden-folded m-l-xs"></span>-->
				<img src="../../assets/images/logo/logo_z_white.png" />
			</a>
		</div>
		<!-- / navbar header -->
		<nav class="left-nav" id="left-nav">
			<div class="left-list">
				<p class="list-title">
					<!--<i class='list-title-icon category'></i>--><span>导航</span></p>
				<ul class="first-nav">
					<li>
						<router-link to="" @click.native="openAndCloseNav($event)">
							<i class='fa fa-list'></i>
							<span>分类</span>
							<i class='chevron fa fa-chevron-right'></i>
						</router-link>
						<ul class='second-nav'>
							<li v-for='category in categoryList'>
								<router-link :to="{path:'/article/list/'+category.id,name:category.name,meta:{breadNum:3}}">{{category.name}}</router-link>
							</li>
						</ul>
					</li>
					<li>
						<router-link to="" @click.native="openAndCloseNav($event)">
							<i class="fa fa-wrench"></i>
							<span>工具</span>
							<i class='chevron fa fa-chevron-right'></i>
						</router-link>
						<ul class="second-nav">
							<li v-for="tool in toolList">
								<router-link to="/">{{tool.name}}</router-link>
							</li>
						</ul>
					</li>
					<li>
						<router-link to="" @click.native="openAndCloseNav($event)">
							<i class='fa fa-book'></i>
							<span>系列</span>
							<i class='chevron fa fa-chevron-right'></i>
						</router-link>
						<ul class="second-nav">
							<li v-for="tutorial in tutorialList">
								<router-link to="/">{{tutorial.name}}</router-link>
							</li>
						</ul>
					</li>
					<li>
						<router-link to="" @click.native="openAndCloseNav($event)">
							<i class='fa fa-book'></i>
							<span>站点导航</span>
							<i class='chevron fa fa-chevron-right'></i>
						</router-link>
						<ul class="second-nav">
							<li v-for="tutorial in tutorialList">
								<router-link to="/">{{tutorial.name}}</router-link>
							</li>
						</ul>
					</li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class='left-list'>
				<p class="list-title">
					<!--<i class='list-title-icon hot'></i><span>-->最新发布</span>
				</p>
				<ul class="first-nav">
					<li v-for="hot in hotList">
						<router-link to="">{{hot.title}}</router-link>
					</li>
				</ul>
			</div>
			<div class='left-list'>
				<p class="list-title">
					<!--<i class='list-title-icon hot'></i><span>-->最新评论</span>
				</p>
				<ul class="first-nav">
					<li v-for="hot in hotList">
						<router-link to="">{{hot.title}}</router-link>
					</li>
				</ul>
			</div>
		</nav>
	</div>
</template>

<script>
	import $ from 'jquery';
	export default {
		data() {
			return {
				categoryList: [{
						id: '1',
						name: 'JAVA'
					},
					{
						id: '2',
						name: 'Spring'
					},
					{
						id: '3',
						name: 'Spring boot'
					},
					{
						id: '4',
						name: 'Spring Clound'
					},
					{
						id: '5',
						name: 'Mybatis'
					}
				],
				pageList: [{
					id: '6',
					name: '关于'
				}],
				tutorialList: [{
						id: '7',
						name: 'Spring Boot 入门教程'
					},
					{
						id: '8',
						name: 'Spring Batch 入门教程'
					},
					{
						id: '9',
						name: 'Spring Security 入门教程'
					}
				],
				toolList: [{
						id: '10',
						name: '开发工具'
					},
					{
						id: '11',
						name: '运维工具'
					},
					{
						id: '12',
						name: '其它工具'
					}
				],
				websiteList: [{
						id: '13',
						logo: '',
						remoteLink: '',
						name: 'tutorialspoint'
					},
					{
						id: '14',
						logo: '',
						remoteLink: '',
						name: 'wulihub'
					},
					{
						id: '15',
						logo: '',
						remoteLink: '',
						name: '简书'
					}
				],
				hotList: [{
						id: "16",
						title: '第一篇热门'
					},
					{
						id: '17',
						title: '第二篇热门'
					},
					{
						id: '18',
						title: '第三篇热门'
					},
					{
						id: '19',
						title: '第四篇热门'
					},
					{
						id: '20',
						title: '第五篇热门'
					},
				]
			};
		},
		mounted() {},
		methods: {
			openAndCloseNav(event) {
				var currentTarget = event.currentTarget;
				var secondNav = $(currentTarget).siblings("ul");
				$(".first-nav > li > ul").slideUp();
				$(".first-nav > li >  a").removeClass("active");
				if($(secondNav).is(":hidden")) {
					$(secondNav).slideDown();
					$(currentTarget).addClass("active");
				} else {
					$(secondNav).slideUp();
					$(currentTarget).removeClass("active");
				}
			}
		}
	}
</script>

<style>
	#left-nav-container {
		position: absolute;
		width: 217px;
		background: #222222;
		height: 100%;
		overflow: auto;
	}
	
	#left-nav-container::-webkit-scrollbar {
		display: none;
	}
	
	#left-nav-container::-webkit-scrollbar-track-piece {
		display: none;
	}
	
	#left-nav-container::-webkit-scrollbar-thumb:vertical {
		display: none;
	}
	
	#left-nav-container::-webkit-scrollbar-thumb:horizontal {
		display: none;
	}
	
	.navbar-header {
		width: 200px;
		height: 75px;
		text-align: center;
		margin-top: 50px;
		line-height: 75px;
		display: inline-block;
	}
	
	.navbar-header a {
		height: 75px;
		line-height: 75px;
		border-radius: 50%;
		border: 1px solid #FFFFFF;
		display: inline-block;
	}
	
	.navbar-header i {
		font-size: 22px;
		color: #FFFFFF;
	}
	
	.navbar-header span {
		font-size: 18px;
		font-weight: bold;
		color: #FFFFFF;
		margin-left: 10px;
	}
	
	#left-nav {
		width: 200px;
		height: 100%;
		color: #cccccc;
		overflow-x: hidden;
		overflow-y: auto;
	}
	#left-nav::-webkit-scrollbar {
		display: none;
	}
	
	#left-nav::-webkit-scrollbar-track-piece {
		display: none;
	}
	
	#left-nav::-webkit-scrollbar-thumb:vertical {
		display: none;
	}
	
	#left-nav::-webkit-scrollbar-thumb:horizontal {
		display: none;
	}
	
	#left-nav .left-list .list-title {
		display: block;
		height: 40px;
		line-height: 40px;
		padding-left: 20px;
		margin: 20px 0 0px 0;
		text-align: left;
		font-size: 12px;
		border-bottom: 1px solid #111111;
		box-sizing: border-box;
	}
	
	#left-nav .left-list .list-title:hover {
		color: #FFFFFF;
		background: #474747;
	}
	
	#left-nav .left-list .list-title span {
		display: inline-block;
		position: relative;
	}
	
	#left-nav .left-list .first-nav {
		list-style: none;
		margin: 0;
	}
	
	#left-nav .left-list .first-nav li {
		display: block;
		line-height: 40px;
		margin: 5px 0;
		text-align: left;
		font-size: 14px;
		width: 100%;
	}
	
	#left-nav .left-list .first-nav li a {
		display: block;
		color: inherit;
		padding-left: 30px;
		text-align: left;
	}
	
	#left-nav .left-list .first-nav li a.active {
		color: #FFFFFF;
		background: #474747;
	}
	
	#left-nav .left-list .first-nav li a i {
		display: inline-block;
		
	}
	#left-nav .left-list .first-nav li i:first-child{
		line-height: 40px;
	}
	#left-nav .left-list .first-nav li a.active i:last-child {
		transform: rotate(90deg) scale(0.75);
		-ms-transform: rotate(90deg) scale(0.75);
		-moz-transform: rotate(90deg) scale(0.75);
		-webkit-transform: rotate(90deg) scale(0.75);
		-o-transform: rotate(90deg) scale(0.75);
	}
	
	#left-nav .left-list .first-nav li i:last-child {
		float: right;
		margin: 15px 15px 10px auto;
		font-size: 12px;
		-webkit-transform: scale(0.75);
	}
	
	#left-nav .left-list .first-nav li a:hover {
		color: #FFFFFF;
		background: #474747;
	}
	
	#left-nav .left-list .first-nav li a span {
		margin-left: 10px;
	}
	
	#left-nav .left-list .second-nav {
		display: none;
	}
	
	#left-nav .left-list .second-nav li {}
	
	#left-nav .left-list .second-nav li a {
		display: block;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		padding-left: 58px;
	}
</style>