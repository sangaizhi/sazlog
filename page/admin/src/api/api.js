import axiosInstance from '../util/http.js';

let base = '/blog-admin';

//let ssoUrl = "http://127.0.0.1:8082/blog-sso";
//
//let domainUrl = "http://127.0.0.1:8083/blog-admin";
let ssoUrl = "http://112.74.41.215/blog-sso";
let domainUrl = "http://112.74.41.215/blog-admin";

/**
 * 请求登录 
 */
export const userLogin = params => {
	return axiosInstance.post(`${ssoUrl}/admin/login`, params).then(res => res.data);
};

/**
 * 请求登出
 */
export const userLogout = params => {
	return axiosInstance.get(`${ssoUrl}/admin/logout`, {params:params}).then(res=>res.data);
}

/**
 * 通过token 获取用户信息 
 */
export const getUserByToken = params => {
	return axiosInstance.get(`${ssoUrl}/admin/getAdminByToken`, {params:params}).then(res => res.data);
};
	
/**
 * 请求获取分类列表 
 */
export const requestCategoryList = params =>{
	return axiosInstance.get(`${domainUrl}/category/list`,{params:params}).then(res => res.data);
}

/**
 * 删除分类
 */
 export const deletrCategory = params =>{
 	return axiosInstance.delete(`${domainUrl}/category/delete/${params}`,{params:params}).then(res => res.data);
 }
 
 /**
  * 新增分类
  */
 export const addCategory = params => {
 	return axiosInstance.post(`${domainUrl}/category/add`, params).then(res => res.data);
 }

/**
 * 获取分类信息
 */
export const getCategoryById = params => {
	return axiosInstance.get(`${domainUrl}/category/getById/${params}`,{}).then(res => res.data);
}

/**
 * 修改分类信息
 */
export const editCategory = params => {
	return axiosInstance.post(`${domainUrl}/category/edit`, params).then(res => res.data);
}

/**
 * 请求博文列表
 */
export const requestArticleList = params => {
	return axiosInstance.get(`${domainUrl}/article/list`,{params:params}).then(res => res.data);
}

/**
 * 新增博文
 */
export const addArticle = params => {
	return axiosInstance.post(`${domainUrl}/article/add`, params).then(res => res.data);
}

/**
 * 编辑博文
 */
export const editArticle = params => {
	return axiosInstance.post(`${domainUrl}/article/edit`, params).then(res => res.data);
}

/**
 * 通過 Id 获取详细信息
 */
export const getArticleById = params =>{
	return axiosInstance.get(`${domainUrl}/article/getById/${params}`,{}).then(res => res.data);
}

/**
 * 刪除博文
 */
export const deleteArticle = params => {
	return axiosInstance.get(`${domainUrl}/article/delete/${params}`,{}).then(res => res.data);
}

/**
 * 刪除博文标签
 */
export const deleteArticleLabel = params =>{
	return axiosInstance.post(`${domainUrl}/article/deleteLabel`, params).then(res => res.data);
}

/**
 * 获取用户列表
 */
export const requestUserList = params => {
	return axiosInstance.get(`${domainUrl}/user/list`,{params:params}).then(res => res.data);
}

/**
 * 删除用户列表
 */
export const deleteUser = params => {
	return axiosInstance.get(`${domainUrl}/user/delete/${params}`,{}).then(res => res.data);
}

/**
 * 激活用户
 */
export const activeUser = params => {
	return axiosInstance.get(`${domainUrl}/user/active/${params}`,{}).then(res => res.data);
}

/**
 * 锁定用户
 */
export const lockUser = params => {
	return axiosInstance.get(`${domainUrl}/user/lock/${params}`,{}).then(res => res.data);
}

/**
 * 解锁用户
 */
export const unLockUser = params => {
	return axiosInstance.get(`${domainUrl}/user/unlock/${params}`,{}).then(res => res.data);
}

/**
 * 禁用用户
 */
export const disableUser = params => {
	return axiosInstance.get(`${domainUrl}/user/disable/${params}`,{}).then(res => res.data);
}

/**
 * 启用用户
 */
export const enableUser = params => {
	return axiosInstance.get(`${domainUrl}/user/enable/${params}`,{}).then(res => res.data);
}

/**
 * 根据Id获取用户信息
 */
export const getUserById = params => {
	return axiosInstance.get(`${domainUrl}/user/getById/${params}`,{}).then(res => res.data);
}

/**
 * 新增用户
 */
export const addUser = params => {
	return axiosInstance.post(`${domainUrl}/user/add`, params).then(res => res.data);
}

/**
 * 核对用户的手机号是否占用
 */
export const checkPhoneUsable = params => {
	return axiosInstance.get(`${domainUrl}/user/checkPhoneUsable/${params}`,{}).then(res => res.data);
}

/**
 * 核对用户的邮箱是否占用
 * 由于邮箱有后缀，所以采用 get 请求的时候, "."后面的会被砍掉
 */
export const checkEmailUsable = params => {
	return axiosInstance.post(`${domainUrl}/user/checkEmailUsable`,params).then(res => res.data);
}

/**
 * 编辑用户
 */
export const editUser = params => {
	return axiosInstance.post(`${domainUrl}/user/edit`, params).then(res => res.data);
}


/**
 * 请求工具箱列表
 */
export const requestKitboxList = params =>{
	return axiosInstance.get(`${domainUrl}/kitbox/list`,{params:params}).then(res => res.data);
}

/**
 * 新增工具箱
 */
export const addKitbox = params =>{
	return axiosInstance.post(`${domainUrl}/kitbox/add`, params).then(res => res.data);
}

/*
 * 重命名工具箱
 */
export const renameKitbox = params =>{
	return axiosInstance.get(`${domainUrl}/kitbox/rename/${params}`,{}).then(res => res.data);
}

/**
 * 删除工具集
 */
export const deleteKitBox = params =>{
	return axiosInstance.get(`${domainUrl}/kitbox/delete/${params}`,{}).then(res => res.data);
}
