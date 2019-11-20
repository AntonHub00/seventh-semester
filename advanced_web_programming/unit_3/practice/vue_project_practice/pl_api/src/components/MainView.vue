<template>
  <div>
    <filter-form @receive-form-data="setPayload" />
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
      response: [
        {
          id: 1,
          image:
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1024px-Python-logo-notext.svg.png",
          name: "python",
          description:
            "Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991",
          paradigm: ["object-oriented", "functional", "imperative"],
          firstAppeared: 1990,
          lastVersion: "3.8.0",
          creator: "Guido van Rossum"
        },
        {
          id: 2,
          image:
            "https://www.clker.com/cliparts/d/5/5/3/1242257669472701825NYCS-bull-trans-C.svg.hi.png",
          name: "c",
          description:
            "C is a general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, while a static type system prevents unintended operations",
          paradigm: ["imperative", "structured"],
          firstAppeared: 1972,
          lastVersion: "C18",
          creator: "Dennis Ritchie"
        },
        {
          id: 3,
          image:
            "https://cdn2.iconfinder.com/data/icons/designer-skills/128/code-programming-java-software-develop-command-language-512.png",
          name: "java",
          description:
            "Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.",
          paradigm: ["generic", "object-oriented"],
          firstAppeared: 1995,
          lastVersion: "Java SE 13",
          creator: "James Gosling"
        }
      ]
    };
  },
  methods: {
    setPayload(data) {
      var payload = {};

      // Validate in back-end if all this data is set
      payload["scope"] = data.scope;
      payload["pl_name"] = data.pl_name;
      payload["paradigm"] = data.paradigm;

      console.log(payload);
      // return payload;
    }
  }
};
</script>

<style>
</style>
