<template>
  <body id="poster">
    <el-form
      class="login-container"
      label-position="left"
      label-width="0px">
      <h3 class="login_title">系统登录</h3>
      <el-form-item>
        <el-input type="text" v-model="form.userName" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="form.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </body>

</template>

<script>
export default {
  name: "Login",
  data () {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  mounted () {
  },
  methods: {
    login () {
      this.$axios.post('/login', {userName: this.form.userName, password: this.form.password}).then(res => {
          debugger
        res = res.data;
        if (res && res.code === 200) {
          this.$router.push({path: '/index'})
        }
      }).catch(res => {
      })
    }
  }
}
</script>

<style scoped>
  body{
    margin: 0px;
  }
  #poster {
    background:url("../assets/evn.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 200px auto;
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
</style>
