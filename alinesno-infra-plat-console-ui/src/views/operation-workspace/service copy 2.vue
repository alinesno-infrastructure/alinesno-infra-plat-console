<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 自动运维套件</div>
          </div>
          <div class="panel-body acp-height-auto" >
            <div class="acp-app-list">
              <ul>
                <li class="app-items" v-for="item in apps" :key="item" style="width:calc(20% - 10px)">
                  <div class="app-icon">
                    <!-- <img :src="item.icon" :alt="item.name" /> -->
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

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-nurse"></i> 运维资产套件</div>
          </div>
          <div class="panel-body acp-height-auto">
            <ul class="panel-item-text">
              <li style="width:23%;padding:4px;border-bottom: 0px;" v-for="item in opertionAssets" :key="item.id">
                <div class="item-health-box">
                  <div class="item-health-title">{{ item.title }}</div>
                  <div class="item-health-count">{{ item.count }}</div>
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

const opertionAssets = ref([
  {id:'1' , title:'运维脚本' , count:45} ,
  {id:'2' , title:'服务资源' , count:145} ,
  {id:'3' , title:'持续集成' , count:65} ,
  {id:'4' , title:'自动配置' , count:85} ,
  {id:'5' , title:'配置管理' , count:45} ,
  {id:'6' , title:'安全监控' , count:45} ,
])

const apps = ref([
  {icon:'fa-solid fa-ship' , name:'自动化操作服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-charging-station' , name:'分布式配置中心' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-truck-fast' , name:'审计日志服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-ship' , name:'持续集成服务' , desc:'With Route 53 (3 分钟)'},
  {icon:'fa-solid fa-ship' , name:'容器云管理服务' , desc:'With EC2 (2 分钟)'},
  {icon:'fa-solid fa-file-pdf' , name:'一体化安全感触服务' , desc:'With Route 53 (3 分钟)'},
]);

</script>

<style lang="scss" scoped>
.item-health-title{
  margin-bottom: 5px !important;
}
.item-health-count{
  margin-bottom: 5px;
}
</style>