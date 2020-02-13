<template>
  <body id="poster">
  <img src="../assets/logo/logo-white-none.png" style="height: 150px" class="logo">
  <el-form class="login-container" label-position="left"
           label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号：admin"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码：admin"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #409EFF;border: none" v-on:click="login">登录</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>

    export default {
        name: 'Login',
        data() {
            return {
                loginForm: {
                    username: '',
                    password: ''
                },
                responseResult: []
            }
        },
        methods: {
            login() {
                var _this = this
                console.log(this.$store.state)
                this.$axios
                    .post('/login', {
                        username: this.loginForm.username,
                        password: this.loginForm.password
                    })
                    .then(successResponse => {
                        if (successResponse.data.code === 100) {
                            _this.$store.commit('login', _this.loginForm);
                            _this.$store.commit('changeId',successResponse.data.id);
                            var path = this.$route.query.redirect;
                            this.$router.replace({path: path === '/' || path === undefined ? '/home' : path})
                        }else if(successResponse.data.code ===200){
                            _this.$store.commit('login', _this.loginForm);
                            _this.$store.commit('changeId',successResponse.data.id);
                            var path = this.$route.query.redirect;
                            this.$router.replace({path: path === '/' || path === undefined ? '/dochome' : path})
                        }
                    })
                    .catch(failResponse => {
                    })
            }
        }
    }
</script>

<style>
  #poster {
    background: url("../assets/background.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }

  body {
    margin: 0px;
  }

  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .logo {
    margin-top: 30px;
  }

</style>

