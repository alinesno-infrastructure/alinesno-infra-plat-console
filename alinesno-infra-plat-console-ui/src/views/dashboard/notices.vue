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
                  <div class="item-text-main-title">
                    <a :href="item.link" target="_blank">
                      {{ item.title }}
                    </a>
                  </div>
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
          <div class="panel-body" v-loading="getNewSolutionLoading">
            <ul class="panel-item-text">
              <li v-for="item in solutionItems" :key="item">
                <div class="item-datetime">
                  <div class="item-datetime-month">{{ handleDateFormat('m', item.addDate) }}</div>
                  <div class="item-datetime-date">{{ handleDateFormat('d', item.addDate) }}</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">
                    <a :href="item.link" target="_blank">
                      {{ item.title }}
                    </a>
                  </div>
                  <div class="item-text-main-desc">{{ truncateString(item.content,30) }}</div>
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

import{ getNewSolution } from '@/api/console/dashboard'
const getNewSolutionLoading = ref(true)

const dialogVisible = ref(false)
const roleChatUri = ref("")

const acpProjectBuild = [
  {
    id: '2',
    icon: 'fas fa-book-reader',
    title: '快速上手指南',
    desc: '完成你的第一个智能体创建与配置',
    link: 'http://portal.infra.linesno.com/technical/brain/04_角色自动化.html'
  },
  {
    id: '3',
    icon: 'fas fa-code',
    title: '编写第一个智能体脚本',
    desc: '如何编写简单的脚本来实现自动化',
    link: 'http://portal.infra.linesno.com/technical/brain/01_自定义智能体开发流程.html '
  },
  {
    id: '4',
    icon: 'fas fa-wrench',
    title: '配置智能体知识库',
    desc: '如何设置智能体的数据资产和知识',
    link: 'http://portal.infra.linesno.com/technical/brain/03_数据自动化采集.html '
  }
];

const solutionItems = ref([]);
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

// 格式化日期
const handleDateFormat = (formatIdentifier, dateString) => {
  // 创建一个新的Date对象
  const date = new Date(dateString);

  // 检查是否是有效的日期
  if (isNaN(date.getTime())) {
    throw new Error('Invalid date.');
  }

  // 根据传入的标识符来决定返回月份还是日期
  switch(formatIdentifier) {
    case 'm':
      // 返回带'月'字符的月份，并确保为两位数
      return `${date.getMonth() + 1}`.padStart(2, '0') + '月';
    case 'd':
      // 返回两位数格式的日期
      return date.getDate().toString().padStart(2, '0');
    default:
      throw new Error('Invalid format identifier. Use "m" for month or "d" for date.');
  }
};

// 获取到最新的解决方案
const handleGetNewSolution = () => {
  getNewSolution().then((res) => {
    getNewSolutionLoading.value = false
    if (res.code == 200) {
      solutionItems.value = res.data;
    }
  }).catch((error) => {
    getNewSolutionLoading.value = false
  }) ;
};

handleGetNewSolution();

</script>
