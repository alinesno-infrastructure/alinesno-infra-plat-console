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
                  展示当前运行服务概览预览版</div>
              </div>
            </div>
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:calc(100% - 10px);padding:5px 0px" v-for="item in apps" :key="item">
                  <div class="app-icon" >
                    <i :class="item.icon" style="font-size: 1.4rem"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">
                      <el-link class="app-item-title" :underline="false" :href="item.linkPath" target="_blank">
                        {{ item.name }}
                      </el-link>
                    </div>
                    <div class="app-item desc">
                      {{ truncateString(item.productDescribe , 15) }}
                    </div>
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

import { getProductByTypeCode } from '@/api/console/product'

const apps = ref([])

function handleProductByTypeCode(){
  getProductByTypeCode('alinesno-infra-base').then(response => {
    console.log(response) ; 
    apps.value = response.data ;
  })
}

nextTick(() => {
  handleProductByTypeCode();
})

</script>