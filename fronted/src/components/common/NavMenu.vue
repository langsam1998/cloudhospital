<template>
  <el-menu
        :default-active="'/index'"
        router
        mode="horizontal"
        background-color='white'
        text-color="#222"
        active-text-color="#409EFF"
        style="min-width: 1300px">
        <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
          {{ item.navItem }}
        </el-menu-item>
        <span style="position: absolute;right: 43%"><img src="../../assets/logo/logo-grey-none.png" width="180px"></span>
  </el-menu>
</template>

<script>
  export default {
    name: 'DocNavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name:'/registration',navItem:'挂号'},
          {name: '/backRegistration', navItem: '退号'},
          {name: '/charge', navItem: '收费'},
        ]
      }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>

