import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';

Vue.config.productionTip = false;

Vue.prototype.$axios = axios;
Vue.prototype.$BaseUrl = "http://localhost:8080/";

new Vue({
  render: h => h(App),
}).$mount('#app')
