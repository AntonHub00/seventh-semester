<template>
  <div>
    <div class="card col m-3" style="width: 18rem; height: 100%;">
      <img :src="language.image" class="card-img-top" alt="..." />
      <div class="card-body">
        <h5 class="card-title text-center">{{language.name}}</h5>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">
            <b>Description:</b>
            {{language.description}}
          </li>
          <li class="list-group-item">
            <b>Paradigm:</b>
            {{language.paradigm.join(", ")}}
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
          <li class="list-group-item">
            <button :id="language.id" type="button" class="btn btn-warning col m-1">Update</button>
            <button :id="language.id" type="button" class="btn btn-danger col m-1">Delete</button>
          </li>
        </ul>
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
