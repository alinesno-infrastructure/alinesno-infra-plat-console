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
                  <div class="app-status-icon">
                    <i class="fa-solid fa-laptop-code"></i>
                  </div>
                  <div class="app-status-text">
                    <div class="app-status-text-desc">展示当前运行服务概览和详情，您可以查看了解目前集成的基础能力和平台能力。 演示环境为最新功能预览版</div>
                  </div>
                </div>
              </el-col>

              <el-col :span="6">
                <div class="box">
                  <div class="circle-wave">
                    <div class="circle-wave-bg"></div>
                    <div class="circle-wave-inner" style="color: $sky-warning-color;">
                      <div class="circle-wave-value"> 100 <div class="unit">分</div>
                      </div>
                      <div class="circle-wave-desc">服务正常</div>
                    </div>
                  </div>
                </div>
              </el-col>

              <el-col :span="18">
                <div class="acp-app-list">
                  <ul>
                    <li class="app-items" v-for="item in screenJsonList" :key="item">
                      <div class="app-icon">
                        <!-- <img :src="item.icon" /> -->
                        <i :class="item.icon"></i>
                      </div>
                      <div class="app-info">
                        <div class="app-item-title">
                          {{ item.title }}
                          (<span style="font-weight: 600;font-size:15px">{{ item.productItem.length}}</span>/<span style="font-size:12px">{{ item.productItem.length }}</span>)
                        </div>
                        <div class="app-item desc">{{ item.remark }}</div>
                      </div>
                    </li>
                  </ul>
                </div>
              </el-col>
            </el-row>


          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-nurse"></i> AIP健康报告</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">未解决问题</div>
                  <div class="item-health-count">41</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">预定更改</div>
                  <div class="item-health-count">32</div>
                  <div class="item-health-outtime">即将到来和过去 7 天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">运行通知</div>
                  <div class="item-health-count">32</div>
                  <div class="item-health-outtime">过去14天</div>
                </div>
              </li>
              <li>
                <div class="item-health-box">
                  <div class="item-health-title">其它通知</div>
                  <div class="item-health-count">12</div>
                  <div class="item-health-outtime">过去7天</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <!-- 快捷方式 -->
      <el-col :span="6">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-feather"></i> 快捷接入平台能力</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li v-for="item in acpProjectBuild" :key="item.id">
                <div class="item-icon">
                  <img :src="item.icon" alt="" />
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
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script setup>

import { getProduct } from "@/api/console/product";

const acpProjectBuild = [
  {id:'1' , icon:'https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png' , title:'创建业务服务组件' , desc:'集成可视化监控和自动集成部署服务' , link:'/dashboard/build/business'} ,
  {id:'2' , icon:'https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png' , title:'集成数据平台能力' , desc:'集成数据治理套件集成数据分析输出' , link:'/dashboard/build/data'} ,
  {id:'3' , icon:'https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png' , title:'集成自动运维能力' , desc:'业务运维管理和自动化运维管理能力' , link:'/dashboard/build/operation'} ,
] ;

const screenJsonList = [];

function getProductList() {
    getProduct().then(response => {
        console.log('response = ' + response);
        productList.value = response.data ;
    });
};

</script>
