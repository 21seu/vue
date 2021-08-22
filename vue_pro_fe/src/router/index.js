import Vue from 'vue'
import VueRouter from 'vue-router'
import App from '../App'
import Index from "../views/Index.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '图书管理',
        component: Index,
        redirect: "/showBooks",
        children: [
            {
                path: '/showBooks',
                name: '查询图书',
                show:true,
                component: () => import(/* webpackChunkName: "about" */ '../views/page/ShowBooks.vue')
            },
            {
                path: '/addBooks',
                name: '添加图书',
                show:true,
                component: () => import(/* webpackChunkName: "about" */ '../views/page/AddBooks.vue')
            },
            {
                path: '/update',
                show:false,
                component: () => import(/* webpackChunkName: "about" */ '../views/page/UpdateBooks.vue')
            }
        ]
    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
