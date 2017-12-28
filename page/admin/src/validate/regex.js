export function isMobile(value){
	return value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value);
}
export function isEmail(value){
	return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
}
