import axios from 'axios'
import store from '../store/store'
import * as types from '../store/types'
import router from '../router/router.js'
import qs from 'qs';

// axios 配置

// http request 拦截器

var axiosInstance = axios.create({
	timeout: 100000,
	headers: {
		'Content-Type': 'application/x-www-form-urlencoded'
	},
	withCredentials:true,
	transformRequest: [function(data) {
		data = qs.stringify(data)
		return data;
	}]
});


axiosInstance.interceptors.request.use(
	config => {
		if(store.state.token) {
			config.headers.Authorization = `${store.state.token}`;
		}
		return config;
	},
	err => {
		return Promise.reject(err);
	}
);

// http response 拦截器
axiosInstance.interceptors.response.use(
	response => {
		return response;
	},
	error => {
		if(error.response) {
			switch(error.response.status) {
				case 401:
					// 401 清除token信息并跳转到登录页面
					store.commit(types.LOGOUT);
					router.replace({
						path: 'login',
						query: {
							redirect: router.currentRoute.fullPath
						}
					})
			}
		}
		return Promise.reject(error.response.data)
	}
);



export default axiosInstance;

export function fetch(url, params = {}) {
	return new Promise((resolve, reject) => {
		axios.get(url, {
			params: params
		}).then(response => {
			resolve(response.data);
		}).catch(err => {
			reject(err)
		});
	});
}

export function post(url, data = {}) {
	return new Promise((resolve, reject) => {
			axios.post(url, data)
				.then(response => {
					resolve(response.data);
				}, err => {
					reject(err)
				});

	});
}

export function patch(url, data = {}) {
	return new Promise((resolve, reject) => {
			axios.patch(url, data)
				.then(response => {
					resolve(response.data);
				}, err => {
					reject(err)
				});
	});
}

export function put(url, data = {}) {
	return new Promise((resolve, reject) => {
		axios.put(url, data)
			.then(response => {
				resolve(response.data)
			}, err => {
				reject(err);
			})
	});
}
