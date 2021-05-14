<template>
  <q-layout view="hhh lpr lff">

    <q-header reveal class="bg-primary text-white row  justify-center">
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

            <q-btn-dropdown auto-close stretch flat>

              <template v-slot:label>
                <q-avatar>
                  <img src="../statics/img/profile.jpeg"/>
                </q-avatar>
              </template>
              
              <q-list>

                <q-item clickable @click="tab = 'photos'">
                  <q-avatar>
                    <img src="../statics/img/profile.jpeg"/>
                  </q-avatar>
                </q-item>

                <q-item 
                clickable
                v-for="item in dropList"
                :key="item.title"
                :to="item.link"
                >
                <q-item-section avatar>
                  <q-avatar 
                  :icon="item.icon" color="secondary" text-color="white" />
                </q-item-section>
                <q-item-section>
                  <q-item-label>{{ item.title }}</q-item-label>
                </q-item-section>
                </q-item>

              </q-list>
            </q-btn-dropdown>


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
const linkList = ref([
    {
    title: '个人主页',
    icon: 'home',
    link: '/member/home'
  },
  {
    title: '我的文章',
    icon: 'description',
    link: '/member/articles'
  },
  {
    title: ' 备忘录',
    icon: 'event_note',
    link: '/member/memo'
  },
  {
    title: '收藏夹',
    icon: 'grade',
    link: '/member/collections'
  },
  {
    title: '媒体库',
    icon: 'movie',
    link: '/member/media'
  }])

  const dropList = ref([
    {
    title: '关注',
    icon: 'favorite',
    link: '/member/follows'
  },
  {
    title: '留言板',
    icon: 'forum',
    link: '/member/messages'
  },
  {
    title: ' 设置',
    icon: 'settings',
    link: '/member/settings'
  },
  {
    title: '退出',
    icon: 'exit_to_app',
    link: '/'
  }])


export default defineComponent({

  setup () {
    return {
      rightDrawerOpen,
      linkList,
      dropList,
      toggleRightDrawer () {
        rightDrawerOpen.value = !rightDrawerOpen.value
      }
    }
  }
})
</script>


<style scoped>
  .q-toolbar {
    max-width: 1560px;
  }
  .q-header {
    min-width: 800px;
  }
</style>