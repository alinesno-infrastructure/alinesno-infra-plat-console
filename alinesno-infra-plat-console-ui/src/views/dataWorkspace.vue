<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="2" />

    <!-- 数据套件和状态 -->
    <DataWorkspaceService />

    <!-- 运行应用列表 -->
    <!-- <DataWorkspaceApps /> -->
  </div>
</template>

<script setup name="Index">

import HeadTypeTab from './headTypeTab.vue'

import DataWorkspaceService from './data-workspace/service.vue'


</script>
