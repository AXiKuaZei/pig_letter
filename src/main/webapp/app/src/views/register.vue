<template>
<div class="register-box">

    <h1>Sign Up</h1>
    <Form>
      <div class="text-box">
          <Input type="text" placeholder=" 昵称" maxlength="20" v-model="user.nickname" @change.native="checkNick">
            <Icon type="logo-octocat" slot="prefix" size="24"/>
          </Input>
          <p style="font-size: 18px;color: #f08282">{{message.nickname}}</p>
      </div>
      <div class="text-box">
          <Input type="text" maxlength="20"  placeholder=" 用户名" v-model="user.username" @keydown.native="changeCode" @change.native="checkExist">
            <Icon type="md-contact" slot="prefix" size="24"/>
          </Input>
          <p style="font-size: 18px;color: #f08282">{{message.username}}</p>
          <p style="font-size: 18px;color: lightseagreen">{{message.username2}}</p>
      </div>
      <div class="text-box">
          <Input type="password" placeholder=" 密码" v-model="user.password" @change.native="checkPswd">
            <Icon type="md-lock" slot="prefix" size="24"/>
          </Input>
          <p style="font-size: 18px;color: #f08282">{{message.password}}</p>
      </div>
      <div class="text-box">
          <Input type="password" placeholder=" 再次输入密码" v-model="user.password2" @change.native="checkPswd2">
            <Icon type="md-lock" slot="prefix" size="24"/>
          </Input>
          <p style="font-size: 18px;color: #f08282">{{message.password2}}</p>
      </div>
      <button class="button" @click="register">注册</button>
    </Form>
    <router-link to="/login">已有用户？直接登录吧！</router-link>
</div>
</template>

<script>
  export default {
    data(){
      return {
        validate: {
          nickname: false,
          username: false,
          password: false,
          password2: false
        },
        user: {
          nickname: "",
          username: "",
          password: "",
          password2: ""
        },
        message: {
          nickname: "",
          username: "",
          username2: "",
          password: "",
          password2: ""
        }
      }
    },
    methods: {
      register() {
        if(this.validate.nickname && this.validate.username && this.validate.password && this.validate.password2){
          this.$axios({
            method: 'POST',
            url: 'user/register',
            data:{
              "userName": this.user.username,
              "pswd": this.user.password,
              "nickName": this.user.nickname
            }
          }).then((response) => {
            if(response.data.message === "success"){
              this.$Message.success("恭喜！注册成功！");
              this.$router.push({path:"/login"})
            }else{
              this.$Message.success("注册失败！");
            }
          })
        }else{
          this.$Message.error("输入信息尚未完善");
        }
      },
      checkNick() {
        if(this.user.nickname.length<1){
          this.validate.nickname = false
          this.message.nickname = "昵称不能为空"
        }else{
          this.validate.nickname = true
          this.message.nickname = ""
        }
      },
      checkExist() {
        this.changeCode()
        if(this.user.username.length<6){
          this.message.username = "用户名长度不能小于6"
          this.validate.username = false
          return
        }else if(this.user.username.length>20){
          this.message.username = "用户名长度不能大于20"
          this.validate.username = false
          return
        }else{
          this.message.username = ""
        }
        this.$axios({
          method: 'GET',
          url: 'user/exist/'+this.user.username,
        }).then((response) => {
          if(response.data.message === "success"){
            this.message.username2 = "恭喜！用户名可用！"
            this.message.username = ""
            this.validate.username = true
          }else{
            this.message.username = "用户名已经被注册"
            this.message.username2 = ""
            this.validate.username = false
          }
        })
      },
      checkPswd() {
        if(this.user.password.length < 6){
          this.message.password = "密码长度至少为6"
          this.validate.password = false
        } else if(this.user.password.length > 20){
          this.message.password = "密码长度不能超过20"
          this.validate.password = false
        }else{
          this.message.password = ""
          this.validate.password = true
        }
      },
      checkPswd2() {
        if(this.user.password !== this.user.password2){
          this.message.password2 = "两次输入的密码不一致"
          this.validate.password2 = false
        }else{
          this.message.password2 = ""
          this.validate.password2 = true
        }
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
