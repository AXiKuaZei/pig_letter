<template>
  <div>
    <div><topmenu/></div>
    <div class="colunm">
      <div class="textcontent">
        <div class="card" v-for="article in articles">
          <h1 style="font-size: 40px">{{article.title}}</h1>
          <h1 style="font-size: 24px; text-align: right">{{article.author}}</h1>
          <h1 style="font-size: 24px">{{article.content}}</h1>
          <h1 style="font-size: 16px">{{article.publishedTime}}</h1>
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
      articles: [
        {title: 1,
        author: 1,
        publishedTime: 1,
        content: 1
        },
        {title: 2,
          author: 2,
          publishedTime: 2,
          content: 2
        },
        {title: 3,
          author: 3,
          publishedTime: 3,
          content: 3
        }
      ]
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

<style scoped>
@import url(../css/index.css);
</style>
