import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from "@/components/Login"
import AppIndex from "@/components/home/AppIndex"
import Home from "@/components/home"
import Library from '@/components/library'

Vue.use(Router)

// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

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
      path: "/home",
      name: 'Home',
      component: Home,
      render: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: Library,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
