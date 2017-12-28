/**
 * Created by superman on 17/2/16.
 */

import Vue from 'vue'
import VueRouter from 'vue-router'
import store from './store/store'
import {saveUser} from './assets/js/user.js';
import * as types from './store/types';
import axiosInstance from './util/http';
import App from './App.vue';
import home from './components/home.vue';
import container from './components/container.vue';
import login from './components/user/login.vue';
import articleList from './components/article/list.vue';

Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: '/',
		component: home,
		meta: {
			requireAuth: false
		},
		children:[
			{
				path:'',
				component:articleList
			}
		]
	},
	{
		path:'/login',
		name:'/login',
		component:login,
		meta: {
			requireAuth: false
		}
	},
	{
		path:'/article/list/:categoryId',
		name:'/articleList',
		component:articleList,
		meta:{
			requireAuth:false
		}
	}
	
];


const router = new VueRouter({
	routes
});

router.beforeEach((to, from, next) => {
	if(to.matched.some(r => r.meta.requireAuth)) {
		if(store.state.token) {
			// 判断登录是否过期，通过从后台获取用户的数据
			axiosInstance.post("http://localhost:8082/blog-sso/getUserByToken", {
				token: store.state.token
			}).then(function(response) {
				let result = response.data;
				var resultStatus = result.status;
				if(resultStatus) {
					saveUser(userInfo);
					next();
				} else {
					alert("登录过期");
					next({
						path: '/login',
						query: {
							redirect: to.fullPath
						}
					});
				}
			}, function(response) {
				alert("登录过期");
				next({
					path: '/login',
					query: {
						redirect: to.fullPath
					}
				});
			});
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