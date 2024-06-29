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

      <!-- <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">Agent自动化团队</div>
          </div>
          <div class="panel-body" style="padding:5px;background-color: #fff;">
            <el-empty v-if="tableData.length == 0" :image-size="100" description="这可能是因为您没有运行 Trusted Advisor 检查，或者您没有 Business 或 Enterprise Support 计划。" />

            <el-table :data="tableData" stripe style="width: 100%">
              <el-table-column label="图标" align="center" width="150px" prop="icon">
                  <template #default="scope">
                    <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + (scope.$index +1) + '.png'" style="width:30px;height:30px;border-radius: 50%" />
                    运行排查专家
                  </template>
              </el-table-column>
              <el-table-column prop="projectName" label="应用名称" width="100" :show-overflow-tooltip="true" />
              <el-table-column prop="content" label="优化建议" :show-overflow-tooltip="true" />
              <el-table-column prop="level" align="center" label="建议级别" width="80">
                <template #default="scope">
                  <div class="role-icon">
                    <span v-if="scope.row.level == 9">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-bomb" style="font-size: 15px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 1">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-bomb" style="font-size: 15px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 2">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-bomb" style="font-size: 15px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 3">
                      <el-button type="warning" bg link>
                        <i class="fa-solid fa-triangle-exclamation" style="font-size: 15px"></i>
                      </el-button>
                    </span>
                  </div>
              </template>
              </el-table-column>
            </el-table>

          </div>
        </div>
      </el-col> -->

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

