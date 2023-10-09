<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="1" />

    <!-- 面板服务 -->
    <DashboardService />

    <!-- 解决方案 -->
    <DashboardApps />

    <!-- 通知服务 -->
    <!-- <DashboardNotices /> -->

    <!-- 用户初始化信息 -->
    <!-- <DashboardCollectInfo /> -->

  </div>
</template>

<script setup name="Index">

// import DashboardCollectInfo from './dashboard/collect-info'
import DashboardService from './runstatus-workspace/service.vue'
import DashboardApps from './runstatus-workspace/apps.vue'
import DashboardNotices from './runstatus-workspace/notices.vue'
import HeadTypeTab from './headTypeTab.vue'

</script>
