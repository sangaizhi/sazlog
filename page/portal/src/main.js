import Vue from 'vue'
import App from './App.vue'

// 引入网络请求与资源组件
import VueResource from 'vue-resource';

// 引入 vue-form 表单验证
import VeeValidate from 'vee-validate';
import {validateConfig} from './util/validate.js';

// 引入 ElementUI UI 组件
//import ElementUI from 'element-ui'
//import 'element-ui/lib/theme-default/index.css'
// 引入图标组件
import Icon from './components/icon/Icon.vue';
// 引入VueBlu组件
import VueBlu from 'vue-blu';
import 'vue-blu/dist/css/vue-blu.min.css';


import './assets/css/index.css';
import 'font-awesome/css/font-awesome.css';
import $ from 'jquery';
import './icons/index.js';
//引入路由组件
import {axios,fetch,patch,post,put} from './util/http';

import store from './store/store';
import router from './router';

//开启debug模式
Vue.config.debug = true;

//Vue.use(VueRouter);
Vue.use(VueResource);
Vue.use(VeeValidate, validateConfig);
Vue.use(VueBlu);
Vue.component("icon", Icon);


Vue.prototype.$post=post;
Vue.prototype.$get=fetch;
Vue.prototype.$patch=patch;
Vue.prototype.$put=put;


// 现在我们可以启动应用了！
// 路由器会创建一个 App 实例，并且挂载到选择符 #app 匹配的元素上。
new Vue({
  el: '#app',
    router,
    store,
  render: h => h(App)
})