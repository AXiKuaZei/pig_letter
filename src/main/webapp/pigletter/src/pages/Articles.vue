<template>
  <q-page class="flex flex-top">
    <underConstruction />
  </q-page>
</template>

<script>
import { defineComponent } from "vue";
import underConstruction from 'components/UnderConstruction.vue'

export default defineComponent({
  name: "articles",
  components: {
    underConstruction
  }
});
</script>

<style scoped>
  .q-page {
    background-color: #f87554;
  }
</style>
