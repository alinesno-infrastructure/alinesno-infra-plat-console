<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="13">
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

      <el-col :span="11">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 应用服务概览</div>
          </div>
          <div class="data-card">
            <ul class="count-list summary-panel">
              <li class="count-data bg-red" v-for="(item , index) in runCountArr" :key="index">
                <i :class="item.icon"></i>
                <span class="label-tip">
                  <a target="_blank" :href="item.link">
                    {{ item.name }}
                  </a>
                </span>
                <span class="label">{{ item.count }}</span>
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

const runCountArr = ref([
      {name:'监控服务器统计' , count:812 , icon:'fas fa-server' , link:'https://192.168.1.170:3000/d/aka/node-exporter-dashboard?orgId=1&kiosk=tv'} ,
      {name:'服务运行健康报告' , count:292 , icon:'fas fa-shipping-fast' , link:'https://192.168.1.161:30090/promethues/alerts'} ,
      {name:'运行监控日志审计' , count:322 , icon:'fas fa-pencil-ruler' , link:"https://192.168.1.55:5601/app/discover#/view/ae40de50-d919-11ed-a141-51d122929855?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-1y,to:now))&_a=(columns:!(message,'@timestamp',service,host),filters:!(),index:'32258160-bfb4-11ec-8af6-65a485b4d749',interval:auto,query:(language:kuery,query:''),sort:!(!('@timestamp',desc)))"} ,
      {name:'监控服务器统计' , count:812 , icon:'fas fa-server' , link:'https://192.168.1.170:3000/d/aka/node-exporter-dashboard?orgId=1&kiosk=tv'} ,
      {name:'自动化任务管理' , count:932 , icon:'fas fa-train' , link:"https://192.168.1.161:8000/view/%E8%87%AA%E5%8A%A8%E5%8C%96%E8%BF%90%E7%BB%B4%E4%BB%BB%E5%8A%A1/"} ,
      {name:'自动化任务脚本' , count:132 , icon:'fas fa-server' , link: "https://192.168.1.79/-/ide/project/capinfo-platform-jm/capinfo-platform-operation-manager/edit/jm-gjj/-/"} ,
      {name:'中间件运行统计' , count:312 , icon:'fas fa-pencil-ruler'} ,
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
      width: calc(33% - 18px);
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
