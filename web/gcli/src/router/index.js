import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

// 添加路由对象
import index from '@/pages/index'
import blogIndex from '@/pages/blog-index'
import blogProject from '@/pages/blog-project'
import blogDocview from '@/pages/blog-docview'
import indexCss from '@/pages/indexCss'
import blogDoclist from '@/pages/blog-doclist'
import blogAbout from '@/pages/blog-about'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/indexCss',
      name: 'indexCss',
      component: indexCss
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
    },
    {
      path: '/blogDocview',
      name: 'blogDocview',
      component: blogDocview
    },
    {
      path: '/blogDoclist',
      name: 'blogDoclist',
      component: blogDoclist
    },
    {
      path: '/blogAbout',
      name: 'blogAbout',
      component: blogAbout
    }
  ]
})
