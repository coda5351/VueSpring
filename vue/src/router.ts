import { createRouter, createWebHistory } from 'vue-router'
import Home from './pages/Home.vue'
import About from './pages/About.vue'
import Account from './pages/Account.vue'
import Register from './pages/Register.vue'
import Login from './pages/Login.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/account',
    name: 'Account',
    component: Account,
    children: [
      {
        path: 'account',
        name: 'AccountTab',
        component: Account
      },
      {
        path: 'profile',
        name: 'ProfileTab',
        component: Account
      },
      {
        path: 'branding',
        name: 'BrandingTab',
        component: Account
      },
      {
        path: 'users',
        name: 'UsersTab',
        component: Account
      },
      {
        path: 'data',
        name: 'DataTab',
        component: Account
      },
      {
        path: 'board',
        name: 'BoardTab',
        component: Account
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register/',
    name: 'Register',
    component: Register
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
