<template>
  <q-page class="flex justify-center bg-grey-3">

    <div class="row full-height">

      <mainContent class="col-8 col-sm-auto" />

      <sideBar class="col-grow" />

    </div>

  </q-page>
</template>

<script>
import { defineComponent } from 'vue';
import sideBar from 'components/SideBar.vue'
import mainContent from 'components/MainContent.vue'


export default defineComponent({
  name: 'pigletter',
  components: {
    sideBar,
    mainContent
  }
})
</script>

<style scoped>
</style>
