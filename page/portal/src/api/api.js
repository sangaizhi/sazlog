import axiosInstance from '../util/http.js';

let base = '/blog-admin';

let ssoUrl = "http://127.0.0.1:8082/blog-sso";

let domainUrl = "http://127.0.0.1:8083/blog-admin";

/**
 * 请求登录 
 */
export const requestLogin = params => {
	return axiosInstance.post(`${ssoUrl}/login`, params).then(res => res.data);
};

/**
 * 通过token 获取用户信息 
 */
export const getUserByToken = params => {
	return axiosInstance.get(`${ssoUrl}/getUserByToken`, {params:params}).then(res => res.data);
};


	