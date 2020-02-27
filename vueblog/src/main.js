import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import './styles/element-variables.scss'
import 'font-awesome/css/font-awesome.min.css'
import './utils/filter_utils.js'
import axios from 'axios'

axios.defaults.withCredentials=true
Vue.prototype.$http = axios
Vue.config.productionTip = false

import echarts from "echarts";
Vue.prototype.$echarts = echarts;

Vue.use(ElementUI)
Vue.config.productionTip = false

window.bus = new Vue();
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App}
})
