<template>
  <q-layout view="hHh lpr fff" >

    <q-header class="bg-primary text-white row justify-center">
      <mainHeader ></mainHeader> 
    </q-header>

    <q-page-container >
      <router-view />
    </q-page-container>
      
    <q-footer elevated class="bg-grey-6 text-white">
      <q-toolbar>
        <q-toolbar-title>
          <div>Pigletter</div>
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>

  </q-layout>
</template>

<script>
import { ref } from 'vue'
import mainHeader from 'components/MainHeader.vue'

export default {
  name: 'mainLayout',
  components: {
    mainHeader
  }
}
</script>

<style scoped>
</style>