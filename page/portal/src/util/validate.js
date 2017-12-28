import { Validator } from 'vee-validate';
import zh_CN from 'vee-validate/dist/locale/zh_CN';
import dictionary from '../assets/js/dictionary.js';
import { isEmail } from './zblog-regex.js';

Validator.extend('mobile', {
	messages: {
		zh_CN: '此项必须是11位手机号码'
	},
	validate: value => {
		console.log(String(value).trim()+"sad");
		return String(value).trim().length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(String(value).trim().length)
	}
});
Validator.extend('loginAccountRequired', {
	messages: {
		en: (field, args) => {
			return 'login account is not null';
		},
		zh_CN: (field, args) => {
			return '登录账号不能为空';
		}
	},
	validate(value, params) {
		console.log("v1:"+value);
		var val = String(value).trim();
		console.log("v2:"+value);
		
		return val.length > 0;
	}
});
Validator.extend('loginAccount', {
	messages: {
		zh_CN: '账号只能是邮箱或者手机号'
	},
	validate: value => {
		var val = String(value).trim();
		return (val.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(val)) || /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(val);
	}
});

Validator.addLocale(zh_CN);
Validator.updateDictionary(dictionary);

export default Validator;

export const validateConfig = {
	errorBagName: 'errors', // change if property conflicts.
	fieldsBagName: 'fields',
	delay: 0,
	locale: 'zh_CN',
	dictionary: null,
	strict: true,
	classes: false,
	classNames: {
		touched: 'touched', // the control has been blurred
		untouched: 'untouched', // the control hasn't been blurred
		valid: 'valid', // model is valid
		invalid: 'invalid', // model is invalid
		pristine: 'pristine', // control has not been interacted with
		dirty: 'dirty' // control has been interacted with
	},
	events: 'input|blur',
	inject: true,
	validity: true,
	aria: true
}