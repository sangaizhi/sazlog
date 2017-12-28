import Vue from 'vue';
import App from './App.vue';
// 导入 element ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 导入 vue-cookie
import vueCookie from 'vue-cookie';
// 导入 moment
import moment from 'moment';
Object.defineProperty(Vue.prototype, '$moment', { value: moment });

// 导入 mavon-editor：一款  Markdown 插件
import mavonEditor from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';

// 导入本地存储
import store from './store/store.js';
// 导入 vue-router
import router from './router/router.js';
// 导入验证 js
import './validate/validate.js';
// 导入系统常量js
import './assets/js/constants.js';

// 导入自定义 css
import './assets/css/style.css';
import './assets/css/font_awesome_element.css';

Vue.use(ElementUI);
Vue.use(vueCookie);
Vue.use(mavonEditor);



new Vue({
  el: '#app',
  store,
  router,
  render: h => h(App)
})
