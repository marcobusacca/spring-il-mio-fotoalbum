<script setup>
// IMPORT LIBS
import { onMounted, ref } from 'vue';
import axios from 'axios';

// IMPORT COMPONENTS
import AppHeader from './components/AppHeader.vue';
import PhotoIndex from './components/PhotoIndex.vue';
import PhotoShow from './components/PhotoShow.vue';

// DATA
const photos = ref(null);
const photoActive = ref(null);

// FUNCTIONS
const getPhotos = async () => {
  const data = await axios.get("http://localhost:8080/api/photos");
  photos.value = data.data;
};
const openPhoto = (id) => {
  photos.value.forEach((photo) => {
    if (photo.id === id) {
      photoActive.value = photo;
    }
  });
};
const closePage = () => {
  photoActive.value = null;
  getPhotos();
};

// HOOKS
onMounted(getPhotos);
</script>

<template>
  <app-header />
  <main>
    <div class="container">
      <div class="row">
        <photo-index v-if="photoActive == null" :photos="photos" @open-photo="openPhoto" />
        <photo-show v-else :photo="photoActive" @close-page="closePage" />
      </div>
    </div>
  </main>
</template>

<style lang="scss">
@use './styles/generals.scss' as *;
</style>