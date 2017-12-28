/**
 * 手机号校验
 */
export function validatePhone(rule, value, callback){
	if(value == ""){
		callback();
	}
	var result = /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value);
	if(!result){
		callback(new Error("手机号格式错误"))
	}else{
		callback();
	}
}

/**
 * 邮箱格式校验
 */
export function validateEmail(rule, value, callback){
	if(value == ""){
		callback();
	}
	var result = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
	if(!result){
		callback(new Error("邮件地址格式错误"));
	}else{
		callback();
	}
}
