/**
 * Created by superman on 17/2/16.
 */

import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '../store/store.js';
import * as types from '../store/types.js';
import login from '../page/login.vue';
import home from '../page/home.vue';
import categoryList from '../page/category/list.vue';
import categoryAdd from '../page/category/add.vue';
import categoryEdit from '../page/category/edit.vue';
import articleList from '../page/article/list.vue';
import articleAdd from '../page/article/add.vue';
import articleEdit from '../page/article/edit.vue';
import userList from '../page/user/list.vue';
import userAdd from '../page/user/add.vue';
import kitboxList from '../page/kitbox/list.vue';
// import axiosInstance from '../util/http';

Vue.use(VueRouter)

const routes = [{
		path: '/',
		name: 'login',
		component: login,
		meta: {
			requireAuth: false,
		},
	},
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			requireAuth: false,
		},
	},
	{
		path: '/home',
		name: '/home',
		component: home,
		meta: {
			requireAuth: true,
		},
		children: [{
				path: 'category/list',
				component: categoryList,
				meta: {
					requireAuth: true,
				}
			},
			{
				path: 'category/add',
				component: categoryAdd,
				meta: {
					requireAuth: true,
				}
			},
			{
				path:'category/edit/:id',
				component:categoryEdit,
				meta: {
					requireAuth: true,
				}
			},
			{
				path:'article/list',
				component:articleList,
				meta: {
					requireAuth: true,
				}
			},
			{
				path:'article/add',
				component:articleAdd,
				meta:{
					requireAuth:true
				}
			},
			{
				path:'article/edit/:id',
				component:articleEdit,
				meta:{
					requireAuth:true
				}
			},
			{
				path:'user/list',
				component:userList,
				meta:{
					requireAuth:true
				}
			},
			{
				path:'user/add',
				component:userAdd,
				meta:{
					requireAuth:true
				}
			},
			{
				path:'kitbox/list',
				component:kitboxList,
				mata:{
					requireAuth:true
				}
			}
		]
	}
];

// 页面刷新时，重新赋值token
if(window.localStorage.getItem('token')) {
	store.commit(types.LOGIN, window.localStorage.getItem('token'));
}

const router = new VueRouter({
	routes
});

// 路由拦截器，
router.beforeEach((to, from, next) => {
	if(to.matched.some(r => r.meta.requireAuth)) {
		if(store.state.token) {
			next();
		} else {
			next({
				path: '/login',
				query: {
					redirect: to.fullPath
				}
			});
		}
	} else {
		next();
	}
})
export default router;