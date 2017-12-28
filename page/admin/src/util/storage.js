import { getUserByToken } from "../api/api.js";
/**
 * 保存用户信息到本地
 */
export function saveUser(user) {
	window.localStorage.removeItem("user");
	window.localStorage.setItem("user", JSON.stringify(user));
}

/**
 * 保存用户 token
 */
export function saveToken(token) {
	window.localStorage.removeItem("token");
	window.localStorage.setItem("token", token);
}

/**
 * 退出登录
 */
export function logout() {
	window.localStorage.removeItem("user");
	window.localStorage.removeItem("token");
}

	
export const requestAndSaveUser = params => {
	return getUserByToken(params).then(res => res);
}


