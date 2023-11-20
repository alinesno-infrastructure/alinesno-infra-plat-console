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
                <span>
                  <i class="el-icon-link"></i> 
                  应用地址: {{ currentEnvClusterObj.apiServerUrl }}
                </span>
              </div>
            </div>
            <div class="title-desc">
              集群状态展示集群资源的概览和详情，您可以查看集群资源的监控数据和用量排行情况。
            </div>
          </div>
        </div>
      </el-col>
    </el-row>


    <!-- 面板服务 -->
    <DashboardService />

    <!-- 解决方案 -->
    <DashboardApps />

    <!-- 通知服务 -->
    <!-- <DashboardNotices /> -->

    <!-- 用户初始化信息 
    <DashboardCollectInfo />
    -->

  </div>
</template>

<script setup name="Index">

import DashboardCollectInfo from './dashboard/collect-info'
import DashboardService from './dashboard/service.vue'
import DashboardApps from './dashboard/apps.vue'
import DashboardNotices from './dashboard/notices.vue'
import HeadTypeTab from './headTypeTab.vue'



const currentEnvClusterObj = ref({
  appName : '晚上好, 罗小东'  , 
  clusterName: '集成多种能力的超自动化基础设施'  , 
  apiServerUrl: 'http://portal.infra.linesno.com'
}) 

</script>


<style lang="scss" scoped>
.aip-appinfo-header{
  position: relative;
  padding: 20px;
  overflow: hidden;

  .header-icon-banner {
    float: left;
    font-size: 2.4rem;
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
    margin-bottom: 10px;
  }

  .title-desc {
    color: #79879c !important;
    font-size: 12px;
  }
}
</style>
