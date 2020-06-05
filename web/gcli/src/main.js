// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

/* eslint-disable no-new */

// 方法五 :
require('@/assets/webpacktest.js');
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

// Axios 封装类
import requests from '@/assets/js/selfAxios.js'   // 记得改为你的路径

Vue.prototype.selfRequest = requests  // 此处命名为rq,你可以改

new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
