<template>
  <div class="login-box">
    <h1>Login</h1>
    <form>
        <div class="text-box">
            <Input placeholder=" 用户名" maxlength="20" v-model="user.username" @keydown.native="changeCode" @input.native="changeCode">
              <Icon type="md-contact" slot="prefix" size="24"/>
            </Input>
        </div>
        <div class="text-box">
            <Input type="password" password placeholder=" 密码" v-model="user.password">
              <Icon type="md-unlock" slot="prefix" size="24"/>
            </Input>
        </div>
        <div class="message"></div>
      <button class="button" @click="login">登录</button>
    </form>
    <router-link to="/register">尚未注册？</router-link>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        user: {
          username: "",
          password: ""
        },
        error: false
      }
    },
    methods: {
      login() {
        if(this.user.username==="" || this.user.password===""){
          this.$Message.error("用户名或密码不能为空")
          return
        }
        let params = new URLSearchParams()
        params.append('username', this.user.username)
        params.append('password', this.user.password)
        this.$axios.post('user/login', params).then((response) => {
          if(response.data.message === "success"){
              this.$Message.success("登录成功！")
              this.$router.push({path:"/admin/personalCenter"})
          }else{
              this.$Message.error("帐号或密码错误，请重试！")
          }
        })
      },
      changeCode() {
        this.$nextTick(() => {
          if(this.user.username !== null){
            this.user.username = this.user.username.replace(/[^\w\.\/]/ig,'')
          }
        })
      }
    }
  }
</script>

<style>
@import url(../css/login.css);
</style>
