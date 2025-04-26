<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="0" />

    <el-row>
      <el-col :span="24">
        <div class="aip-appinfo-header">
          <div class="header-icon-banner">
            <i class="fa-brands fa-slack"></i>
          </div>
          <div class="icon">
            <div class="title">
                  {{ currentEnvClusterObj.appName }}
              <div class="cluster-info">
                <span><i class="el-icon-monitor"></i>
                  {{ currentEnvClusterObj.clusterName }}
                </span>
              </div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 解决方案 -->
    <DashboardService />

    <!-- 通知服务 -->
    <DashboardNotices @handleChannelChat="handleChannelChat"/>

    <!-- 工具区功能全景图 -->
    <!-- <DashboardProductAll /> -->

    <!-- 企业授权码-->
    <AuthDashboard />

  </div>
</template>

<script setup name="Index">

// import {
//   getGreeting
// } from '@/api/console/dashboard'

import AuthDashboard from './authDashboard.vue'
import DashboardCollectInfo from './dashboard/collect-info'
import DashboardProductAll from './dashboard/product-all'
import DashboardServiceStatus from './dashboard/serviceStatus.vue'
import DashboardService from './dashboard/service'
import DashboardApp from './dashboard/apps'
import DashboardRunStatus from './dashboard/dashboardRunStatus'
import DashboardNotices from './dashboard/notices.vue'
import HeadTypeTab from './headTypeTab.vue'

const chatTitle = ref("")
const dialogVisible = ref(false)
const roleChatUri = ref("")

const currentEnvClusterObj = ref({
  appName : 'AIP工作区(Studio)'  ,
  clusterName: '赋能团队创建自主智能体的全生命周期管理平台，驱动业务创新与智能自动化'  ,
})

/** 与单个频道发信息 */
function handleChannelChat(item){
    // roleChatUri.value = "/channelChat?channel=" + item.id;
    roleChatUri.value = "http://alinesno-infra-smart-im-ui.beta.smart.infra.linesno.com/channelChat?channel=1"
    chatTitle.value = item.channelName;
    dialogVisible.value = true ;
}

// onMounted(() => {
//   getGreeting().then(res => {
//     currentEnvClusterObj.value.appName = res.data;
//   })
// })

</script>


<style lang="scss" scoped>
.aip-appinfo-header{
  position: relative;
  padding: 10px;
  overflow: hidden;

  .header-icon-banner {
    float: left;
    font-size: 2.0rem;
    margin-right: 10px;
    color: #3b5998;
  }

  .head-app-status{
    float: right;
    font-size: 14px;
    line-height: 1.7rem;
    margin-bottom: 10px;

    .integrated-item-box {

      margin-left: 10px;
      float: right;

      ul , li {
        margin: 0px;
        padding: 0px;
        list-style: none;
      }
      li {
        float:right ;
        margin-right: 10px;

        img {
          border-radius: 5px;
          width: 25px;
        }
      }

    }
  }

  .cluster-info {
    float: right;
    position: relative;
    font-size: 14px;
    margin-left: 10px;
    font-weight: bold;
    margin-top: 10px;
    color: #3b5998;

    span {
      margin-left: 20px;
    }
  }

  .icon {
    float: left;
  }

  .title {
    display: block;
    font-weight: 600;
    font-style: normal;
    font-size: 24px;
    color: #242e42;
    text-shadow: 0 4px 8px rgba(36, 46, 66, 0.1);
    // margin-bottom: 10px;
  }

  .title-desc {
    color: #79879c !important;
    font-size: 12px;
  }
}
</style>
