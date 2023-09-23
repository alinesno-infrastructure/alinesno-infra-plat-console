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

  </div>
</template>

<script setup name="Index">

import DashboardService from './dashboard/service.vue'
import DashboardApps from './dashboard/apps.vue'
import DashboardNotices from './dashboard/notices.vue'
import HeadTypeTab from './headTypeTab.vue'

</script>
