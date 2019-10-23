<template>
    <div>
        <button class="edit" v-on:click="$emit('edit-box', box.content)">edit</button>
        <button class="delete" v-on:click="$emit('delete-box', box.content)">delete</button>
        {{box.content}}
    </div>
</template>

<script>
export default {
    name : 'Box',
    props:['box']
}
</script>

<style scoped>
.delete{
    color: white;
    background-color: red;
}

.edit{
    color: white;
    background-color: green;
}
</style>