<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">探索AIP使用</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li v-for="item in acpProjectBuild" :key="item.id">
                <div class="item-icon">
                  <i :class="item.icon" style="font-size:25px;margin-right:5px;color: #3b5998;margin-top:10px;"></i>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">{{ item.title }}</div>
                  <div class="item-text-main-desc">{{ item.desc }}</div>
                </div>
              </li>
            </ul>
          </div>

        </div>
      </el-col>

      <!-- 协助列表-->
      <el-col :span="8">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">最新解决方案</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li v-for="item in solutionItems" :key="item">
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">{{ item.title }}</div>
                  <div class="item-text-main-desc">{{ item.description }}</div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </el-col> 
      
      <el-col class="panel-col" :span="11">

        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fas fa-shipping-fast"></i> 运行统计</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">

              <!-- 使用 v-for 指令来遍历 panelItems 数组 -->
              <li v-for="(item, index) in panelItems" :key="index" style="width:50%;">
                <div class="item-health-box">
                  <div class="item-health-title" style="font-size: 15px;color: #3b5998;font-weight: 550;">
                    <i :class="item.icon" />
                    {{ item.title }}
                  </div>
                  <div class="item-health-count">{{ item.count }}</div>
                  <div class="item-health-outtime">{{ item.outtime }}</div>
                </div>
              </li>

            </ul>
          </div>
        </div>
      </el-col>

    </el-row>

    <el-dialog v-model="dialogVisible" width="860" :before-close="handleClose">
        <iframe :src="roleChatUri" class="role-chat-iframe"></iframe>
    </el-dialog>

  </div>
</template>

<script setup>

import {defineEmits} from 'vue'
const emit = defineEmits(['handleChannelChat'])

const chatTitle = ref("")
const dialogVisible = ref(false)
const roleChatUri = ref("")

// const tableData = [
//   {name:'需求文档分析频道' , count:'正在分析数据工程结构，分析需求文档中', icon:'fa-solid fa-file-shield' , link:1} ,
//   {name:'项目功能细化分析频道' , count:'数据功能细化分析中，异常问题收集', icon:'fas fa-shipping-fast' , link:2} ,
//   {name:'K8S问题排查频道' , count:'排查k8s问题分析，正在发送给业务人员，正在发送给业务人员', icon:'fa-solid fa-feather-pointed' , link:3} ,
//   {name:'Ansible自动化工程师' , count:'生成自动化运营平台，正在集成业务服务', icon:'fas fa-train' , link:4} ,
//   {name:'产品客户服务频道' , count:'客户服务专家列表结构，正在跟客户沟通中', icon:'fas fa-server' , link: 5} ,
//   {name:'开发编码规范频道' , count:'编码结构的失败服务，正在进一步编码中', icon:'fas fa-pencil-ruler' , link: 6} ,
// ]

const acpProjectBuild = [
  {
    id: '2',
    icon: 'fas fa-book-reader',
    title: '快速上手指南',
    desc: '完成你的第一个智能体创建与配置',
    link: '/dashboard/getting-started/quick-start'
  },
  {
    id: '3',
    icon: 'fas fa-code',
    title: '编写第一个智能体脚本',
    desc: '如何编写简单的脚本来实现自动化',
    link: '/dashboard/getting-started/write-first-script'
  },
  {
    id: '4',
    icon: 'fas fa-wrench',
    title: '配置智能体知识库',
    desc: '如何设置智能体的数据资产和知识',
    link: '/dashboard/getting-started/configure-permissions'
  }
];

const solutionItems = ref([
  {
    datetime: '2024-12-19',
    title: '智能化运维分析：通过智能体优化系统性能',
    description: '利用智能体实时监控和自动调整系统参数，降低了运维成本。'
  },
  {
    datetime: '2024-12-19',
    title: '智能化运维分析：智能日志管理与故障预测',
    description: '引入智能体进行日志管理和故障预测，问题的提前预警和快速定位。'
  },
  {
    datetime: '2024-12-19',
    title: '软文推广营销：社交媒体自动化互动',
    description: '使用智能体实现社交媒体上的自动化互动，增大曝光度和用户参与度。'
  }
]);


const panelItems = ref([
  {
    icon: 'fa-solid fa-signature',
    title: '消耗Token数量',
    count: 250000,
    outtime: '过去7天',
    cost: '$750.00'
  },
  {
    icon: 'fa-solid fa-image',
    title: '生成图片数量',
    count: 3500,
    outtime: '过去7天',
    cost: '$300.00'
  },
  {
    icon: 'fa-solid fa-robot',
    title: '调用智能体次数',
    count: 7500,
    outtime: '过去7天',
    cost: '$500.00'
  },
  {
    icon: 'fa-solid fa-check-circle',
    title: '正常执行的次数',
    count: 85000,
    outtime: '过去7天',
    cost: '$600.00'
  },
  {
    icon: 'fa-solid fa-exclamation-triangle',
    title: '异常的次数',
    count: 500,
    outtime: '过去7天',
    cost: '$150.00'
  },
  {
    icon: 'fa-solid fa-stopwatch',
    title: '生成的时间消耗 (秒)',
    count: 23, // 假设是分钟
    outtime: '过去7天',
    cost: '$30.00'
  },
  {
    icon: 'fas fa-file-signature',
    title: '消费使用金额(RMB)',
    count: 612, // 假设是分钟
    outtime: '过去7天',
    cost: '$30.00'
  }
]);


/** 与单个频道发信息 */
function handleChannelChat(item){
  emit('handleChannelChat' , item)
}

/** 与单个Role发信息 */
function handleRoleChat(item){
    roleChatUri.value = "http://alinesno-infra-smart-im-ui.beta.smart.infra.linesno.com/agentChat?roleId=1808349647059738625"
    chatTitle.value = item.roleName ;
    dialogVisible.value = true ;
}

</script>
