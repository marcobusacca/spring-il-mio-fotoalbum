<script setup>
// IMPORT LIBS
import { defineProps, ref } from 'vue';

// EMITS
const emits = defineEmits(["openPhoto"]);

// PROPS
const props = defineProps({
    photos: {
        type: Array,
        required: true
    }
});
</script>

<template>
    <div class="col-12 py-3">
        <table class="table table-hover text-center text-white w-100">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Titolo</th>
                    <th scope="col">Strumenti</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="photo in photos" :key="photo.id">
                    <th scope="row" v-text="photo.id"></th>
                    <td v-text="photo.name"></td>
                    <td>
                        <button class="btn btn-info" @click="$emit('openPhoto', photo.id)">
                            <i class="fas fa-eye"></i>
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style lang="scss" scoped></style>