import Vue from 'vue'
import VueRouter from 'vue-router'
import App from '../App'
import Index from "../views/Index.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '导航',
        component: Index,
        redirect:"/pageOne",
        children: [
          {
            path: '/pageOne',
            name: '页面1',
            component: () => import(/* webpackChunkName: "about" */ '../views/page/PageOne.vue')
          },
          {
            path: '/pageTwo',
            name: '页面2',
            component: () => import(/* webpackChunkName: "about" */ '../views/page/PageTwo.vue')
          }
        ]
    },
  {
    path: '/nav',
    name: '导航2',
    component: Index,
    children: [
      {
        path: '/pageThree',
        name: 'pageThree',
        component: () => import(/* webpackChunkName: "about" */ '../views/page/PageOne.vue')
      }
    ]
  }/*,
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/!* webpackChunkName: "about" *!/ '../views/About.vue')
    }*/

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
