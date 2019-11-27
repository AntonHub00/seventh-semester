<template>
  <div>
    <filter-form @receive-form-data="setResponse" />
    <div class="row justify-content-center">
      <card v-for="(item, index) in response" :key="index" :language="item" />
    </div>
  </div>
</template>

<script>
import Card from "./Card.vue";
import FilterForm from "./FilterForm.vue";

export default {
  name: "MainView",
  components: {
    Card,
    FilterForm
  },
  data() {
    return {
      response: []
    };
  },
  methods: {
    setResponse(data) {
      this.response = data;
    }
  }
};
</script>

<style>
</style>