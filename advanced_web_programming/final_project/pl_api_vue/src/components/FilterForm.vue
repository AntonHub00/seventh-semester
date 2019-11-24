<template>
  <div>
    <form @submit.prevent="sendFormData">
      <div class="row">
        <div class="form-group col">
          <select class="form-control" v-model="scope" required>
            <option value="all">All</option>
            <option value="byName">By name</option>
            <option value="byParadigm">By paradigm</option>
          </select>
        </div>

        <div class="form-group col" v-if="scope == 'byName'">
          <input type="text" class="form-control" v-model="pl_name" placeholder="Name" required />
        </div>

        <div class="form-group col" v-if="scope == 'byParadigm'">
          <select class="form-control" v-model="paradigmPicked" required>
            <option
              v-for="(item, index) in $paradigms"
              :key="index"
              :value="item.value"
            >{{item.name}}</option>
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
      paradigmPicked: "object-oriented"
    };
  },
  methods: {
    sendFormData() {
      this.$emit("receive-form-data", this);
    }
  }
};
</script>

<style scoped>
</style>