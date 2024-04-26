<template>
  <div class="app-container">

    <div class="acp-group-header">
      <div class="group-title">自定义主题配置</div>
      <div class="group-body">根据客户需求提出面向构件的应用解决方案的建议</div>
    </div>

    <div class="form-container">
      <el-form :model="form" :rules="rules" v-loading="loading" ref="form" label-width="180px" class="demo-ruleForm">
        <el-form-item label="团队名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入企业名称" />
        </el-form-item>

        <el-form-item label="团队Logo" prop="logo">
          <ImageUpload v-model="form.logo" class="navLogo" :limit="1" :fileSize="20" />
        </el-form-item>

        <el-form-item label="团队描述" prop="enDesc">
          <el-input v-model="form.enDesc" placeholder="请输入企业描述" />
        </el-form-item>

        <el-form-item label="团队官网" prop="domainName">
          <el-input v-model="form.domainName" placeholder="请输入企业官网地址" />
        </el-form-item>

        <el-form-item label="团队代码" prop="creditCode">
          <el-input v-model="form.creditCode" placeholder="请输入企业信用代码&或者输入唯一值" />
        </el-form-item>

        <el-form-item label="工作台" prop="saasUrl">
          <el-input v-model="form.saasUrl" placeholder="请输入AIP工作台" />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">
            保存
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script setup>

const form = ref({
  name: null,
  logo: null,
  enDesc: null,
  creditCode: null,
});

// import {
//   getCurrentEnterprise,
//   registerEnterprise,
//   modifyEnterprise,
// } from "@/api/saasCloud";

// import ImageUpload from "alinesno-ui/packages/ImageUpload"

// export default {

//   // components: {
//   //   ImageUpload
//   // },

//   data() {
//     return {
//       form: {
//         name: null,
//         logo: null,
//         enDesc: null,
//         creditCode: null,
//       },
//       rules: {
//         name: [
//           { required: true, message: "请输入企业名称", trigger: "blur" },
//         ],
//         logo: [
//           { required: true, message: "请至少上传一张Logo图", trigger: "blur" },
//         ],
//         enDesc: [
//           { required: true, message: "请输入企业描述", trigger: "blur" },
//         ],
//         creditCode: [
//           { required: true, message: "请输入企业信用代码", trigger: "blur" },
//         ]
//       },
//       currentSiteId: null,
//       // 遮罩层
//       loading: false,
//     };
//   },

//   created() {
//     this.getSetting();
//   },

//   methods: {
//     getSetting() {

//       this.loading = true;
//       getCurrentEnterprise().then(res => {
//         debugger
//         this.loading = false;
//         if (res.code == 200) {
//           if (res.data != null) {
//             this.currentSiteId = res.data.id;
//             this.form = res.data;
//           }
//         } else {
//           alert("获取失败");
//         }
//       }).catch(() => { this.loading = false; });

//     },
//     submitForm(formName) {
//       this.$refs[formName].validate((valid) => {
//         if (valid) {
//           this.loading = true;
//           if (this.form.id) {
//             // 修改
//             modifyEnterprise(this.form).then(res => {
//               this.msgSuccess("保存成功");
//               this.loading = false;
//               this.getSetting();
//             }).catch(() => { this.loading = false; });

//           } else {
//             // 新增
//             registerEnterprise(this.form).then(res => {
//               this.msgSuccess("保存成功");
//               this.loading = false;
//               this.getSetting();
//             }).catch(() => { this.loading = false; });
//           }
//         }
//       });
//     },
//     resetForm() {
//       this.$refs["ruleForm"].resetFields();
//       this.getSetting();
//     }
//   },
// };
</script>

<style scoped lang="scss">
.form-container {
  max-width: 1024px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
}

.acp-group-header {
  text-align: center;
  margin-top: 20px;
  margin-bottom: 40px;

  .group-title {
    font-size: 25px;
    font-weight: bold;
    color: #3b5998;
    padding: 10px;
  }

}
</style>


