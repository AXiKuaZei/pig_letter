import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../views/home.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/register.vue')
    },
    {
      path: '/menu',
      name: 'menu',
      component: () => import('../components//consoleMenu.vue')
    },
    {
      path: '/admin/personalCenter',
      name: 'personalCenter',
      component: () => import('../views/admin/personalCenter.vue')
    },
    {
      path: '/admin/articles',
      name: 'articles',
      component: () => import('../views/admin/articles.vue')
    },
    {
      path: '/admin/editor/:id',
      name: 'editor',
      component: () => import('../views/admin/editor.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('../views/test.vue')
    }
  ]
})
