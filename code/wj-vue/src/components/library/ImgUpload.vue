<template>
  <el-upload
    class="img-upload"
    ref="upload"
    action="http://localhost:8443/api/coversUpload"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :on-success="handleSuccess"
    :before-remove="beforeRemove"
    multiple
    :limit="1"
    :on-exceed="handleExceed"
    :file-list="fileList">
    <el-button type="button" size="small">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
  </el-upload>
</template>

<script>
  import {mapGetters} from 'vuex'
    export default {
        name: "ImgUpload",
        data () {
            return {
                fileList: [],
                url: '',
            }
        },
        computed: {
            ...mapGetters({
                config: 'getConfig'
            })
        },
        methods: {
            handleRemove (file, fileList) {
            },
            handlePreview (file) {
            },
            handleExceed (files, fileList) {
                this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
            },
            beforeRemove (file, fileList) {
                return this.$confirm(`确定移除 ${file.name}？`)
            },
            handleSuccess (response) {
                this.url = this.config.api_path+response
                this.$emit('onUpload')
                this.$message.warning('上传成功')
            },
            clear () {
                this.$refs.upload.clearFiles()
            }
        }
    }
</script>

<style scoped>

</style>
