<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <!-- <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 服务运行状态</div>
          </div> -->
          <div class="panel-body">
            <el-row>
              <el-col :span="24">
                <div class="panel-app-status">
                  <!-- <div class="app-status-icon">
                    <i class="fa-solid fa-laptop-code"></i>
                  </div> -->
                  <div class="app-status-text">
                    <div class="app-status-text-desc">&nbsp;展示当前运行服务概览和详情，您可以查看了解目前集成的基础能力和平台能力。 演示环境为最新功能预览版</div>
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
                  <div class="data-card">
                    <ul class="count-list summary-panel">
                      <li class="count-data bg-red" v-for="(item , index) in runCountArr" :key="index">
                        <span class="label-tip">
                          <a :href="item.link" style="display: flex;flex-wrap: wrap;align-items: center;">
                            <i :class="item.icon"></i>
                            <div style="float: left;margin-top: 3px;margin-left: 10px;width: calc(100% - 50px);">
                              {{ item.name }}
                              <br/>
                              <span class="label" style="font-size: 13px;line-height: 13px;font-weight: lighter;">{{ item.count }}</span>
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
                    <router-link :to="item.link">
                     {{ item.title }}  <i class="fa-solid fa-arrow-up-right-from-square"></i>
                    </router-link>
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

import { getProduct } from "@/api/console/product";

const runCountArr = ref([
      {name:'大模型推理服务' , count:'正在分析数据工程结构，分析需求文档中', icon:'fa-solid fa-file-shield' , link:'http://alinesno-infra-smart-expert-ui.beta.smart.infra.linesno.com'} ,
      {name:'数据资产服务' , count:'客户服务专家列表结构，正在跟客户沟通中', icon:'fas fa-server' , link: "http://alinesno-infra-data-assets-ui.beta.base.infra.linesno.com"} ,
      {name:'数据编排计算服务' , count:'数据功能细化分析中，异常问题收集', icon:'fas fa-shipping-fast' , link:'http://alinesno-infra-data-scheduler-ui.infra.dev.linesno.com'} ,
      {name:'向量库搜索服务' , count:'排查k8s问题分析，正在发送给业务人员', icon:'fa-solid fa-feather-pointed' , link:'http://alinesno-infra-base-search-ui.beta.base.infra.linesno.com'} ,
      {name:'权限配置服务' , count:'生成自动化运营平台，正在集成业务服务', icon:'fas fa-train' , link:"http://alinesno-infra-base-authority-ui.beta.base.infra.linesno.com"} ,
      {name:'异构系统抽取服务' , count:'编码结构的失败服务，正在进一步编码中', icon:'fas fa-pencil-ruler' , link: "http://alinesno-infra-data-pipeline-ui.beta.base.infra.linesno.com"} ,
]) ;

const acpProjectBuild = [
  {
    id: '1',
    icon: 'fa-solid fa-signature',
    title: '创建AIP智能体角色',
    desc: '通过模板快速定义智能体的角色与权限',
    link: '/dashboard/build/business'
  },
  {
    id: '2',
    icon: 'fas fa-file-signature',
    title: '创建业务服务能力',
    desc: '构建和优化业务服务流程，集成智能体能力',
    link: '/dashboard/build/data'
  },
  {
    id: '3',
    icon: 'fas fa-laptop-code',
    title: '创建智能体数据资产',
    desc: '数据管理和治理，管理智能体数据资产',
    link: '/dashboard/build/operation'
  },
];

const screenJsonList = [];

function getProductList() {
    getProduct().then(response => {
        console.log('response = ' + response);
        productList.value = response.data ;
    });
};

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
      margin-right: 8px;
      padding: 10px 15px;
      width: calc(50% - 10px);
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
