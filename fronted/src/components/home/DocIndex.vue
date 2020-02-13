<template>
  <el-container>
    <el-container>
      <el-aside style="width:200px;margin-top: 20px">
        <SideBar></SideBar>
      </el-aside>
      <el-main>
        <div class="block">
          <el-carousel height="500px">
            <el-carousel-item v-for="item in items" :key="item.id">
              <el-row>
                <el-col :span="24"><img ref="imgHeight" :src="item.idView" class="banner_img"/></el-col>
              </el-row>
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-main>
    </el-container>
  </el-container>

</template>


<script>
    import SideBar from "./SideBar";
    export default {
        name: "DocIndex",
        components: {SideBar},
        data(){
            return{
                items:[
                    {id:1,idView:require('../../assets/banner01.jpg')},
                    {id:2,idView:require('../../assets/banner02.jpg')},
                    {id:3,idView:require('../../assets/banner03.jpg')},
                ]
            }
        }
    }
</script>

<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }
  .footer-title {
    font-size: 20px;
    font-weight: bold
  }

  .footer-info {
    font-size: 14px;
    margin-bottom: 4px;
  }
</style>
