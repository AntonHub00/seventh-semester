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
import CreatePL from './components/CreatePL.vue';
import UpdatePL from './components/UpdatePL.vue';
import DeletePL from './components/DeletePL.vue';

// Routes settings
Vue.use(VueRouter);

const routes = [
  { path: '/', component: MainView },
  { path: '/create', component: CreatePL },
  { path: '/update', component: UpdatePL },
  { path: '/delete', component: DeletePL },
]

const router = new VueRouter({
  routes,
  mode: 'history'
});

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
