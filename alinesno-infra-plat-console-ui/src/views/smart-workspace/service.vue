<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 智能运营服务</div>
          </div>
          <div class="panel-body">
            <div class="panel-app-status">
              <div class="app-status-icon">
                <i class="fa-brands fa-dashcube"></i>
              </div>
              <div class="app-status-text">
                <div class="app-status-text-desc">展示当前运行服务概览和详情，您可以查看了解目前集成的基础能力和平台能力。 演示环境为最新功能预览版</div>
              </div>
            </div>
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:calc(33% - 10px)" v-for="item in apps" :key="item">
                  <div class="app-icon">
                    <!-- <img :src="item.icon" /> -->
                    <i :class="item.icon"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
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

      <el-col :span="6">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-nurse"></i> 服务健康报告</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">未解决问题</div>
                  <div class="item-health-count">41</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">预定更改</div>
                  <div class="item-health-count">32</div>
                  <div class="item-health-outtime">即将到来和过去 7 天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">运行通知</div>
                  <div class="item-health-count">32</div>
                  <div class="item-health-outtime">过去14天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">其它通知</div>
                  <div class="item-health-count">12</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-feather"></i> 解决方案示例</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png"
                    alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title"> AIP入门 <i class="fa-solid fa-arrow-up-right-from-square"></i></div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png"
                    alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？<i class="fa-solid fa-arrow-up-right-from-square"></i>
                  </div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png"
                    alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？<i class="fa-solid fa-arrow-up-right-from-square"></i>
                  </div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>

const apps = ref([
  { icon: 'fa-solid fa-charging-station', name: '实时计算服务(Flink)', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '数据采集总线', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '主数据服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '数据计算服务', desc: 'With EC2 (2 分钟)' },
  { icon: 'fa-solid fa-tags', name: '数据上报服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '数据集成服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '数据资产服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-hammer', name: '数据网关服务', desc: 'With Route 53 (3 分钟)' },
]);

</script>