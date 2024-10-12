<template>
  <el-scrollbar height="100vh">

  <div class="container-main tpl-app" style="padding-bottom:50px;background-color: #fff;">
      <div class="tpl-app app-main-content" v-loading="fullscreenLoading" style="max-width: 1240px;">

            <section class="section" v-for="(type, index) in productList" :key="index">
                <h2 class="section-title">
                    <i :class="type.banner" /> {{ type.name }}
                </h2>
                <br/>
                <div class="section-body">
                    <div class="app-item border-bottom export-item" v-for="(item, i) in type.agents" :key="i">
                        <div class="app-item__icon wk wk-icon-user">
                          <img :src="imagePathByPath(item.roleAvatar)" style="width:45px;height:45px;border-radius: 5px"/>
                        </div>
                        <div class="content">
                            <h3 class="app-item__title" style="margin-top:5px;margin-bottom:5px;">
                                {{ item.roleName }}
                                <a class="cf-service-nav-item-label" style="margin-left:10px;margin-right:10px;float:right" :title="item.name">
                                    <el-button type="primary" text bg @click="handleRoleChat(item)">
                                       <i class="fa-solid fa-location-arrow"></i>&nbsp; 咨询
                                    </el-button>
                                </a>
                            </h3>
                            <div class="app-item__desc">
                               {{ truncateString(item.responsibilities,20) }}
                            </div>
                        </div>

                    </div>
                </div>
            </section>
      </div>

      <el-dialog v-model="dialogVisible" width="860" :before-close="handleClose">
        <iframe :src="roleChatUri" class="role-chat-iframe"></iframe>
    </el-dialog>

  </div>
  </el-scrollbar>
</template>

<script setup name="ServiceList">

import { ElLoading } from 'element-plus'
import { getAllCatalog } from "@/api/base/im/robot";

const productList = ref([])
const chatTitle = ref("")
const dialogVisible = ref(false)
const roleChatUri = ref("")

/**  获取产品列表 */
function handleGetProductList() {
    const loading = ElLoading.service({
        lock: true,
        text: 'Loading',
    })
    getAllCatalog().then(response => {
            console.log('response = ' + response);
            productList.value = response.data ;
            loading.close() ;
    });
}

/** 显示图片 */
function imagePathByPath(roleAvatar){
  return import.meta.env.VITE_APP_BASE_API + "/v1/api/infra/base/im/chat/displayImage/" + roleAvatar ; 
}

/** 与单个Role发信息 */
function handleRoleChat(item){
    // roleChatUri.value = "/agentChat?roleId=" + item.id;
    roleChatUri.value = "http://alinesno-infra-smart-im-ui.beta.smart.infra.linesno.com/agentChat?roleId=1808349647059738625"
    chatTitle.value = item.roleName ;
    dialogVisible.value = true ;
}

/** 关闭对话框 */
function handleClose(){
    dialogVisible.value = false ;
}

handleGetProductList() ;

</script>

<style type="scss" scoped>
  .section {
      padding: 0px 20px 30px;

      &:last-child {
          border-bottom: 0 none;
      }

      .section-title {
          margin-left: -20px;
          font-size: 20px;
          margin-bottom: 0px;
      }

      .section-body {
          display: flex;
          align-items: center;
          justify-content: flex-start;
          flex-wrap: wrap;
          width: 100%;
          margin: 0 -2.5%;

          .app-item {
              width: calc(33% - 20px);
              padding: 10px 0;
              margin: 0 10px;

              .content {
                  -webkit-box-flex: 1;
                  -ms-flex: 1;
                  flex: 1;
                  overflow: hidden;
              }
          }

          .app-item__icon {
              display: flex;
              align-items: center;
              justify-content: center;
              margin-top: 0px;
              width: 48px;
              height: 48px;
              margin-right: 5px;
              font-size: 35px;
              background-color: #fff;
              border-radius: 4px;
          }

          .app-item__control {
              margin-left: 15px;

              .plain-btn {
                  padding: 8px 12px;
                  color: #3b5998;
                  font-size: 13px;
                  cursor: pointer;
                  border: 1px solid #3b5998;
                  border-radius: 4px;
              }
          }

          .app-item__title {
              margin-bottom: 0px;
              font-size: 16px;
          }

          .app-item__desc {
              overflow: hidden;
              font-size: 13px;
              color: #6b778c;
              text-overflow: ellipsis;
              white-space: nowrap;
          }
      }
  }
  

  .tpl-app .section .section-body .app-item,
.tpl-app .section .section-body {
  display: flex;
  align-items: center;
  justify-content: flex-start;
}

.wk {
  font-family: wk !important;
  font-size: 16px;
  font-style: normal;
}

span.product-text-label {
  color: #3b5998;
  font-size: .7rem !important;
  border: 1px solid #3b5998;
  padding: 2px 5px;
  border-radius: 3px;
}

span.normal {
  color: #fe892c;
  border: 1px solid #fe892c;
}

span.design {
  color: #d5d5d5 !important;
  border: 1px solid #d5d5d5 !important;
}

.export-item {
    border-bottom: 0px;
    background: #fafafa;
    padding-bottom: 20px;
    border-radius: 5px !important;
    padding-left: 20px !important;
    margin-bottom: 10px !important;
}

.role-chat-iframe{
    width: 100%;
    height: calc(100vh - 200px);
    border: 0px;
}

</style>
