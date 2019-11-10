<template>
  <div id="app">
    <!-- <recommendation-card />
    <button class="btn btn-primary" v-on:click="do_request">Click me to get recommendations</button>
    <div v-for="(item, index) in response" v-bind:key="index">
      <li><b>Recommendation:</b> {{item['Recommendation']}}</li>
      <li><b>Applicable conditions:</b> {{item['Optional/applicable conditions']}}</li>
      <li><b>References:</b> {{item['References']}}</li>
      <br>
      <hr>
    </div>
    <app-form />-->
    <div class="container">
      <app-form />
      <!-- <recommendation-card /> -->
    </div>
  </div>
</template>

<script>
import AppForm from "./components/AppForm.vue";
// import RecommendationCard from "./components/RecommendationCard.vue";

export default {
  name: "app",
  components: {
    AppForm,
    // RecommendationCard
  },
  data() {
    return {
      response: []
    };
  },
  methods: {
    do_request() {
      this.$axios
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
          this.response = response.data.data;
          console.log(this.response);
        })
        .catch(error => {
          this.response = error;
          console.log(this.response);
        });
    }
  }
};
</script>

<style>
</style>