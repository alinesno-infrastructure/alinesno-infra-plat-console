<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 自动化运维套件</div>
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
                <li class="app-items" style="width:calc(100% - 10px)" v-for="item in apps" :key="item">
                  <div class="app-icon">
                    <!-- <img :src="item.icon" /> -->
                    <i :class="item.icon"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                  <div class="app-tip" style="float: right;font-size: 0.8rem;color:#a5a5a5">
                    <i class="fas fa-tools"></i> <span class="counter issues-label">1</span>
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
        <RunStatus />
      </el-col>
    </el-row>
  </div>
</template>

<script setup>

import RunStatus from './runStatus.vue'

const apps = ref([
  {icon:'fa-solid fa-ship' , name:'自动化操作服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-charging-station' , name:'分布式日志服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-truck-fast' , name:'分布式链路跟踪服务' , desc:'With Route 53 (3 分钟)'},
  { icon: 'fa-brands fa-slack', name: '容器管理服务', desc: 'With Route 53 (3 分钟)' },
  {icon:'fa-solid fa-ship' , name:'监控预警服务' , desc:'With EC2 (2 分钟)'},
  {icon:'fa-solid fa-file-pdf' , name:'一体化安全感触服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-charging-station' , name:'项目管理服务' , desc:'With Route 53 (3 分钟)'},
]);

</script>