const screenJsonList = [
  {
    "addTime": "2023-05-02 05:14:31",
    "departmentId": null,
    "lastUpdateOperatorId": null,
    "usage": 7,
    icon: 'fa-solid fa-truck-fast' ,
    "remark": "技术研发组件服务",
    "updateTime": null,
    "title": "技术研发组件服务",
    "productItem": [
      {
        "shortName": null
      },
      {
        "shortName": null
      },
      {
        "shortName": null
      },
      {
        "shortName": null
      },
      {
        "shortName": null
      },
      {
        "shortName": null
      },
      {
        "shortName": null
      }
    ],
    "hasDelete": 0,
    "hasStatus": 0,
    "total": 7,
    "screenIndex": 10,
    "deleteTime": null,
    "deleteManager": null,
    "tenantId": "0",
    "fieldProp": "integration",
    "id": "e7eb9a5acf75b02b80b1bb0ec1dbd71a",
    "applicationId": null,
    "operatorId": "784553886277959680",
    "applicationName": null,
    "fieldId": null,
    "status": "1"
  },
  {
    "addTime": "2023-05-02 05:16:34",
    "departmentId": null,
    "lastUpdateOperatorId": null,
    "usage": 2,
    icon: 'fa-solid fa-file-shield' ,
    "remark": "一体化安全感知套件",
    "updateTime": null,
    "title": "一体化安全感知套件",
    "productItem": [
      {
        "addTime": "2022-12-21 14:53:10",
        "departmentId": null,
        "sortNumber": 11,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-databus.beta.linesno.com",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "a18f33c24aaf645d80ab4b96ff4ba5ce",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "787440555398266880",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "normal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "数据采集总线",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      },
      {
        "addTime": "2023-03-12 06:40:45",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-security.beta.linesno.com/",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "a23cbf1efa2dc6df7ac5820102dbae5f",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "332e19911ee96f8a9241471b6954ec7f",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "normal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "一体化安全触感服务",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      }
    ],
    "hasDelete": 0,
    "hasStatus": 0,
    "total": 2,
    "screenIndex": 1,
    "deleteTime": null,
    "deleteManager": null,
    "tenantId": "0",
    "fieldProp": "integration",
    "id": "214f92e4267f5dca79b129351f884f3f",
    "applicationId": null,
    "operatorId": "784553886277959680",
    "applicationName": null,
    "fieldId": null,
    "status": "1"
  },
  {
    "addTime": "2023-05-02 05:15:53",
    "departmentId": null,
    "lastUpdateOperatorId": null,
    "usage": 3,
    icon: 'fa-solid fa-helmet-un' ,
    "remark": "自动运维治理套件",
    "updateTime": null,
    "title": "自动运维治理套件",
    "productItem": [
      {
        "addTime": "2023-03-05 02:59:31",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-configuration.beta.linesno.com/",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "b8bb226de8de62decb1e293283fc6c62",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "793938687002935296",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "normal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "配置管理服务",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      },
      {
        
        "linkPath": "http://alinesno-watcher.beta.linesno.com",
        
        "name": "审计日志服务",
        "hasRecommend": 1,
        "applicationId": "0",
        "shortName": null
      },
      {
        "addTime": "2022-03-23 12:51:48",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-operation-pipeline.beta.linesno.com",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "801e85de62ca5b9f8f76b5e31987730e",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "793938687002935296",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "normal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "自动化操作服务",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      }
    ],
    "hasDelete": 0,
    "hasStatus": 0,
    "total": 3,
    "screenIndex": 1,
    "deleteTime": null,
    "deleteManager": null,
    "tenantId": "0",
    "fieldProp": "integration",
    "id": "5e33fa098910e77c8334d1d8c668dd69",
    "applicationId": null,
    "operatorId": "784553886277959680",
    "applicationName": null,
    "fieldId": null,
    "status": "1"
  },
  {
    "addTime": "2023-05-02 05:15:31",
    "departmentId": null,
    "lastUpdateOperatorId": null,
    "usage": 1,
    icon: 'fa-solid fa-ship' ,
    "remark": "容器云运营套件",
    "updateTime": null,
    "title": "容器云运营套件",
    "productItem": [
      {
        "addTime": "2023-04-01 16:25:17",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-kube-platform.beta.linesno.com",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "c6fca12e348cccf97495b3aea33adcef",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "332e19911ee96f8a9241471b6954ec7f",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "internal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "容器云管理平台",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      }
    ],
    "hasDelete": 0,
    "hasStatus": 0,
    "total": 1,
    "screenIndex": 1,
    "deleteTime": null,
    "deleteManager": null,
    "tenantId": "0",
    "fieldProp": "integration",
    "id": "8beaa35a097bf2cd7bdc9714e41336e2",
    "applicationId": null,
    "operatorId": "784553886277959680",
    "applicationName": null,
    "fieldId": null,
    "status": "1"
  },
  {
    "addTime": "2023-05-02 05:16:17",
    "departmentId": null,
    "lastUpdateOperatorId": null,
    "usage": 2,
    icon: 'fa-solid fa-feather-pointed' ,
    "remark": "DevOps自动化套件",
    "updateTime": null,
    "title": "DevOps自动化套件",
    "productItem": [
      {
        "addTime": "2022-03-23 12:51:48",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-operation-pipeline.beta.linesno.com",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "801e85de62ca5b9f8f76b5e31987730e",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "793938687002935296",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "normal",
        "identityStatus": null,
        "tenantId": "0",
        "name": "自动化操作服务",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      },
      {
        "addTime": "2023-05-01 22:00:45",
        "departmentId": null,
        "sortNumber": 1,
        "hasStatus": 0,
        "productBrief": null,
        "linkPath": "http://alinesno-jenkins.beta.linesno.com/",
        "deleteManager": null,
        "itemStatus": null,
        "fieldProp": null,
        "id": "6a3512430d3b610ffa67263ee365cc13",
        "viewCount": null,
        "operatorId": "784553886277959680",
        "applicationName": null,
        "fieldId": null,
        "lastUpdateOperatorId": "784553886277959680",
        "banner": null,
        "updateTime": null,
        "productDescribe": null,
        "productTypeId": "793938687002935296",
        "hasInner": 0,
        "hasDelete": 0,
        "deleteTime": null,
        "subName": null,
        "prodStatus": "company",
        "identityStatus": null,
        "tenantId": "0",
        "name": "持续集成服务",
        "hasRecommend": 0,
        "applicationId": null,
        "shortName": null
      }
    ],
    "hasDelete": 0,
    "hasStatus": 0,
    "total": 2,
    "screenIndex": 1,
    "deleteTime": null,
    "deleteManager": null,
    "tenantId": "0",
    "fieldProp": "integration",
    "id": "ea82737f643d66b4b702cfd098a82d62",
    "applicationId": null,
    "operatorId": "784553886277959680",
    "applicationName": null,
    "fieldId": null,
    "status": "1"
  }
];

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
