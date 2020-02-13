import Vue from 'vue'
import Router from 'vue-router'
import Login from  '../components/Login'
import Home from '../components/Home'
import AppIndex from "../components/home/AppIndex";
import Registration from "../components/register/Registration";
import BackRegistration from "../components/register/BackRegistration";
import Diagnose from "../components/diagnose/Diagnose";
import DocHome from "../components/DocHome";
import DocIndex from "../components/home/DocIndex";
import Prescribe from "../components/prescribe/Prescribe";
import Charge from "../components/charge/Charge";


Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path:'/home',
      name:'Home',
      component:Home,
      redirect:'/index',
      children:[
        {
          path:'/index',
          name:'AppIndex',
          component:AppIndex,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/registration',
          name:'Registration',
          component:Registration,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/backRegistration',
          name:'BackRegistration',
          component: BackRegistration,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/charge',
          name:'Charge',
          component:Charge,
          meta:{
            requireAuth:true
          }
        }


      ]
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path:'/dochome',
      name:'DocHome',
      component:DocHome,
      redirect:'/docindex',
      children:[
        {
          path:'/docindex',
          name:'DocIndex',
          component:DocIndex,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/diagnose',
          name:'Diagnose',
          component:Diagnose,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/prescribe',
          name:'Prescribe',
          component:Prescribe,
          meta:{
            requireAuth:true
          }
        }
      ]
    }
  ]
})
