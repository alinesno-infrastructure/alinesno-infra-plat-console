<template>
  <div class="app-container">
    <el-dialog
      v-model="centerDialogVisible"
      title="了解一下你的情况"
      width="60%"
      :close-on-press-escape="false"
      :close-on-click-modal ="false"
      append-to-body
      align-center
    >
    <span>平台会根据你的基础情况，我们会结合AIGC更好的给你推荐内容组件初始化</span>

    <el-steps :active="active" finish-status="success" simple style="margin-top: 20px">
      <el-step title="基础情况" />
      <el-step title="初始化平台" />
    </el-steps>

    <div class="aip-info-box">

      <el-form :model="form" label-width="120px" v-if="active == 0">

          <el-divider content-position="left">基础信息</el-divider>
          
          <el-form-item label="你的头像">
            <div style="margin-top: -10px;">
              <el-avatar :size="50" :src="state.circleUrl" />
            </div>
          </el-form-item>

          <el-form-item label="职位职责">
            <el-select v-model="form.region" size="large" placeholder="请选择你当前的岗位职责" style="width:50%">
              <el-option label="软件开发工程师" value="shanghai" />
              <el-option label="数据开发工程师" value="beijing" />
              <el-option label="测试工程师" value="beijing" />
              <el-option label="业务开发工程师" value="beijing" />
              <el-option label="技术架构师" value="beijing" />
              <el-option label="解决方案架构师" value="beijing" />
              <el-option label="技术负责人" value="beijing" />
            </el-select>
          </el-form-item>
          <el-form-item label="工作年限">
            <el-select v-model="form.region" size="large" placeholder="请选择你的工作年限" style="">
              <el-option label="在校学习生" value="shanghai" />
              <el-option label="1-3年" value="beijing" />
              <el-option label="3-5年" value="beijing" />
              <el-option label="5-10年" value="beijing" />
              <el-option label="10年+" value="beijing" />
            </el-select>
          </el-form-item>
          <el-form-item label="能力水平" size="large">
            <el-radio-group v-model="form.resource">
              <el-radio label="初级" />
              <el-radio label="中级" />
              <el-radio label="高级" />
            </el-radio-group>
          </el-form-item>

          <el-form-item label="自我介绍">
            <el-input v-model="form.name" size="large" placeholder="请用一句话简单的介绍你自己，比如:我是一名会设计和编码的小金大人" />
          </el-form-item>

          <el-divider content-position="left">职业规划</el-divider>

          <el-form-item label="成长期望">
            <el-select v-model="form.region" size="large" placeholder="请选择你未来的成长期望" style="width:50%">
              <el-option label="软件开发工程师" value="shanghai" />
              <el-option label="数据开发工程师" value="beijing" />
              <el-option label="测试工程师" value="beijing" />
              <el-option label="业务开发工程师" value="beijing" />
              <el-option label="技术架构师" value="beijing" />
              <el-option label="解决方案架构师" value="beijing" />
              <el-option label="技术负责人" value="beijing" />
            </el-select>
          </el-form-item>
          <el-form-item label="理想待遇">
            <el-select v-model="form.region" size="large" placeholder="请你考虑你未来的期望待遇" style="width:50%">
              <el-option label="5万-10万" value="shanghai" />
              <el-option label="10万-20万" value="shanghai" />
              <el-option label="20万-50万" value="shanghai" />
              <el-option label="50万-100万" value="shanghai" />
              <el-option label="100万+" value="shanghai" />
            </el-select>
          </el-form-item>

        </el-form>

        <div v-if="active == 1">
          <div class="aip-aigc-info-message">

            <div>
              欢迎张三！我们很高兴能为您提供帮助。根据您的经验和期望，我们为您推荐以下10个AIP服务，这些服务将帮助您更好地学习和成长，为您成为一名解决方案架构师奠定基础。
            </div>
            <br/>

              1. alinesno-infra-common:核心开发框架，了解并掌握企业级应用开发的基础框架。 <br/>
              2. alinesno-infra-base-config:分布式配置服务，学习分布式系统的配置管理，提高系统可维护性。 <br/>
              3. alinesno-infra-data-pipeline:数据集成服务，掌握数据处理和集成技术，提升数据处理能力。 <br/>
              4. alinesno-infra-data-security:数据安全服务，加强对数据安全和隐私保护的认识，提升系统安全性。 <br/>
              5. alinesno-infra-base-workflow:流程中心服务，理解业务流程管理，提高业务协同效率。  <br/>
              6. alinesno-infra-smart-nlp:自然语言识别服务，了解自然语言处理技术，拓展人工智能领域知识。  <br/>
              7. alinesno-infra-ops-telemetry:分布式链路跟踪服务，掌握分布式系统的性能监控和优化技巧。  <br/>
              8. alinesno-infra-ops-container:容器管理服务，学习容器技术和容器编排，为微服务架构做准备。  <br/>
              9. alinesno-infra-data-algorithm:数据算法服务，了解机器学习和深度学习算法，提高在人工智能领域的技能。 <br/>
              <br/>

              希望这些建议对您的学习和成长有所帮助！如果您有任何疑问，请随时向我们咨询。祝您事业顺利！
          </div>
        </div>

    </div>

    <template #footer>
      <span class="dialog-footer">
        <!-- 
        <el-button @click="centerDialogVisible = false" size="large">
          关闭
        </el-button> 
        -->
        <el-button type="primary" @click="nextStep" size="large">
          下一步 
        </el-button>
      </span>
    </template>
  </el-dialog>
  </div>
</template>

<script setup>

const centerDialogVisible = ref(true)

const active = ref(0)
const state = reactive({
  circleUrl: 'http://data.linesno.com/switch_header.png'
})

/** 进入下一步操作 */
function nextStep(){

  alert('this is a test') ;
  console.log('active = ' + active.value) ;

  if (active.value++ > 0) {
    active.value = 0 ;
  }
}

// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

const onSubmit = () => {
  console.log('submit!')
}

</script>

<style lang="scss" scoped>

.aip-info-box {
  margin-top: 30px;

  .aip-aigc-info-message {
    padding: 20px 50px;
    line-height: 1.5rem;
  }
}

</style>