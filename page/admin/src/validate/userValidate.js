import {checkPhoneUsable,checkEmailUsable} from "../api/api.js";

/**
 * 远程校验用户手机号是否可用
 */
export function remoteCheckUserPhoneUsable(rule, value, callback){
	if(value == ""){
		callback();
	}
	var result = /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value);
	if(result){
		checkPhoneUsable(value).then(function(response){
			if(response.status){
				callback();
			}else{
				callback(new Error("该手机号已经被占用"));
			}
		},function(response){
			callback(new Error("远程校验发生错误"));
		});
	}
}

/**
 * 远程校验用户的邮箱是否可用
 */
export function remoteCheckUserEmailUsable(rule, value, callback){
	if(value == ""){
		callback();
	}
	var result = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
	if(result){
		var param = {
			'email':value
		}
		checkEmailUsable(param).then(function(response){
			if(response.status){
				callback();
			}else{
				callback(new Error("该邮箱已经被占用"));
			}
		},function(response){
			callback(new Error("远程校验发生错误"));
		});
	}
}

