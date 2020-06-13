<template>
  <el-menu
    :default-active="currentPath"
    @select="handleSelect"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red">
    <el-menu-item v-for="(item,index) in navList" :key="index" :index="item.path">
      {{item.name}}
    </el-menu-item>
    <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>
    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">vue-project</span>
  </el-menu>
</template>

<script>
    export default {
        name: "NavMenu",
        computed: {
            currentPath() {
                return this.$route.path
            }
        },
        data() {
            return {
                navList: [
                    {path: '/index', name: '首页'},
                    {path: '/jotter', name: '笔记本'},
                    {path: '/library', name: '图书馆'},
                    {path: '/admin', name: '个人中心'}
                ]
            }
        },
        methods: {
            handleSelect(key, keyPath) {
            }
        }
    }
</script>

<style scoped>
  a {
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>
