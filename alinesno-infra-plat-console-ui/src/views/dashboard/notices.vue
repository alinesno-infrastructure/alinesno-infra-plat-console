<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">探索AIP使用</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？ </div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP入门</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？ </div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
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

      <!-- 协助列表-->
      <!-- 
      <el-col :span="7">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">新最公告</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">在AIP使用k8s快速搭建基设平台服务系统</div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">在校园数据开发项目上使用AIP集成的实战经验</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">某集团在使用AIP服务构建和集成的示例</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
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
      -->
      
      <el-col class="panel-col" :span="9">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-tag"></i> 推荐智能体</div>
          </div>
          <div class="panel-body" style="padding:0px;">
            <el-empty v-if="tableData.length == 0" :image-size="100" description="这可能是因为您没有运行 Trusted Advisor 检查，或者您没有 Business 或 Enterprise Support 计划。" />

            <el-table :data="tableData" stripe style="width: 100%">
              <!-- <el-table-column type="index" width="55" label="序号" align="center" /> -->
              <el-table-column label="角色" align="left" width="200px" prop="icon" :show-overflow-tooltip="true">
                  <template #default="scope">
                    <img :src="'http://data.linesno.com/icons/header/' + (scope.row.link+1) + '.jpg'" style="width:26px;height:26px;float:left; border-radius: 8px" />
                    <div style="float: left;margin-top: 3px;margin-left: 10px;width: calc(100% - 50px);">
                      {{ scope.row.name }}
                    </div>
                  </template>
              </el-table-column>
              <el-table-column prop="count" label="角色描述" :show-overflow-tooltip="true" />
              <el-table-column prop="level" align="center" label="操作" width="100">
                <template #default="scope">
                  <div class="role-icon">
                    <el-button type="primary" bg link @click="handleRoleChat(scope.row)">
                      <i class="fa-solid fa-feather-pointed" style="font-size: 15px;margin-right:5px"></i> 进入 
                    </el-button>
                  </div>
              </template>
              </el-table-column>
            </el-table>

          </div>
        </div>
      </el-col>

      <el-col class="panel-col" :span="10">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-truck-fast"></i> 推荐频道</div>
          </div>
          <div class="panel-body" style="padding:0px;">
            <el-empty v-if="tableData.length == 0" :image-size="100" description="这可能是因为您没有运行 Trusted Advisor 检查，或者您没有 Business 或 Enterprise Support 计划。" />

            <el-table :data="tableData" stripe style="width: 100%">
              <!-- <el-table-column type="index" width="55" label="序号" align="center" /> -->
              <el-table-column label="频道" align="left" width="200px" prop="icon" :show-overflow-tooltip="true">
                  <template #default="scope">
                    <img :src="'http://data.linesno.com/icons/header/' + (scope.row.link+6) + '.jpg'" style="width:26px;height:26px;float:left; border-radius: 8px" />
                    <div style="float: left;margin-top: 3px;margin-left: 10px;width: calc(100% - 50px);">
                      {{ scope.row.name }}
                    </div>
                  </template>
              </el-table-column>
              <el-table-column prop="count" label="频道描述" :show-overflow-tooltip="true" />
              <el-table-column prop="level" align="center" label="操作" width="100">
                <template #default="scope">
                  <div class="role-icon">
                    <el-button type="primary" @click="handleChannelChat(scope.row)" bg link>
                      <i class="fa-solid fa-feather-pointed" style="font-size: 15px;margin-right:5px"></i> 进入 
                    </el-button>
                  </div>
              </template>
              </el-table-column>
            </el-table>

          </div>
        </div>
      </el-col>

    </el-row>

    <el-dialog v-model="dialogVisible" width="860" :before-close="handleClose">
        <iframe :src="roleChatUri" class="role-chat-iframe"></iframe>
    </el-dialog>

  </div>
</template>

<script setup>

import {defineEmits} from 'vue'
const emit = defineEmits(['handleChannelChat'])

const chatTitle = ref("")
const dialogVisible = ref(false)
const roleChatUri = ref("")

const tableData = [
  {name:'需求文档分析频道' , count:'正在分析数据工程结构，分析需求文档中', icon:'fa-solid fa-file-shield' , link:1} ,
  {name:'项目功能细化分析频道' , count:'数据功能细化分析中，异常问题收集', icon:'fas fa-shipping-fast' , link:2} ,
  {name:'K8S问题排查频道' , count:'排查k8s问题分析，正在发送给业务人员，正在发送给业务人员', icon:'fa-solid fa-feather-pointed' , link:3} ,
  {name:'Ansible自动化工程师' , count:'生成自动化运营平台，正在集成业务服务', icon:'fas fa-train' , link:4} ,
  {name:'产品客户服务频道' , count:'客户服务专家列表结构，正在跟客户沟通中', icon:'fas fa-server' , link: 5} ,
  {name:'开发编码规范频道' , count:'编码结构的失败服务，正在进一步编码中', icon:'fas fa-pencil-ruler' , link: 6} ,
]

/** 与单个频道发信息 */
function handleChannelChat(item){
  emit('handleChannelChat' , item)
}

/** 与单个Role发信息 */
function handleRoleChat(item){
    roleChatUri.value = "http://alinesno-infra-smart-im-ui.beta.smart.infra.linesno.com/agentChat?roleId=1808349647059738625"
    chatTitle.value = item.roleName ;
    dialogVisible.value = true ;
}

</script>
