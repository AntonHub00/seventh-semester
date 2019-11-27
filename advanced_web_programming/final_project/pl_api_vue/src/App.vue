<template>
  <div id="app">
    <div class="container">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <router-link to="/" class="navbar-brand">PL API</router-link>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <router-link to="/" class="nav-link">Home</router-link>
            </li>
            <li class="nav-item active">
              <router-link to="/admin" class="nav-link">Admin</router-link>
            </li>
            <li class="nav-item active">
              <router-link to="/get-key" class="nav-link">Get key</router-link>
            </li>
          </ul>
        </div>
      </nav>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      response: []
    };
  }
};
</script>

<style>
</style>
