<template>
  <el-menu
    :default-active="'/docindex'"
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
                    {name: '/docindex', navItem: '首页'},
                    {name: '/diagnose', navItem: '看诊'},
                    {name: '/prescribe', navItem: '开药'},
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

