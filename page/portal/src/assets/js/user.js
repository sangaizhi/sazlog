export function saveUser(userInfo){
	window.localStorage.removeItem("userInfo");
	window.localStorage.setItem("userInfo", JSON.stringify(userInfo));
}
