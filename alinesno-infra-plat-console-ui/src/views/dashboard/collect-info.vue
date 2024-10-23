<template>
  <div class="app-container">
    <el-dialog v-model="centerDialogVisible" title="了解一下你的情况" width="60%" :close-on-press-escape="false"
      :close-on-click-modal="false" append-to-body align-center>
      <span>AIP会根据你的基础情况，更好的给你推荐合适的智能体和频道.</span>

      <div class="aip-info-box">

        <el-form :model="form" :rules="rules" label-width="120px" ref="formRef" v-if="active == 0">

          <el-divider content-position="left">基础信息</el-divider>

          <el-form-item label="职位职责" prop="jobRole">
            <el-select v-model="form.jobRole" size="large" placeholder="请选择你当前的岗位职责" style="width:50%">
              <el-option v-for="option in jobRoles" :key="option.value" :label="option.label" :value="option.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="工作年限" prop="workExperience">
            <el-select v-model="form.workExperience" size="large" placeholder="请选择你的工作年限" style="">
              <el-option v-for="option in workExperiences" :key="option.value" :label="option.label" :value="option.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="能力水平" prop="skillLevel" size="large">
            <el-radio-group v-model="form.skillLevel">
              <el-radio v-for="option in skillLevels" :key="option.value" :label="option.value">{{ option.label }}</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="自我介绍" prop="selfIntroduction">
            <el-input v-model="form.selfIntroduction" size="large" placeholder="请用一句话简单的介绍你自己" />
          </el-form-item>

          <el-divider content-position="left">职业规划</el-divider>

          <el-form-item label="成长期望" prop="growthExpectation">
            <el-select v-model="form.growthExpectation" size="large" placeholder="请选择你未来的成长期望" style="width:50%">
              <el-option v-for="option in growthExpectations" :key="option.value" :label="option.label" :value="option.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="理想待遇" prop="idealSalary">
            <el-select v-model="form.idealSalary" size="large" placeholder="请你考虑你未来的期望待遇" style="width:50%">
              <el-option v-for="option in idealSalaries" :key="option.value" :label="option.label" :value="option.value" />
            </el-select>
          </el-form-item>

        </el-form>

      </div>

      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="onSubmit" v-loading="loading" size="large">
            完 成
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import { ElLoading, ElMessage } from 'element-plus';

const centerDialogVisible = localStorage.getItem('info_login_count') == 1 ? ref(false) : ref(true);
const active = ref(0);
const loading = ref(false);
const formRef = ref(null);

const form = reactive({
  jobRole: '',
  workExperience: '',
  skillLevel: '',
  selfIntroduction: '',
  growthExpectation: '',
  idealSalary: ''
});

const rules = {
  jobRole: [{ required: true, message: '请选择你的职位职责', trigger: 'change' }],
  workExperience: [{ required: true, message: '请选择你的工作年限', trigger: 'change' }],
  skillLevel: [{ required: true, message: '请选择你的能力水平', trigger: 'change' }],
  selfIntroduction: [{ required: true, message: '请输入自我介绍', trigger: 'blur' }],
  growthExpectation: [{ required: true, message: '请选择你的成长期望', trigger: 'change' }],
  idealSalary: [{ required: true, message: '请选择你的理想待遇', trigger: 'change' }]
};

// 提取选项到变量，并将 value 设置为英文
const jobRoles = [
  { value: 'software_developer', label: '软件开发工程师' },
  { value: 'data_developer', label: '数据开发工程师' },
  { value: 'test_engineer', label: '测试工程师' },
  { value: 'business_developer', label: '业务开发工程师' },
  { value: 'technical_architect', label: '技术架构师' },
  { value: 'solution_architect', label: '解决方案架构师' },
  { value: 'technical_leader', label: '技术负责人' }
];

const workExperiences = [
  { value: 'student', label: '在校学习生' },
  { value: '1_to_3_years', label: '1-3年' },
  { value: '3_to_5_years', label: '3-5年' },
  { value: '5_to_10_years', label: '5-10年' },
  { value: 'over_10_years', label: '10年+' }
];

const skillLevels = [
  { value: 'beginner', label: '初级' },
  { value: 'intermediate', label: '中级' },
  { value: 'advanced', label: '高级' }
];

const growthExpectations = [...jobRoles]; // 假设成长期望与职位职责相同

const idealSalaries = [
  { value: '50k_to_100k', label: '5万-10万' },
  { value: '100k_to_200k', label: '10万-20万' },
  { value: '200k_to_500k', label: '20万-50万' },
  { value: '500k_to_1m', label: '50万-100万' },
  { value: 'over_1m', label: '100万+' }
];

const onSubmit = () => {
  formRef.value.validate((valid) => {
    if (valid) {
      console.log('submit!');
    }
  });
};
</script>