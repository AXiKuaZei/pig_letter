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
      path: '/admin/personalCenter',
      name: 'personalCenter',
      component: () => import('../views/admin/personalCenter.vue')
    },
    {
      path: '/admin/console',
      name: 'console',
      component: () => import('../views/admin/console.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('../views/test.vue')
    }
  ]
})
