<template>
  <div class="app-container">

    <div class="acp-group-header">
      <div class="group-title">自定义组织配置</div>
      <div class="group-body">自定义组织色调和管理配置，形成组织组织风格</div>
    </div>

    <div class="form-container">
      <el-form
          ref="databaseRef" 
          :model="form"
          :rules="rules"
          label-width="auto"
          status-icon>
        <el-form-item label="组织名称" prop="orgName">
          <el-input v-model="form.orgName" placeholder="请输入企业名称，如AIP研发团队" />
        </el-form-item>

        <el-form-item label="组织Logo" prop="logoUrl">
          <ImageUpload v-model="form.logoUrl" class="navLogo" :limit="1" :fileSize="1" />
        </el-form-item>

        <el-form-item label="组织描述" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入企业描述，如AIP研发团队是一个小型的研发团队。" />
        </el-form-item>

        <el-form-item label="组织官网" prop="subdomain">
          <el-input v-model="form.subdomain" placeholder="请输入企业官网地址" />
        </el-form-item>


        <el-form-item label="负责人" prop="orgPhone">
          <el-input v-model="form.orgPhone" placeholder="请输入负责人信息，如 张三，15578942583" />
        </el-form-item>

        <el-form-item label="组织地址" prop="orgAddress">
          <el-input v-model="form.orgAddress" placeholder="请输入组织工作地址信息，如 南宁" />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm()">
            保存
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { reactive, toRefs } from 'vue';

import { 
  findOrg , 
  updateOrgCustomTheme
} from "@/api/console/dashboard";

const { proxy } = getCurrentInstance();

const data = reactive({
  form: {
    orgName: '',
    logoUrl: '',
    remark: '',
    subdomain: '',
    orgPhone: '',
    orgAddress: ''
  },
  rules: {
    orgName: [{ required: true, message: '组织名称不能为空', trigger: 'blur' }],
    logoUrl: [{ required: true, message: '请上传组织Logo', trigger: 'change' }],
    remark: [{ required: true, message: '组织描述不能为空', trigger: 'blur' }],
    subdomain: [{ required: true, message: '组织官网地址不能为空', trigger: 'blur' }],
    orgPhone: [{ required: true, message: '负责人信息不能为空', trigger: 'blur' }],
    orgAddress: [{ required: true, message: '组织地址不能为空', trigger: 'blur' }]
  }
});

const { form, rules } = toRefs(data);

// 加载组织信息的方法
const handleFindOrg = () => {
  findOrg().then((res) => {
    form.value = res.data ;
  });
};

// 在组件挂载完成后自动加载组织信息
onMounted(handleFindOrg);

// 提交表单的方法
const submitForm = () => {
   proxy.$refs["databaseRef"].validate(valid => {
    if (valid) {
      updateOrgCustomTheme(form.value).then(response => {
        proxy.$modal.msgSuccess("修改成功");
      });
    } 
  });
};
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


