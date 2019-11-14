<template>
  <div>
    <div class="card" style="border:1px solid black">
      <div class="card-body">
        <h6 class="card-title" v-if="recommendation['Recommendation']">Recommendation</h6>
        <p class="card-text">{{recommendation["Recommendation"]}}</p>
      </div>
      <div class="card-body" v-if="recommendation['Optional/applicable conditions']">
        <h6 class="card-title">Optional/applicable contidions</h6>
        <p class="card-text">{{recommendation["Optional/applicable conditions"]}}</p>
      </div>
      <div class="card-body" v-if="recommendation['References']">
        <h6 class="card-title">References</h6>
        <p class="card-text">{{recommendation["References"]}}</p>
      </div>
    </div>
    <br />
  </div>
</template>

<script>
export default {
  name: "RecommendationCard",
  props: ["recommendation"],
  data() {
    return {
      formatedRecommendation: [],
      formatedOptional: [],
      formatedReferences: []
    };
  }
};
</script>

<style scoped>
</style>