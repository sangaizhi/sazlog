<template>
	<div id='left-nav'>
		<!--<el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
			<el-radio-button :label="false">展开</el-radio-button>
			<el-radio-button :label="true">收起</el-radio-button>
		</el-radio-group>-->
		<el-menu default-active="1-4-1" class="left-nav-menu" @open="handleOpen" @close="handleClose" :collapse="isCollapse" theme="dark"  background-color="#1F2D3D"
      text-color="#fff">
			<el-submenu index="1" class='sub_menu'>
				<template slot="title" class="sub_menu_title">
					<i class="fa fa-bars"></i>
					<span slot="title">导航管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="1-1" to='/home/category/list'>
						<router-link to="/home/category/list">分类</router-link>
					</el-menu-item>
					<el-menu-item index="1-2" to='/home/kitbox/list'>
						<router-link to="/home/kitbox/list">工具集</router-link>
					</el-menu-item>
					<el-menu-item index="1-3">系列</el-menu-item>
					<el-menu-item index="1-4">站点</el-menu-item>
				</el-menu-item-group>
			</el-submenu>
			<el-submenu index="2" class='sub_menu'>
				<template slot="title">
					<i class="fa fa-book"></i>
					<span slot="title">文章管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="2-1">
						<router-link to="/home/article/add">新增文章</router-link>
					</el-menu-item>
					<el-menu-item index="2-2">
						<router-link to="/home/article/list">文章列表</router-link>
					</el-menu-item>
					
				</el-menu-item-group>
			</el-submenu>
			<el-submenu index="3" class='sub_menu'>
				<template slot="title">
					<i class="fa fa-user-o"></i>
					<span slot="title">用户管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="3-1">
						<router-link to="/home/user/add">新增用户</router-link>
					</el-menu-item>
					<el-menu-item index="3-2">
						<router-link to="/home/user/list">用户列表</router-link>
					</el-menu-item>
				</el-menu-item-group>
			</el-submenu>
			<el-submenu index="4" class='sub_menu'>
				<template slot="title">
					<i class="fa fa-comment-o"></i>
					<span slot="title">评论管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="4-1">评论列表</el-menu-item>
				</el-menu-item-group>
			</el-submenu>
		</el-menu>
</div>
</template>
<script>
	 export default {
    data() {
      return {
        isCollapse: false
      };
    },
    methods: {
      handleOpen(key, keyPath) {
      },
      handleClose(key, keyPath) {
      }
    }
  }
</script>
<style>
	#left-nav{
		width: 200px;
		height: 100%;
		overflow: auto;
		background: #1F2D3D;
	}
	.left-nav-menu:not(.el-menu--collapse) {
		width: 200px;
		/*background: inherit;*/
	}
	.sub_menu{
		width: 100%;
		/*background: inherit;*/
	}
	.sub_menu .el-submenu__title{
/*		background: inherit;*/
	}
	.sub_menu ul{
		/*background: inherit !important;*/
	}
	.el-menu-item a{
		text-decoration: none;
		color: inherit;
	}
</style>