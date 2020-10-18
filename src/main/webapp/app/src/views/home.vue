<template>
  <div>
    <div><topmenu/></div>
    <div class="colunm">
      <div class="textcontent">
        <div class="card" v-for="article in articles">
          <h1>{{article.title}}</h1>
          <h1>{{article.publishedTime}}</h1>
          <h1>{{article.content}}</h1>
          <p class="pre-pre" ></p>
        </div>
      </div>
      <div><sidemenu/></div>
    </div>
  </div>
</template>

<script>
import topmenu from '../components/topmenu.vue'
import sidemenu from '../components/sidemenu.vue'
export default {
  components: {
      topmenu,
      sidemenu
  },
  data(){
    return{
      articles: []
    }
  },
  created() {
    this.$axios({
      method: 'get',
      url: 'article/0/10'
    }).then((response) => {
      console.log(response.data.data)
      this.articles = response.data.data
    })
  }
}
</script>

<style>
</style>
