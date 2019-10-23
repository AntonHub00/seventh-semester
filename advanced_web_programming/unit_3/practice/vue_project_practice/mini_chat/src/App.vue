<template>
  <div>

    <h1>Mini chat</h1>

    <icons-input-boxes />

  </div>
</template>

<script>
import IconsInputBoxes from "./components/IconsInputBoxes.vue";

export default {
  name: "app",
  components: {
    IconsInputBoxes
  }
};
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
</style>