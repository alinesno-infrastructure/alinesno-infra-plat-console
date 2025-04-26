<template>
  <div class="app-container">
    <el-dialog
      v-model="centerDialogVisible"
      title="企业授权码"
      width="800px"
      :close-on-press-escape="isAuthorized"
      :close-on-click-modal="isAuthorized"
      append-to-body
      align-center
      :show-close="isAuthorized"
    >
      <template #header>
        <div class="dialog-header">
          <h2 class="dialog-title">企业授权码验证</h2>
          <p class="info-text">AIP工作区是企业区域，需要提供企业授权码才能访问。</p>
        </div>
      </template>
      <div class="dialog-content">
        <el-form :model="authForm" :rules="authRules" :label-position="'top'" label-width="0px" ref="authFormRef" class="auth-form">
          <el-form-item label="" prop="authCode">
            <el-input v-model="authForm.authCode" placeholder="请输入企业授权码" size="large"></el-input>
          </el-form-item>
        </el-form>
          <div class="button-container">
            <el-button type="primary" @click="submitAuthCode" style="float:right" v-loading="authLoading" size="large">
              提交授权码
            </el-button>
          </div>
      </div>
    </el-dialog>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import { ElMessage } from 'element-plus';

const centerDialogVisible = ref(localStorage.getItem('isAuthorized')!== 'true');
const authFormRef = ref(null);
const authLoading = ref(false);
const isAuthorized = ref(localStorage.getItem('isAuthorized') === 'true');

const authForm = reactive({
  authCode: ''
});

const authRules = {
  authCode: [{ required: true, message: '请输入企业授权码', trigger: 'blur' }]
};

const submitAuthCode = () => {
  authFormRef.value.validate((valid) => {
    if (valid) {
      authLoading.value = true;
      if (authForm.authCode === 'alinesno') {
        localStorage.setItem('isAuthorized', 'true');
        isAuthorized.value = true;
        centerDialogVisible.value = false;
        ElMessage.success('授权成功！');
      } else {
        ElMessage.error('授权码不正确，请重新输入。');
      }
      authLoading.value = false;
    }
  });
};
</script>

<style scoped>
.app-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.dialog-header {
  /* background-color: #f0f0f0; */
  padding: 16px;
  padding-top:30px;
  text-align: center;
  border-bottom: 0px solid #e4e4e4;
}

.dialog-title {
  margin: 0;
  font-size: 24px;
  color: #333;
}

.dialog-content {
  padding: 24px;
  padding-top: 0px;
  padding-bottom: 0px;
}

.info-text {
  font-size: 16px;
  color: #666;
  margin-bottom: 20px;
}

.auth-form {
  /* max-width: 400px; */
  margin: 0 auto;
}

.button-container {
  display: flex;
  justify-content: flex-end !important;
  margin-top: 30px;
}
</style>    