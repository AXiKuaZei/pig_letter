<template>
  <q-layout view="hHh lpR lff">

    <q-header class="bg-primary text-white">
      <q-toolbar >
        <q-tabs inline-label v-model="tab">
            <q-route-tab
            v-for="link in linkList"
            :key="link.title" 
            :icon="link.icon"
            :label="link.title" 
            :to="link.link" 
            />
        </q-tabs>
        <q-space />
        <q-avatar>
          <img src="statics/img/issac.png"/>
        </q-avatar>
      </q-toolbar>
    </q-header>

    <q-page-container>
      <router-view />
    </q-page-container>

    <q-footer elevated class="bg-grey-8 text-white text-center">
      <q-toolbar>
        <q-toolbar-title>
          Pigletter
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>

  </q-layout>
</template>

<script>
import { defineComponent, ref } from 'vue'

const rightDrawerOpen = ref(false)
const linkList = [
    {
    title: '个人主页',
    icon: 'home',
    link: '/member'
  },
  {
    title: '我的文章',
    icon: 'description',
    link: '/member/articles'
  },
  {
    title: '收藏夹',
    icon: 'grade',
    link: '/member/collections'
  },
  {
    title: '相册',
    icon: 'photo',
    link: '/member/photos'
  },
  {
    title: '影音仓库',
    icon: 'movie',
    link: '/member/media'
  },
  {
    title: '留言板',
    icon: 'forum',
    link: '/member/messages'
  },
  {
    title: '关注',
    icon: 'favorite',
    link: '/member/follows'
  },
  {
    title: '设置',
    icon: 'settings',
    link: '/member/settings'
  }]

export default defineComponent({

  setup () {
    return {
      rightDrawerOpen,
      linkList,
      toggleRightDrawer () {
        rightDrawerOpen.value = !rightDrawerOpen.value
      }
    }
  }
})
</script>