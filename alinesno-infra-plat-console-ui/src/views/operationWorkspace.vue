<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="4" />

    <!-- 应用统计 -->
    <!-- <OperationWorkspaceCountStaitcs /> -->

    <!-- 应用套件和状态 -->
    <OperationWorkspaceService />

    <!-- 运行应用列表 -->
    <!-- <OperationWorkspaceApps /> -->

  </div>
</template>

<script setup name="Index">

import HeadTypeTab from './headTypeTab.vue'
import OperationWorkspaceService from './operation-workspace/service.vue'

</script>
