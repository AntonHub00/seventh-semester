<template>
  <div>
    <div class="alert alert-danger alert-dismissible fade show" role="alert" v-if="fileError">
      <strong>File error:</strong> Only jpg, jpeg and png extentions are allowed in the file name
      and separated with "_".
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

    <form class="form">
      <div class="row">
        <div class="form-group col">
          <input v-model="plNameInput" type="text" class="form-control" placeholder="Name" required />
        </div>

        <div class="form-group col">
          <input
            v-model="plParadigmInput"
            type="text"
            class="form-control"
            placeholder="Paradigm"
            required
          />
        </div>

        <div class="form-group col">
          <input
            v-model="plFirstAppearedInput"
            type="number"
            class="form-control"
            placeholder="First appeared"
            required
          />
        </div>

        <div class="form-group col">
          <input
            v-model="plLastVersionInput"
            type="text"
            class="form-control"
            placeholder="Last version"
            required
          />
        </div>

        <div class="form-group col">
          <input
            v-model="plCreatorInput"
            type="text"
            class="form-control"
            placeholder="Creator"
            required
          />
        </div>
      </div>

      <div class="row">
        <div class="form-group col">
          <textarea
            v-model="plDescriptionInput"
            class="form-control"
            rows="3"
            placeholder="Description"
            required
          ></textarea>
        </div>
      </div>

      <div class="row">
        <div class="input-group col mb-3">
          <div class="custom-file" v-if="!image">
            <input
              @change="onFileChange"
              type="file"
              class="custom-file-input"
              id="image_file"
              required
            />
            <label
              class="custom-file-label"
              for="image_file"
              aria-describedby="image_file"
            >Choose image</label>
          </div>

          <div v-else>
            <img :src="image" style="max-width:400px;" />
            <button @click="removeImage" class="btn btn-danger mx-4">Remove image</button>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="form-group col text-center">
          <button type="submit" v-bind:class="[updating ? updatingStyle : creatingSytle]">Create</button>
        </div>
      </div>
    </form>

    <table class="table table-striped text-center">
      <thead>
        <tr>
          <th scope="col">id</th>
          <th scope="col">name</th>
          <th scope="col">Update</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in response" :key="index">
          <th scope="row">{{item.id}}</th>
          <td>{{item.name}}</td>
          <td>
            <form>
              <button
                @click="setUpdate(item.id)"
                :id="item.id"
                type="button"
                class="btn btn-warning"
              >Update</button>
            </form>
          </td>
          <td>
            <form>
              <button :id="item.id" type="button" class="btn btn-danger">Delete</button>
            </form>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "Admin",
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
      ],
      image: "",
      fileError: false,
      updating: false,

      // Style (classes)
      updatingStyle: "btn my-2 btn-primary",
      creatingStyle: "btn my-2 btn-warning",

      // Inputs
      plNameInput: "",
      plParadigmInput: "",
      plFirstAppearedInput: "",
      plLastVersionInput: "",
      plCreatorInput: "",
      plDescriptionInput: ""
    };
  },
  methods: {
    isImage(fileName) {
      var regex = /^(\w+\.(jpeg|jpg|png)$)/;

      console.log(fileName);

      return regex.test(fileName);
    },
    onFileChange(e) {
      var files = e.target.files || e.dataTransfer.files;

      if (!files.length) return;

      if (!this.isImage(e.target.files[0].name)) {
        this.fileError = true;
        return;
      } else {
        this.fileError = false;
      }

      this.createImage(files[0]);
    },
    createImage(file) {
      var reader = new FileReader();

      reader.onload = e => {
        this.image = e.target.result;
      };

      reader.readAsDataURL(file);
    },
    removeImage: function() {
      this.image = "";
    },

    setUpdate(id) {
      this.updating = true;

      var languageToUpdate = this.response.filter(
        language => language.id == id
      );

      languageToUpdate = languageToUpdate[0];

      this.plNameInput = languageToUpdate.name;
      this.plParadigmInput = languageToUpdate.paradigm;
      this.plFirstAppearedInput = languageToUpdate.firstAppeared;
      this.plLastVersionInput = languageToUpdate.lastVersion;
      this.plCreatorInput = languageToUpdate.creator;
      this.plDescriptionInput = languageToUpdate.description;

      console.log(languageToUpdate);
    }
  }
};
</script>

<style>
</style>
