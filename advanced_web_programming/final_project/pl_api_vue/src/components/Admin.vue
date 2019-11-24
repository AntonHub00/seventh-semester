<template>
  <div>
    <form class="form" @submit.prevent="performFormAction">
      <!-- name -->
      <div class="row">
        <div class="form-group col">
          <input v-model="plNameInput" type="text" class="form-control" placeholder="Name" required />
        </div>

        <!-- object-oriented paradigm checkbox -->
        <div class="form-group col" v-for="(item, index) in $paradigms" :key="index">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              :id="item.value"
              :value="item.value"
              v-model="plParadigms"
            />
            <label class="form-check-label" :for="item.value">{{item.name}}</label>
          </div>
        </div>
      </div>

      <div class="row">
        <!-- first appeared -->
        <div class="form-group col">
          <input
            v-model="plFirstAppearedInput"
            type="number"
            class="form-control"
            placeholder="First appeared"
            required
          />
        </div>

        <!-- last version -->
        <div class="form-group col">
          <input
            v-model="plLastVersionInput"
            type="text"
            class="form-control"
            placeholder="Last version"
            required
          />
        </div>

        <!-- creator -->
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

      <!-- description -->
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

      <!-- image -->
      <div class="row">
        <div class="input-group col mb-3">
          <div class="custom-file" v-if="!imageToShow">
            <input
              @change="onFileChange"
              type="file"
              class="custom-file-input"
              id="image_file"
              accept=".png, .jpg, .jpeg"
            />
            <label
              class="custom-file-label"
              for="image_file"
              aria-describedby="image_file"
            >Choose image (optional)</label>
          </div>

          <!-- remove image button -->
          <div v-else>
            <img :src="imageToShow" style="max-width:400px;" />
            <button @click="removeImage" class="btn btn-danger mx-4">Remove image</button>
          </div>
        </div>
      </div>

      <!-- form create/update buttons -->
      <div class="row">
        <div class="form-group col text-center">
          <!-- form create button -->
          <button
            @click="createOrUpdate='create'"
            type="submit"
            v-if="!updating"
            class="btn m-2 btn-primary"
          >{{submitButtonText}}</button>

          <!-- form update button -->
          <button
            @click="createOrUpdate='update'"
            type="submit"
            v-if="updating"
            class="btn m-2 btn-success"
          >Update</button>
          <!-- cancel update button -->
          <button @click="cancelUpdate" v-if="updating" class="btn btn-danger">Cancel</button>
        </div>
      </div>
    </form>

    <!-- languages table -->
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
            <!-- set update button -->
            <button
              @click="setUpdate(item.id)"
              :id="item.id"
              type="button"
              class="btn btn-warning"
            >Update</button>
          </td>
          <td>
            <!-- delete button -->
            <button @click="deleteLanguage(item.id)" type="button" class="btn btn-danger">Delete</button>
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
          id: 11,
          // image:
          //   "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1024px-Python-logo-notext.svg.png",
          name: "python",
          description:
            "Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991",
          paradigms: ["object-oriented", "functional", "imperative"],
          firstAppeared: 1990,
          lastVersion: "3.8.0",
          creator: "Guido van Rossum"
        },
        {
          id: 12,
          image:
            "https://www.clker.com/cliparts/d/5/5/3/1242257669472701825NYCS-bull-trans-C.svg.hi.png",
          name: "c",
          description:
            "C is a general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, while a static type system prevents unintended operations",
          paradigms: ["imperative", "structured"],
          firstAppeared: 1972,
          lastVersion: "C18",
          creator: "Dennis Ritchie"
        },
        {
          id: 13,
          image:
            "https://cdn2.iconfinder.com/data/icons/designer-skills/128/code-programming-java-software-develop-command-language-512.png",
          name: "java",
          description:
            "Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.",
          paradigms: ["generic", "object-oriented"],
          firstAppeared: 1995,
          lastVersion: "Java SE 13",
          creator: "James Gosling"
        }
      ],
      imageToShow: "",
      updating: false,
      createOrUpdate: "",
      idToUpdate: null,

      // Form style variables
      submitButtonText: "Create",

      // Inputs
      plNameInput: "",
      plFirstAppearedInput: "",
      plLastVersionInput: "",
      plCreatorInput: "",
      plDescriptionInput: "",
      plImageInput: null,

      //Paradigm checkboxes
      plParadigms: []
    };
  },
  methods: {
    onFileChange(e) {
      var files = e.target.files || e.dataTransfer.files;

      if (!files.length) return;

      this.plImageInput = files[0];
      this.createImage(this.plImageInput);
    },
    createImage(image) {
      var reader = new FileReader();

      reader.onload = e => {
        this.imageToShow = e.target.result;
      };

      reader.readAsDataURL(image);
    },
    removeImage() {
      // Remove image to show and clear file input
      this.imageToShow = "";
      this.plImageInput = null;
    },
    cancelUpdate() {
      // Set style
      this.updating = false;
      this.submitButtonText = "Create";
      this.idToUpdate = null;

      this.removeImage();

      // Clear form
      this.plNameInput = "";
      this.plFirstAppearedInput = "";
      this.plLastVersionInput = "";
      this.plCreatorInput = "";
      this.plDescriptionInput = "";
      this.plParadigms = [];
    },
    setUpdate(id) {
      this.removeImage();
      this.updating = true;
      this.submitButtonText = "Update";

      var languageToUpdate = this.response.filter(
        language => language.id == id
      );

      languageToUpdate = languageToUpdate[0];

      this.plNameInput = languageToUpdate.name;
      this.plFirstAppearedInput = languageToUpdate.firstAppeared;
      this.plLastVersionInput = languageToUpdate.lastVersion;
      this.plCreatorInput = languageToUpdate.creator;
      this.plDescriptionInput = languageToUpdate.description;
      this.plParadigms = languageToUpdate.paradigms;
      this.plImageInput = null; // Set image parameter properly

      this.imageToShow = languageToUpdate.image;

      this.idToUpdate = id;
    },
    performFormAction() {
      if (this.createOrUpdate === "create") {
        this.createLanguage();
      } else {
        this.updateLanguage();
      }
    },
    setPayload() {
      var payload = {};

      payload["name"] = this.plNameInput;
      payload["paradigms"] = this.plParadigms;
      payload["firstAppeared"] = this.plFirstAppearedInput;
      payload["lastVersion"] = this.plLastVersionInput;
      payload["creator"] = this.plCreatorInput;
      payload["description"] = this.plDescriptionInput;
      payload["image"] = null; // set image parameter properly

      return payload;
    },
    createLanguage() {
      console.log("creating...");
      //Set here the create request
      this.setPayload();
    },
    updateLanguage() {
      console.log(`updating ${this.idToUpdate}...`);
      //Set here the update request
      this.setPayload();
    },
    deleteLanguage(id) {
      console.log(`deleting ${id}...`);
      //Set here the delete request
    }
  }
};
</script>

<style>
</style>
