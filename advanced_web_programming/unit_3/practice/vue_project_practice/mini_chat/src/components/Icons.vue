<template>
  <div>

    <button v-on:click="$emit('send-icon', icon.content)">{{icon.content}}</button>

  </div>
</template>

<script>
export default {
  name: "Icons",
  props: ["icon"]
};
</script>

<style scoped>
button {
  float: left;
  width: 50px;
}
</style>