<script setup>
// IMPORT LIBS
import { defineProps, ref, computed } from 'vue';

// EMITS
const emits = defineEmits(["openPhoto"]);

// PROPS
const props = defineProps({
    photos: {
        type: Array,
        required: true
    }
});

// DATA
const nomeFilter = ref('');

// COMPUTED PROPERTY
const newPhotos = computed(() => {
    const searchTerm = nomeFilter.value.toLowerCase().trim();
    return searchTerm ? props.photos.filter(photo => photo.name.toLowerCase().includes(searchTerm)) : props.photos;
});
</script>

<template>
    <div class="col-12">
        <form class="index-filter-form py-5" @submit.prevent="newPhotos">
            <input type="text" placeholder="Filtra le foto per nome" class="form-control d-inline-block"
                v-model="nomeFilter">
        </form>
    </div>
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
                <tr v-for="photo in newPhotos" :key="photo.id">
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