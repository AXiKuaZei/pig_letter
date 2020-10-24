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
            <BreadcrumbItem>个人中心</BreadcrumbItem>
            <BreadcrumbItem>我的主页</BreadcrumbItem>
          </Breadcrumb>
          <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">

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
      name: "personalCenter.vue",
      components: {
        topmenu,
        consoleMenu
      },
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
