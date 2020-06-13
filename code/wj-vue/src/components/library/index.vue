<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <aside-menu></aside-menu>
    </el-aside>
    <el-main>
      <Books />
    </el-main>
  </el-container>
</template>

<script>
import AsideMenu from "@/components/library/AsideMenu"
import Books from "@/components/library/Books"
export default {
  name: "index",
  components: {AsideMenu, Books}
}
</script>

<style scoped>

</style>
