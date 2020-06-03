import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from "@/components/Login"
import AppIndex from "@/components/home/AppIndex"

Vue.use(Router)

export default new Router({
  // 路由模式：history模式
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      redirect: '/login',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    }
  ]
})
