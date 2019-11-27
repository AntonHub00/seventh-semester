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
            <option v-for="(item, index) in paradigms" :key="index">{{item.name}}</option>
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
      paradigms: [],
      languages: [],
      scope: "all",
      pl_name: "",
      paradigmPicked: "Object-oriented"
    };
  },

  methods: {
    async sendFormData() {
      await this.findLanguages();
      this.$emit("receive-form-data", this.languages);
    },
    getParadigms() {
      return this.$axios
        .get(`${this.$BaseUrl}paradigms/`, {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => {
          this.paradigms = response.data;
          console.log(this.paradigms);
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });
    },
    findLanguages() {
      var toFindPath = "";

      if (this.scope === "byName") {
        toFindPath = `by-name/${this.pl_name}/`;
      } else if (this.scope === "byParadigm") {
        toFindPath = `by-paradigm/${this.paradigmPicked}/`;
      }

      return this.$axios
        .get(`${this.$BaseUrl}languages/${toFindPath}`, {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => {
          this.languages = response.data;
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });
    }
  },
  async created() {
    await this.getParadigms();
  }
};
</script>

<style scoped>
</style>