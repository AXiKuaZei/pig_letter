<template>
  <Layout>
    <topmenu/>
    <br>
    <br>
    <Input style="width: 35%; margin: auto" size="large" type="text" placeholder="请输入文章标题" v-model="title"></Input>
    <br>
    <Layout style="width: 65%; margin: auto">
      <ckeditor :editor="editor" v-model="editorData" :config="editorConfig">
        <Content style="min-height: 700px"></Content>
      </ckeditor>
      <Button type="primary"  size="large" style="width: 200px; margin: 50px auto">发布</Button>
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
        title: '',
        editor: ClassicEditor,
        editorData: '',
        editorConfig: {
        }
      };
    },
    methods: {

    }
  }
</script>

<style>
.ck-content {
  height:450px;
  font-size: large;
}
</style>
