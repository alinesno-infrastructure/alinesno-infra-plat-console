<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 数据治理套件</div>
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
        <RunStatus />
      </el-col>
    </el-row>
  </div>
</template>

<script setup>

import RunStatus from './runStatus.vue'

const apps = ref([
  { icon: 'fa-solid fa-charging-station', name: '主数据服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-brands fa-slack', name: '数据上报服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '数据集成服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fab fa-github-square', name: '数据编排计算服务', desc: 'With EC2 (2 分钟)' },
  { icon: 'fa-solid fa-tags', name: '实时计算服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '数据安全服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fas fa-paper-plane', name: '数据总线服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-hammer', name: '数据资产服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fas fa-feather fa-fw', name: '数据接口服务', desc: 'With Route 53 (3 分钟)' },
]);

</script>