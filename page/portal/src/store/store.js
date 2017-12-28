/**
 * Created by superman on 17/2/16.
 */
import Vuex from 'vuex'
import Vue from 'vue'
import * as types from './types'

Vue.use(Vuex);
export default new Vuex.Store({
	state: {
		user: {},
		token: null,
		title: '',
		breadListState: [{
			name: '首页',
			path: '/'
		}]
	},
	mutations: {
		[types.LOGIN]: (state, data) => {
			localStorage.token = data;
			state.token = data;
		},
		[types.LOGOUT]: (state) => {
			localStorage.removeItem('token');
			state.token = null
		},
		[types.TITLE]: (state, data) => {
			state.title = data;
		},
		breadListStateAdd(state, obj) {
			state.breadListState.push(obj);
		},
		breadListStateRemove(state, num) {
			state.breadListState.splice(num, state.breadListState.length - num);
		}
	}
})