import Vue from 'vue';
import VeeValidate, { Validator } from 'vee-validate';
import zh_CN from 'vee-validate/dist/locale/zh_CN';


// 自定义 validate
const dictionary = {
	zh_CN: {
		messages: {
			email: () => '请输入正确的邮箱格式',
			required: (field) => "请输入" + field
		},
		attributes: {
			email: '邮箱',
			password: '密码',
			name: '账号',
			phone: '手机',
			loginUserAccount: '账号',
			loginUserPassword:'密码'
		}
	}
}

const config = {
	errorBagName: 'errors', // change if property conflicts.
	fieldsBagName: 'veeFields',
	delay: 0,
	locale: 'zh_CN',
	dictionary:dictionary,
	strict: true,
	enableAutoClasses: false,
	classNames: {
		touched: 'touched', // the control has been blurred
		untouched: 'untouched', // the control hasn't been blurred
		valid: 'valid', // model is valid
		invalid: 'invalid', // model is invalid
		pristine: 'pristine', // control has not been interacted with
		dirty: 'dirty' // control has been interacted with
	},
	events: 'blur',
	inject: true
}

Vue.use(VeeValidate, config);

//Validator.updateDictionary(dictionary);

const phoneValidator = {
  getMessage(field, params, data) {
      return (data && data.message) || 'phone error';
  },
  validate(value) {
    return new Promise(resolve => {
      resolve({
        valid: value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)
      });
    });
  }
};

//Validator.extend('phone', {
//	messages: {
//		zh_CN: field => field + '必须是11位手机号码',
//	},
//	validate: value => {
//		return value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)
//	}
//})

Validator.extend('phone', phoneValidator);


const loginUserAccountValitor = {
  getMessage(field, params, data) {
      return (data && data.message) || 'login account error';
  },
  validate(value) {
    return new Promise(resolve => {
      resolve({
        valid: (value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)) || /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value)
      });
    });
  }
}

Validator.extend('loginUserAccount', loginUserAccountValitor);

//Validator.extend('loginUserAccount',{
//	messages:{
//		zh_CN:field => "请输入正确的手机号或邮箱",
//	},
//	validate:value => {
//		return (value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)) || /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
//	}
//})
