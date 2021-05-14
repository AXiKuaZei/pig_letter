<template>
    <q-page class="flex flex-center">
      <underConstruction />
    </q-page>
  </template>
  
  <script>
  import { defineComponent } from 'vue';
  import underConstruction from 'components/UnderConstruction.vue'
  
  export default defineComponent({
    name: 'collections',
    components: {
      underConstruction
    }
  })
  </script>

  <style scoped>
    .q-page {
      background-color: #f87554;
    }
  </style>