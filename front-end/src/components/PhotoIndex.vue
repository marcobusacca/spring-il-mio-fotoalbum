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
    <div class="col-12 d-flex justify-content-center">
        <form class="index-filter-form py-5 w-50" @submit.prevent="newPhotos">
            <input type="text" placeholder="Filtra le foto per nome"
                class="form-control d-inline-block border-2 border-black py-2" v-model="nomeFilter">
        </form>
    </div>
    <div class="col-12 py-3">
        <div class="row justify-content-center">
            <div class="col-6 p-5" v-for="photo in newPhotos" :key="photo.id">
                <div class="card text-center" style="width: 500px">
                    <img :src="photo.url" class="card-img-top" style="height: 400px">
                    <div class="card-body py-5">
                        <h5 class="card-title" v-text="photo.name"></h5>
                    </div>
                    <div class="card-footer py-3">
                        <button class="btn btn-info" @click="$emit('openPhoto', photo.id)">
                            <i class="fas fa-eye"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>