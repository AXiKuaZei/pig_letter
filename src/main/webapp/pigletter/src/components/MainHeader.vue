<template>
    <q-toolbar>

        <!-- <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg">
          </q-avatar>
          Pigletter
        </q-toolbar-title> -->
        <q-tabs >
          <q-route-tab class="my-tab" to="/" label="首页" />
          <q-route-tab class="my-tab" to="/articles" label="文章" />
          <q-route-tab class="my-tab" to="/account/register" label="文章" />
          <q-route-tab class="my-tab" to="/account/register" label="文章" />
          <q-route-tab class="my-tab" to="/account/register" label="文章" />
          <q-route-tab class="my-tab" to="/account/register" label="文章" />
        </q-tabs>

        <q-input 
          dense filled 
          debounce="400" 
          v-model="filter" 
          bg-color="green" 
          placeholder="搜索"
        >
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>

        <q-space />

        <q-tabs>
          <q-route-tab class="my-tab" to="/account/login" label="登录" />
          <q-route-tab class="my-tab" to="/account/register" label="注册" />
        </q-tabs>

      </q-toolbar>
</template>

<script>
import { defineComponent, ref } from 'vue'

export default defineComponent({
    name: 'Header'
})
</script>

<style>
  .q-toolbar {
    max-width: 1560px;
  }

  .my-tab {
    max-width: 120px;
  }
</style>