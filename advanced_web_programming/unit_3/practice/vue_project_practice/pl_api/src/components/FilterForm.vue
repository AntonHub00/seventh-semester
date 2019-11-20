<template>
  <div>
    <form @submit="sendFormData">
      <div class="row">
        <div class="form-group col">
          <select
            class="form-control"
            v-model="scope"
            @change="pl_name = scope == 'all' ? '' : pl_name;
            paradigm = scope == 'all' ? '' : paradigm;"
            required
          >
            <option value="all">All</option>
            <option value="personalized">Personalized</option>
          </select>
        </div>

        <div class="form-group col" v-if="scope == 'personalized'">
          <input type="text" class="form-control" v-model="pl_name" placeholder="Name (optional)" />
        </div>

        <div class="form-group col" v-if="scope == 'personalized'">
          <select class="form-control" v-model="paradigm" required>
            <option value="oo">Object-oriented</option>
            <option value="functional">Functional</option>
            <option value="imperative">Imperative</option>
          </select>
        </div>

        <div class="form-group col">
          <button type="submit" class="btn btn-primary btn-block">Search</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "FilterForm",
  data() {
    return {
      scope: "all",
      pl_name: "",
      paradigm: "oo"
    };
  },
  methods: {
    sendFormData(e) {
      e.preventDefault();
      this.$emit("receive-form-data", this);
    }
  }
};
</script>

<style scoped>
</style>