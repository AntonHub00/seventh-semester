import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';
import VueRouter from 'vue-router';

Vue.config.productionTip = false

// Global variables for axios request
Vue.prototype.$axios = axios;
Vue.prototype.$BaseUrl = "http://localhost:8080/";

// Importing components to use in routes
import MainView from './components/MainView.vue';
import Admin from './components/Admin.vue';
import GetKey from './components/GetKey.vue';

// Routes settings
Vue.use(VueRouter);

const routes = [
  { path: '/', component: MainView },
  { path: '/admin', component: Admin },
  { path: '/get-key', component: GetKey },
]

const router = new VueRouter({
  routes,
  // mode: 'history'
});

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
