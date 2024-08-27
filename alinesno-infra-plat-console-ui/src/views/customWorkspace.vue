<template>
  <div class="app-container acp-dashboard">

    <!-- 面板切换-->
    <HeadTypeTab :currentTab="5" />

    <!-- 自定义用户应用 -->
    <CustomApps />

  </div>
</template>

<script setup name="Index">

/**  导入组件 */
import HeadTypeTab from './headTypeTab.vue'
// import CustomApps from './custom-workspace/ucenter-apps.vue'
import CustomApps from './custom-workspace/service.vue'

</script>
