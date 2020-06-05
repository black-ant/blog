import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

// 添加路由对象
import index from '@/pages/index'
import blogIndex from '@/pages/blog-index'
import blogProject from '@/pages/blog-project'
// import indexJS from '@/pages/indexJS'
// import indexJQuery from '@/pages/indexJQuery'
// import indexBootStrap from '@/pages/indexBootStrap'
// import indexAxios from '@/pages/indexAxios'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/hello',
      name: 'index',
      component: index
    },
    {
      path: '/blogIndex',
      name: 'blogIndex',
      component: blogIndex
    },
    {
      path: '/blogProject',
      name: 'blogProject',
      component: blogProject
    }
  ]
})
