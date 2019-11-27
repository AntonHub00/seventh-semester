<template>
  <div>
    <form class="form" @submit.prevent="performFormAction">
      <!-- name -->
      <div class="row">
        <div class="form-group col">
          <input v-model="plNameInput" type="text" class="form-control" placeholder="Name" required />
        </div>

        <!-- object-oriented paradigm checkbox -->
        <div class="form-group col" v-for="(item, index) in paradigms" :key="index">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              :id="item.id"
              :value="item.id"
              v-model="plParadigms"
            />
            <label class="form-check-label" :for="item.id">{{item.name}}</label>
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
          >{{submitButtonText}}</button>
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
        <tr v-for="(item, index) in languages" :key="index">
          <th scope="row">{{item.id}}</th>
          <td>{{item.name}}</td>
          <td>
            <!-- set update button -->
            <button @click="setUpdate(item.id)" type="button" class="btn btn-warning">Update</button>
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
      languages: [],
      paradigms: [],
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
        console.log(this.imageToShow);
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

      var languageToUpdate = this.languages.filter(
        language => language.id == id
      );

      languageToUpdate = languageToUpdate[0];

      this.plParadigms = this.paradigms
        .filter(paradigm => languageToUpdate.paradigms.includes(paradigm.name))
        .map(paradigm => paradigm.id);

      this.idToUpdate = id;
      this.plNameInput = languageToUpdate.name;
      this.plFirstAppearedInput = languageToUpdate.firstAppeared;
      this.plLastVersionInput = languageToUpdate.lastVersion;
      this.plCreatorInput = languageToUpdate.creator;
      this.plDescriptionInput = languageToUpdate.description;
      this.plImageInput = languageToUpdate.image;

      this.imageToShow = languageToUpdate.image;
    },
    async performFormAction() {
      if (this.createOrUpdate === "create") {
        await this.createLanguage();
      } else {
        await this.updateLanguage();
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
      payload["image"] = this.plImageInput;

      return payload;
    },
    async createLanguage() {
      await this.$axios
        .post(`${this.$BaseUrl}languages/`, this.setPayload(), {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => {
          alert("language create successfully");
          console.log(response);
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });

      await this.getLanguages();
    },
    async updateLanguage() {
      await this.$axios
        .put(
          `${this.$BaseUrl}languages/${this.idToUpdate}/`,
          this.setPayload(),
          {
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(response => {
          alert("language updated successfully");
          console.log(response);
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });

      await this.getLanguages();
      this.cancelUpdate();
    },
    async deleteLanguage(id) {
      await this.$axios
        .delete(`${this.$BaseUrl}languages/${id}/`, {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => {
          alert("language deleted successfully");
          console.log(response);
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });

      await this.getLanguages();
    },
    getLanguages() {
      return this.$axios
        .get(this.$BaseUrl + "languages/", {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => {
          this.languages = response.data;
          console.log(this.languages);
        })
        .catch(error => {
          alert("Server request failed");
          console.log(error);
        });
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
    }
  },
  async created() {
    await this.getLanguages();
    await this.getParadigms();
  }
};
</script>

<style>
</style>
