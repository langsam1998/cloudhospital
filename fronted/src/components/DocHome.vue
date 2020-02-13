<template>
  <div>
    <nav-menu></nav-menu>
    <router-view/>
    <el-footer style="background: 	#4682B4;color: white; height: auto">
      <el-row type="flex" justify="space-around" align="top">
        <el-col >
          <img class="logo" src="../assets/logo/logo-white-none.png" style="height: 80px">
          <p>Copyright 2019 NEUEDU All Rights Reserved. </p>
        </el-col>
        <el-col >
          <p class="footer-title">东软智慧医院</p>
          <p class="footer-info">地址：沈阳市浑南区创新路66号</p>
          <p class="footer-info">电话：024-66666666</p>
        </el-col>
      </el-row>

    </el-footer>
  </div>
</template>

<script>
    import NavMenu from "./common/DocNavMenu";

    export default {
        name: "DocHome",
        components: {NavMenu}
    }
</script>

<style scoped>
</style>
