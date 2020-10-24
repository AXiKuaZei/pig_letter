<template>
  <div class="layout">
    <Layout>
        <topmenu/>
      <Layout>
        <Sider>
          <consoleMenu style="height: 100%"/>
        </Sider>
        <Layout :style="{padding: '0 24px 24px'}">
          <Breadcrumb :style="{margin: '24px'}">
            <BreadcrumbItem>内容管理</BreadcrumbItem>
            <BreadcrumbItem>文章管理</BreadcrumbItem>
          </Breadcrumb>
          <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
            <Button type="info" size="mid" @click="addArticle">添加文章</Button>
            <Button type="error" size="mid" @click="deleteArticles">批量删除</Button>
            <Table ref="selection" stripe :columns="columns" :data="articleList" style="margin-top: 10px"></Table>
            <div style="margin-top: 24px">
              <Page @on-change="changePage" @on-page-size-change="changePageSize" :total="total" :current="pageNum" :page-size="pageSize" show-sizer show-elevator transfer=true />
            </div>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  </div>

</template>

<script>
  import topmenu from '../../components/topmenu.vue'
  import consoleMenu from '../../components/consoleMenu.vue'
  export default {
      name: "console",
      components: {
        topmenu,
        consoleMenu
      },
      data () {
        return {
          columns:[
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
            {
              type: 'index2',
              width: 60,
              align: 'center',
              render: (h, params) => {
                return h('span', params.index + (this.pageNum- 1) * this.pageSize + 1);
              }
            },
            {
              title: '标题',
              key: 'title'
            },
            {
              title: '最近一次修改',
              key: 'lastUpdatedTime'
            },
            {
              title: '发表时间',
              key: 'publishedTime'
            },
            {
              title: '操作',
              fixed: 'right',
              width: 200,
              render: (h, params) => {
                let id = params.row.articleId
                return h('div', [
                  h('Button', {
                    props: {
                      type: 'primary',
                      size: 'mid'
                    },
                    on: {
                      click: ()=>{this.editArticle(id)}
                    }
                  }, '编辑'),
                  h('Button', {
                    props: {
                      type: 'error',
                      size: 'mid'
                    },
                    style: 'margin-left: 10px',
                    on: {
                      click: ()=>{this.deleteArticle(id)}
                    }
                  }, '删除')
                ]);
              }
            }
          ],
          total: 1,
          pageNum: 1,
          pageSize: 10,
          articleList: [
            {
              "articleId": 10,
              "title": "日记10",
              "authorId": 2,
              "author": "肮脏的小翅膀02",
              "publishedTime": "2020-10-18 18:36:48",
              "lastUpdatedTime": "2020-10-18 18:36:48",
              "deleted": 0,
              "content": "日记10的内容"
            },
            {
              "articleId": 8,
              "title": "日记08",
              "authorId": 1,
              "author": "肮脏的小翅膀01",
              "publishedTime": "2020-10-18 18:36:48",
              "lastUpdatedTime": "2020-10-18 18:36:48",
              "deleted": 0,
              "content": "日记08的内容"
            }
          ]
        }
      },
    methods: {
        getArticles(){
          let params = new URLSearchParams()
          params.append('pageNum', this.pageNum)
          params.append('pageSize', this.pageSize)
          this.$axios.post('/articlePage',params).then((response) => {
            this.articleList = response.data.data.list
            this.total = response.data.data.total
          })
        },
        changePage(page){
          this.pageNum = page
          this.$nextTick(()=>{
            this.getArticles()
          })
        },
        changePageSize(pageSize){
          this.pageSize = pageSize
          this.$nextTick(()=>{
            this.getArticles()
          })
        },
        editArticle(articleId){
          this.$router.push("/admin/editor/"+articleId)
        },
        deleteArticle(articleId){
          let params = new URLSearchParams()
          params.append("articleId", articleId)
          this.$axios({
            url: '/article',
            method: 'delete',
            data: params
          }).then((response)=>{
            if(response.data.message === "success"){
              this.$Message.success("删除成功！")
            }else{
              this.$Message.error("删除文章异常，请重试！")
            }
            this.getArticles()
          })
        },
        deleteArticles(){
          let articleIds = this.$refs.selection.getSelection().map((item)=>item.articleId)
          let params = new URLSearchParams()
          params.append("articleIds", articleIds)
          console.log(params);
          this.$axios({
            url: '/articleMulti',
            method: 'delete',
            data: params
          }).then((response)=>{
            if(response.data.message === "success"){
              this.$Message.success("删除成功！")
            }else{
              this.$Message.error("删除文章异常，请重试！")
            }
            this.getArticles()
          })
        },
        addArticle(){
           this.$router.push("/admin/editor/new")
        }
    },
    created() {
        this.getArticles()
    }
  }
</script>
<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
</style>
