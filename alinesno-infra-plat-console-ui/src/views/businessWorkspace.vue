<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="1" />

    <!-- 应用套件和状态 -->
    <BusinessWorkspaceService />

  </div>
</template>

<script setup name="Index">

import BusinessWorkspaceService from './business-workspace/service.vue'
import HeadTypeTab from './headTypeTab.vue'

</script>
