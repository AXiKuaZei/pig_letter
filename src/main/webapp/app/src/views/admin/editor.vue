<template>
  <Layout>
    <topmenu/>
    <br>
    <br>
    <Input style="width: 35%; margin: auto" size="large" type="text" placeholder="请输入文章标题" v-model="title"></Input>
    <br>
    <Layout style="width: 65%; margin: auto">
      <ckeditor :editor="editor" v-model="content" :config="editorConfig">
        <Content style="min-height: 700px"></Content>
      </ckeditor>
      <Button type="primary" @click="release"  size="large" style="width: 200px; margin: 50px auto">发布</Button>
    </Layout>
  </Layout>
</template>

<script>
  import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
  import topmenu from "../../components/topmenu";
  export default {
    name: 'app',
    components: {
      topmenu
    },
    data() {
      return {
        authorId: 1,
        title: '',
        editor: ClassicEditor,
        content: '',
        editorConfig: {
        }
      };
    },
    methods: {
      updateArticle(){
        this.$axios({
          url: '/article',
          method: 'put',
          data: {
            articleId: this.$route.params.id,
            title: this.title,
            content: this.content,
          }
        }).then((response)=>{
          if(response.data.message === 'success'){
            this.$Message.success("发布成功")
            this.$router.push({path:"/admin/articles"})
          }else{
            this.$Message.error("发布失败，请重试")
          }
        })
      },
      newArticle(){
        this.$axios({
          url: '/article',
          method: 'post',
          data: {
            authorId: this.authorId,
            title: this.title,
            content: this.content,
          }
        }).then((response)=>{
          if(response.data.message === 'success'){
            this.$Message.success("发布成功")
            this.$router.push({path:"/admin/articles"})
          }else{
            this.$Message.error("发布失败，请重试")
          }
        })
      },
      release(){
        if(isNaN(this.$route.params.id)){
          this.newArticle()
        }else{
          this.updateArticle()
        }
      }

    },
    created() {
      if(isNaN(this.$route.params.id)){
        return
      }
      this.$axios({
        url: '/article/'+this.$route.params.id,
        method: 'get',
      }).then((response)=>{
        this.title = response.data.data.title
        this.content = response.data.data.content
      })
    }
  }
</script>

<style>
.ck-content {
  height:450px;
  font-size: large;
}
</style>
