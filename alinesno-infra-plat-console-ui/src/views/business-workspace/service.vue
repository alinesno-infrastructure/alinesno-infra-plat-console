<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 业务服务套件</div>
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
                    <img :src="item.icon" />
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
              查看所有服务
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
              查看所有服务
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
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png" alt=""/>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title"> AIP入门 <i class="fa-solid fa-arrow-up-right-from-square"></i></div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？<i class="fa-solid fa-arrow-up-right-from-square"></i></div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？<i class="fa-solid fa-arrow-up-right-from-square"></i> </div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
              查看所有服务
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
  </div> 
</template>

<script setup>

const apps = ref([
  {icon: 'fa-solid fa-charging-station' , name:'权限资源引擎服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'https://d1by4p17n947rt.cloudfront.net/icon/051de32597041e41f73b97d61c67a13b-9cbdaf85e3bcf29b656fdedd8e6d1305.svg' , name:'网关配置服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'https://d1by4p17n947rt.cloudfront.net/icon/7177e919b32ad97825f95e902595014b-1594766d92813b5baeb706c453f91de0.svg' , name:'分布式配置中心服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-ship' , name:'公共存储服务' , desc:'With EC2 (2 分钟)'},
  {icon:'https://d1by4p17n947rt.cloudfront.net/icon/3da5e8169d2f1426f99fbef54575fe96-6382cb2dfdd2f74c99bc8a64a338358e.svg' , name:'单点登陆管理服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg' , name:'安全验证码服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-truck-fast' , name:'分布式消息服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-file-shield' , name:'多渠道通知服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg' , name:'代码生成器服务' , desc:'With Route 53 (3 分钟)'},
]);

</script>