<template>
  <div>
    <div v-for="icon in icons" v-bind:key="icon.id">
      <icons v-bind:icon="icon" v-on:send-icon="insertIcon" />
    </div>

    <form action v-on:submit="postText">
      <input
        type="text"
        name
        id
        placeholder="Insert text here"
        v-model="input_value"
        onblur="this.focus()"
        autofocus
      />
      <input type="submit" v-bind:class="[update_box ? update_class : add_class]" v-bind:value="add_update" />
    </form>

    <div v-for="box in boxes" v-bind:key="box.id" >
      <box v-bind:box="box" v-on:delete-box="deleteBox" v-on:edit-box="editBox" v-if="re_render_boxes"/>
    </div>
  </div>
</template>

<script>
import Icons from "./Icons.vue";
import Box from "./Box.vue";

export default {
  name: "IconsInputBoxes",
  components: {
    Icons,
    Box
  },
  data() {
    return {
      icons: [
        {
          id: 1,
          content: "A"
        },
        {
          id: 2,
          content: "B"
        },
        {
          id: 3,
          content: "C"
        }
      ],
      input_value: "",
      boxes: [],
      update_box: false,
      box_id_to_update: "",
      re_render_boxes: true,
      add_update: "add",
      add_class: "add",
      update_class: "update"
    };
  },
  methods: {
    insertIcon(content) {
      this.input_value += content;
    },
    deleteBox(to_delete_box_id) {
      this.boxes = this.boxes.filter(boxes => boxes.id != to_delete_box_id);
    },
    editBox(to_edit_box_id) {
      this.update_box = true;
      this.add_update= 'update'
      this.input_value = to_edit_box_id;
      this.box_id_to_update = to_edit_box_id;
    },
    postText(e) {
      if(this.update_box){

        e.preventDefault();


        for(var box in this.boxes){
          if ((this.boxes[box].id) == this.box_id_to_update){
            this.boxes[box].id = this.input_value;
            this.boxes[box].content = this.input_value;
          }
        }

        this.add_update= 'add'
        this.input_value = ''
        this.update_box = false;
        this.re_render_boxes = false;
        this.$nextTick(()=>{
          this.re_render_boxes = true;
        });

      }else{

        e.preventDefault();

        this.boxes.push({
          id: this.input_value,
          content: this.input_value
        });

        this.input_value = "";

      }
    }
  }
};
</script>

<style scoped>
.add{
    color: white;
    background-color: blue;
}

.update{
    color: black;
    background-color: yellow;
}
</style>
