<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="0" />

    <!-- 面板服务 -->
    <DashboardService />

    <!-- 解决方案 -->
    <DashboardApps />

    <!-- 通知服务 -->
    <DashboardNotices />

    <!-- 用户初始化信息 -->
    <DashboardCollectInfo />

  </div>
</template>

<script setup name="Index">

import DashboardCollectInfo from './dashboard/collect-info'
import DashboardService from './dashboard/service.vue'
import DashboardApps from './dashboard/apps.vue'
import DashboardNotices from './dashboard/notices.vue'
import HeadTypeTab from './headTypeTab.vue'

</script>
