<template>
  <div id="app">
    <main-view />
    <button v-on:click="do_request">Click me to get recommendations</button>
    <li v-for="(the_var, index) in a_var" v-bind:key="index" >{{the_var.Recommendation}}</li>
  </div>
</template>

<script>
import MainView from "./components/MainView.vue";

export default {
  name: "app",
  components: {
    MainView
  },
  data() {
    return {
      a_var: []
    };
  },
  methods: {
    do_request() {
      // const axios = require("axios");
      console.log("hey");

      this.$axios
        // .get(this.$BaseUrl+'all', {
        .get(this.$BaseUrl + "all", {
          headers: {
            Authorization:
              "Bearer 689b0a159879332335d84b6ff4a61a0e6c1619fd8022c39e95ad5d9d3f81"
          },
          params: {
            conditions: "dm"
          }
        })
        .then(response => {
          this.a_var = response.data.data;
          console.log(this.a_var);
        })
        .catch(error => {
          this.a_var = error;
          console.log(this.a_var);
        });
    }
  }
};
</script>

<style>
</style>