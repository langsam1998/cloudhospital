<template>
  <el-menu
    default-active="1-1"
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    background-color="white"
    text-color="black"
    active-text-color="#409EFF">
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-tickets" ></i>
        <span style="font-size: 20px">医院要闻</span>
      </template>
        <el-menu-item index="1-1">学术成果</el-menu-item>
        <el-menu-item index="1-2">通知公告</el-menu-item>
    </el-submenu>
    <el-menu-item index="2">
      <i class="el-icon-share"></i>
      <span slot="title"style="font-size: 20px">快速链接</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-star-on"></i>
      <span slot="title"style="font-size: 20px">党团共建</span>
    </el-menu-item>
  </el-menu>
</template>


<script>
  export default {
    name:'SideBar',
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
