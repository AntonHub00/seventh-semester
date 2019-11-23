<template>
  <div>
    <div class="card row mb-3">
      <div class="row no-gutters">
        <div class="col-md-4">
          <img :src="language.image" class="card-img-top" v-if="language.image" />
          <img
            src="https://library.ucf.edu/wp-content/uploads/sites/5/2015/08/photo-not-available.jpg"
            class="card-img-top"
            v-else
          />
        </div>
        <div class="col-md-8">
          <h5 class="card-title text-center">{{language.name}}</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              <b>Description:</b>
              {{language.description}}
            </li>
            <li class="list-group-item">
              <b>Paradigm(s):</b>
              {{language.paradigms.join(", ")}}
            </li>
            <li class="list-group-item">
              <b>First appeared:</b>
              {{language.firstAppeared}}
            </li>
            <li class="list-group-item">
              <b>Last version:</b>
              {{language.lastVersion}}
            </li>
            <li class="list-group-item">
              <b>Creator:</b>
              {{language.creator}}
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Card",
  props: ["language"]
};
</script>

<style>
</style>
