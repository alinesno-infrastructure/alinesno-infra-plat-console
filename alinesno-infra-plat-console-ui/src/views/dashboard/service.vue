<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <div class="panel-body" style="padding: 0px !important">
            <el-row>
              <el-col :span="24">
                <div class="panel-app-status">
                  <div class="app-status-text">
                    <div class="app-status-text-desc">&nbsp;演示环境为最新功能预览版</div>
                  </div>
                </div>
              </el-col>
              <el-col :span="24">
                <div class="grid-content">
                  <div class="panel-header">
                    <div class="header-title">
                      <i class="fa-solid fa-users-gear"></i> 最近使用
                    </div>
                  </div>
                  <div class="data-card" v-loading="hasRecommendLoading">
                    <ul class="count-list summary-panel">
                      <li class="count-data bg-red" v-for="(item , index) in runCountArr" :key="index">
                        <span class="label-tip">
                          <a :href="item.linkPath" style="display: flex;flex-wrap: wrap;align-items: center;">
                            <i :class="item.icon"></i>
                            <div style="float: left;margin-top: 3px;margin-left: 10px;width: calc(100% - 50px);">
                              {{ item.name }}
                              <br/>
                              <span class="label" style="font-size: 13px;line-height: 13px;font-weight: lighter;">{{ item.productDescribe }}</span>
                            </div>
                          </a>
                        </span>
                      </li>
                    </ul>
                  </div>
                </div>
              </el-col>

            </el-row>

          </div>
        </div>
      </el-col>

      <!-- 快捷方式 -->
      <el-col :span="6">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-feather"></i> 快捷接入智能体能力</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li v-for="item in acpProjectBuild" :key="item.id">
                <div class="item-icon">
                  <i :class="item.icon" style="font-size:25px;margin-right:5px;color: #3b5998;margin-top:10px;"></i>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">
                    <a :href="item.link">
                     {{ item.title }}  <i class="fa-solid fa-arrow-up-right-from-square"></i>
                    </a>
                  </div>
                  <div class="item-text-main-desc">{{ item.desc }}</div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-nurse"></i> 运行统计</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">智能体数量</div>
                  <div class="item-health-count">233312</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">集成频道数量</div>
                  <div class="item-health-count">814222</div>
                  <div class="item-health-outtime">即将到来和过去 7 天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">自定义场景数量</div>
                  <div class="item-health-count">71132</div>
                  <div class="item-health-outtime">过去14天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">运行通知</div>
                  <div class="item-health-count">238112</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </el-col>


    </el-row>
  </div>
</template>

<script setup>

// import { getProduct } from "@/api/console/product";
import { getRecommendedProducts } from '@/api/console/dashboard'

const hasRecommendLoading = ref(true)
const runCountArr = ref([]) ;

const acpProjectBuild = [
  {
    id: '1',
    icon: 'fa-solid fa-signature',
    title: '创建AIP智能体角色',
    desc: '通过模板快速定义智能体的角色与权限',
    link: 'http://alinesno-infra-smart-expert-ui.beta.base.infra.linesno.com'
  },
  {
    id: '3',
    icon: 'fas fa-laptop-code',
    title: '创建智能体数据资产',
    desc: '数据管理和治理，管理智能体数据资产',
    link: 'http://alinesno-infra-data-scheduler-ui.beta.base.infra.linesno.com'
  },
  {
    id: '2',
    icon: 'fas fa-file-signature',
    title: '创建业务服务能力',
    desc: '构建和优化业务服务流程，集成智能体能力',
    link: 'http://alinesno-infra-base-starter-ui.beta.base.infra.linesno.com'
  },
];

const handleGetRecommendedProducts = () => {
  getRecommendedProducts().then(response => {
    console.log(response);
    runCountArr.value = response.data ;
    hasRecommendLoading.value = false 
  }).catch(error => {
    console.log(error);
    hasRecommendLoading.value = false 
  });
};

handleGetRecommendedProducts() ;

// const screenJsonList = [];

// function getProductList() {
//     getProduct().then(response => {
//         console.log('response = ' + response);
//         productList.value = response.data ;
//     });
// };

</script>

<style lang="scss" scoped>
.panel-body{
  height: auto;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
  ul.count-list {
    list-style: none;
    float: left;
    padding: 0px;
    margin: 0px;
    width: 100%;

    li.count-data {
      float: left;
      background: #f7f9fa;
      border: 0px;
      position: relative;
      text-align: left;
      margin-right: 0px;
      padding: 10px 15px;
      width: calc(50% - 0px);
      text-decoration: none;
      overflow: hidden;
      border-width: 0px;
      border-style: solid;
      border-radius: 2px;
      transition: all 0.1s linear;
      height: 70px;
      margin-bottom: 5px;
      margin-top: 5px;
      margin-left: 0px;

      i{
        // float: right;
        // position: absolute;
        right: 10px;
        font-size: 30px;
        top: 15px;
        opacity: .9;
        color: #d33233;
      }

      span.label-tip {
        width: 100%;
        float: left;
        font-size: 15px;
        font-weight: 550;
        color: #3b5998;
      }

      span.label {
        color: #333;
        background: none;
        line-height: 36px;
        font-size: 20px;
      }
    }
  }

.data-card {
    float: left;
    background: #fff;
    padding-bottom: 10px;
}

.summary-panel {
  .el-col {
    border-radius: 5px;
    border-width: 0px;
  }
}

</style>
