<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="11">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 服务运行状态
            </div>
          </div>
          <div class="panel-body">
            <el-row>
              <el-col :span="24">
                <div class="panel-app-status">
                  <div class="app-status-icon">
                    <i class="fa-solid fa-laptop-code"></i>
                  </div>
                  <div class="app-status-text">
                    <div class="app-status-text-desc">展示当前运行服务概览和详情，您可以查看了解目前集成的基础能力和平台能力</div>
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
                        <i :class="item.icon" />
                      </div>
                      <div class="app-info">
                        <div class="app-item-title">
                          {{ item.name }}
                          (<span style="font-weight: 600;font-size:15px">{{ item.productItem.length}}</span>/<span style="font-size:12px">{{ item.productItem.length }}</span>)
                        </div>
                        <div class="app-item desc">{{ truncateString(item.typeDescribe,15) }}</div>
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

      <el-col :span="13">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> Agent运营团队 </div>
          </div>
          <div class="data-card">
            <ul class="count-list summary-panel">
              <li class="count-data bg-red" v-for="(item , index) in runCountArr" :key="index">
                <i :class="item.icon"></i>
                <span class="label-tip">
                  <a target="_blank" :href="item.link">
                    <img :src="'http://data.linesno.com/icons/header/' + (index +1) + '.jpg'" style="width:40px;height:40px;float:left; border-radius: 8px" />
                    <div style="float: left;margin-top: 3px;margin-left: 10px;width: calc(100% - 50px);">
                      {{ item.name }} (<span style="font-weight: 600;font-size:15px">8</span>/<span style="font-size:12px">{{ index }}</span>)
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
</template>

<script setup>

import { getProduct } from "@/api/console/product";
import RightRunStatus from './rightRunStatus.vue';

const acpProjectBuild = [
  {id:'1' , icon:'https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png' , title:'创建业务服务组件' , desc:'集成可视化监控和自动集成部署服务' , link:'/dashboard/build/business'} ,
  {id:'2' , icon:'https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png' , title:'集成数据平台能力' , desc:'集成数据治理套件集成数据分析输出' , link:'/dashboard/build/data'} ,
] ;

const tableData = [
  { inde2x: 1, busType: '在线支付', projectName: '支付宝', content: '优化支付流程，提升用户体验，包括简化支付步骤，增加支付方式选择，提高支付成功率', level: '9' },
  { inde2x: 2, busType: '电商平台', projectName: '淘宝', content: '增加推荐算法，提高用户购买转化率，包括个性化推荐，热门商品推荐，购买引导等方面', level: '2' },
  { inde2x: 5, busType: '出行服务', projectName: '滴滴打车', content: '提高司机端APP稳定性，减少崩溃情况，改善司机使用体验，优化内存管理和异常处理机制', level: '9' },
  { inde2x: 6, busType: '餐饮外卖', projectName: '美团外卖', content: '优化订单配送算法，减少配送时间，提高用户满意度，优化骑手调度和路线规划', level: '2' },
]

const runCountArr = ref([
      {name:'需求文档分析专家' , count:'正在分析数据工程结构，分析需求文档中', icon:'fa-solid fa-file-shield' , link:'https://192.168.1.170:3000/d/aka/node-exporter-dashboard?orgId=1&kiosk=tv'} ,
      {name:'项目功能细化分析专家' , count:'数据功能细化分析中，异常问题收集', icon:'fas fa-shipping-fast' , link:'https://192.168.1.161:30090/promethues/alerts'} ,
      {name:'K8S问题排查专家' , count:'排查k8s问题分析，正在发送给业务人员', icon:'fa-solid fa-feather-pointed' , link:'https://192.168.1.170:3000/d/aka/node-exporter-dashboard?orgId=1&kiosk=tv'} ,
      {name:'Ansible自动化工程师' , count:'生成自动化运营平台，正在集成业务服务', icon:'fas fa-train' , link:"https://192.168.1.161:8000/view/%E8%87%AA%E5%8A%A8%E5%8C%96%E8%BF%90%E7%BB%B4%E4%BB%BB%E5%8A%A1/"} ,
      {name:'产品客户服务专家' , count:'客户服务专家列表结构，正在跟客户沟通中', icon:'fas fa-server' , link: "https://192.168.1.79/-/ide/project/capinfo-platform-jm/capinfo-platform-operation-manager/edit/jm-gjj/-/"} ,
      {name:'开发编码规范专家' , count:'编码结构的失败服务，正在进一步编码中', icon:'fas fa-pencil-ruler'} ,
]) ;

const screenJsonList = ref([]);

function handleProductList() {
    getProduct().then(response => {
        console.log('response = ' + response);
        screenJsonList.value = response.data ;
    });
};

handleProductList();

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
      width: calc(50% - 18px);
      text-decoration: none;
      overflow: hidden;
      border-width: 0px;
      border-style: solid;
      border-radius: 2px;
      transition: all 0.1s linear;
      height: 70px;
      margin-bottom: 5px;
      margin-top: 5px;
      margin-left: 10px;

      i{
        float: right;
        position: absolute;
        right: 10px;
        font-size: 30px;
        opacity: .4;
        top: 15px;
        color: #005bd5;
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
        // display: block;
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
