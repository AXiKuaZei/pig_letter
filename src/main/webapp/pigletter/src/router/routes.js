
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { 
        path: '', 
        component: () => import('pages/Home.vue') 
      }
    ]
  },
  {
    path: '/member',
    component: () => import('layouts/MemberLayout.vue'),
    children: [
      { 
        path: '', 
        component: () => import('pages/member/Articles.vue')
      },
      { 
        path: 'articles', 
        component: () => import('pages/member/Articles.vue')
      },
      { 
        path: 'photos', 
        component: () => import('pages/member/Photos.vue')
      },
      { 
        path: 'media', 
        component: () => import('pages/member/Media.vue')
      },
      { 
        path: 'collections', 
        component: () => import('pages/member/Collections.vue')
      },
      { 
        path: 'messages', 
        component: () => import('pages/member/Messages.vue')
      },
      { 
        path: 'follows', 
        component: () => import('pages/member/Follows.vue')
      },
      { 
        path: 'settings', 
        component: () => import('pages/member/Settings.vue')
      }
    ]
  },
  {
    path: '/workspace',
    component: () => import('layouts/WorkSpaceLayout.vue'),
    children: [
      {
        path: 'write',
        component: () => import('pages/workspace/Write.vue')
      }
    ]
  },
  {
    path: '/account',
    component: () => import('layouts/AccountLayout.vue'),
    children: [
      {
        path: 'login',
        component: () => import('pages/account/Login.vue')
      },
      {
        path: 'register',
        component: () => import('pages/account/Register.vue')
      }
    ]
  },
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
