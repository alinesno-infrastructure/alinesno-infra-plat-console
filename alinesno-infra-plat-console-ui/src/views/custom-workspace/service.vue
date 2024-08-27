<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 技术服务套件</div>
          </div>
          <div class="panel-body" style="height:auto">
            <div class="panel-app-status" style="margin-bottom:0px">
              <div class="app-status-text">
                  <div class="app-status-icon">
                    <i class="fa-brands fa-dashcube"></i>
                  </div>
                <div class="app-status-text-desc">
                  展示当前运行服务概览和详情为最新功能预览版</div>
              </div>
            </div>
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:calc(100% - 10px);padding:5px 0px" v-for="item in apps" :key="item">
                  <div class="app-icon" >
                    <!-- <img :src="item.icon" /> -->
                    <i :class="item.icon" style="font-size: 1rem"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                  <div class="app-tip" style="float: right;font-size: 0.8rem;color:#a5a5a5">
                    <i class="fas fa-tools"></i> <span class="counter issues-label">0</span>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="19">
        <UcenterApps />
      </el-col>
    </el-row>
  </div>
</template>

<script setup>

import UcenterApps from './ucenterApps.vue'

const apps = ref([
  {icon: 'fa-solid fa-charging-station' , name:'权限资源引擎服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-truck' , name:'网关配置服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-paper-plane' , name:'分布式配置中心服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-ship' , name:'公共存储服务' , desc:'With EC2 (2 分钟)'},
  {icon: 'fa-solid fa-tags' , name:'单点登陆管理服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-file-export' , name:'安全验证码服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-truck-fast' , name:'分布式消息服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-ship' , name:'公共存储服务' , desc:'With EC2 (2 分钟)'},
  {icon: 'fa-solid fa-ship' , name:'多渠道通知服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-hammer' , name:'代码生成器服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-truck' , name:'网关配置服务' , desc:'With Route 53 (3 分钟)'},
]);

</script>