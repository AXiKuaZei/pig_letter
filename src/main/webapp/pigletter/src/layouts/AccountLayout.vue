<template>
  <q-layout view="hhh lpR fff">

    <q-header elevated class="bg-primary text-white row justify-center">
      <mainHeader></mainHeader>
    </q-header>

    <q-page-container >
      <router-view/>
    </q-page-container>      

  </q-layout>
</template>

<script>
  import {defineComponent} from 'vue'
  import mainHeader from 'components/MainHeader.vue'

  export default defineComponent({
    name: 'AccountLayout',
    components: {
      mainHeader
    }
  })
</script>

<style>
</style>
