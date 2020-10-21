<template>
  <div>
    <div class="topmenu">
      <ul>
        <li><router-link to='/home'>首页</router-link></li>
        <li><a href="https://bilibili.com">哔哩哔哩</a></li>
        <li><router-link to="#">星星海</router-link></li>
        <li><router-link to="/article">所有文章</router-link></li>
        <li><router-link to="#">资源站</router-link></li>
        <li style="float: right;"><router-link to="/register">注册</router-link></li>
        <div class="topmenu2">
          <li><router-link to="/login">登录</router-link></li>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'base'
  }
</script>
<style scoped>
  @import url(../css/index.css);
</style>
