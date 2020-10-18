<template>
  <div>
    <div>
      <ol>
        <li v-for="todo in todos">
          <p>1</p>
          {{ todo.text }}
        </li>
      </ol>
    </div>
    <p>111</p>
    <div v-for="article in articles">
      <h1>{{article.title}}</h1>
      <h1>{{article.publishedTime}}</h1>
      <h1>{{article.content}}</h1>
    </div>
  </div>
</template>

<script>
    export default {
      name: "test.vue",
      data() {
        return{
          articles: [
            {
              title: 1,
              publishedTime: 1,
              content: 1
            },
            {
              title: 2,
              publishedTime: 2,
              content: 2
            },
            {
              title: 3,
              publishedTime: 3,
              content: 3
            }
          ],
          todos: [
            {text: '学习 JavaScript'},
            {text: '学习 Vue'},
            {text: '整个牛项目'}
          ]
        }
      }
    }
</script>

<style scoped>

</style>
