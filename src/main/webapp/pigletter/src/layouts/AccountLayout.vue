<template>
  <q-layout view="hhh lpR fff">

    <q-page-container >
      <router-view/>
    </q-page-container>      

  </q-layout>
</template>

<script>
  import {defineComponent} from 'vue'

  export default defineComponent({
    name: 'AccountLayout',
  })
</script>

<style>
</style>
