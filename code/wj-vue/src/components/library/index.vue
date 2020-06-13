<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <aside-menu @indexSelect="listByCategory" ref="sideMenu"></aside-menu>
    </el-aside>
    <el-main>
      <Books class="books-area" ref="booksArea"/>
    </el-main>
  </el-container>
</template>

<script>
import AsideMenu from "@/components/library/AsideMenu"
import Books from "@/components/library/Books"
export default {
    name: "index",
    components: {AsideMenu, Books},
    methods: {
        listByCategory() {
            var _this = this
            var cid = this.$refs.sideMenu.cid
            var url = 'categories/' + cid + '/books'
            this.$axios.get(url).then(resp => {
                if (resp && resp.status === 200) {
                    _this.$refs.booksArea.books = resp.data
                }
            })
        }
    }
}
</script>

<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
