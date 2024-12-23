<template>
    <div class="container">
      <el-dialog
        v-model="centerDialogVisible" 
        width="50%" 
        :before-close="handleClose"
        :close-on-press-escape="false" 
        :close-on-click-modal="false" append-to-body align-center>

        <div class="product-panel">
          <div class="product-text">
            AIP工作区是专为构建、开发和管理智能体（Agents）而设计的综合性平台。它提供了一套完整的工具链，
            从数据收集与感知到智能决策和持续监控，助力打造智能体，以应对各种复杂的业务挑战。
          </div>
          <div class="product-img">
            <img src="http://data.linesno.com/banner/studio_products.png" />
          </div>
        </div>
        <br/>
      </el-dialog>  
    </div>
</template>

<script setup>
import { ref } from 'vue';

const centerDialogVisible = localStorage.getItem('product_display_tip') == 1 ? ref(false) : ref(true);

const handleClose = () => {
  localStorage.setItem('product_display_tip', 1);
  centerDialogVisible.value = false;
}

</script>

<style lang="scss" scoped>
.product-panel {
  .product-text {
    font-size: 1rem;
    color: #333;
    line-height: 2rem;
    font-weight: 500;
  }

  .product-img {
    img {
      width:100%;
    }
  }
}
</style>