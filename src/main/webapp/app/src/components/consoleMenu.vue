<template>
  <div>
    <Menu theme="primary" active-name="1" style="height: 100%">
      <MenuGroup title="个人中心">
          <MenuItem name="1-1" router-link to="/admin/personalCenter">
            <Icon type="md-document"/>
            我的主页
          </MenuItem>
          <MenuItem name="1-2">
            <Icon type="md-chatbubbles" />
            关注的人
          </MenuItem>
        <MenuItem name="1-3">
          <Icon type="md-chatbubbles" />
          我的收藏
        </MenuItem>
      </MenuGroup>
      <MenuGroup title="内容管理">
        <MenuItem name="2-1" router-link to="/admin/articles">
          <Icon type="md-document" />
          文章管理
        </MenuItem>
        <MenuItem name="2-2">
          <Icon type="md-chatbubbles" />
          评论管理
        </MenuItem>
      </MenuGroup>
      <MenuGroup title="星星">
        <MenuItem name="3-1">
          <Icon type="md-document" />
          送出的星星
        </MenuItem>
        <MenuItem name="3-2">
          <Icon type="md-chatbubbles" />
          收到的星星
        </MenuItem>
      </MenuGroup>
    </Menu>
  </div>
</template>
<script>
  export default {
    name: "menu",
    data () {
      return {
      }
    }
  }
</script>
