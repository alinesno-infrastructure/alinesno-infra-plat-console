<template>
    <div class="acp-dashboard" style="max-width:1240px;width:80%;margin:auto;margin-bottom: 80px; padding: 0px 10px !important;background: #fff;">

      <div class="flex justify-space-between mb-4 flex-wrap gap-4" style="padding:10px;">
        <!-- <el-button v-for="button in buttons" icon="Search" :key="button.text" :type="button.type" text bg>{{ button.text }}</el-button> -->
      </div>

      <div class="channel-panel-header">
          推荐频道 
          <span style="font-size: 13px;color: #a5a5a5;">常用和好评推荐频道列表</span>
      </div>
      <div class="channel-panel-body" v-loading="loading">
        <el-row>
          <el-col class="channel-item-box" :span="3" v-for="(item,index) in recomondChatChannel" :key="item">
            <div class="img-bannel">
              <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + (1 + (index+1) * 1)+ '.png'" />
            </div>
            <div class="channel-info-box">
              <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + (10 + (index+1) * 1)+ '.png'" style="width: 30px;height: 30px;border-radius: 50%;margin-left: -40px;position: absolute;margin-top: 5px;" />
              <div class="title" style="cursor: pointer;" @click="enterChannel">{{ item.name }}</div>
              <div class="title-desc">{{ item.description }}</div>
            </div>
          </el-col>
        </el-row> 
      </div>
      <div class="channel-panel-header">
          频道市场
          <span style="font-size: 13px;color: #a5a5a5;">这里包含所有需要运营的Agent服务列表</span>
      </div>
      <div class="channel-panel-body" v-loading="loading">
        <el-row>
          <el-col class="channel-item-box" :span="3" v-for="(item,index) in publicChatChannel" :key="item">
            <div class="img-bannel">
              <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + (11 + (index+1) * 1)+ '.png'" />
            </div>
            <div class="channel-info-box">
              <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + (10 + (index+1) * 1)+ '.png'" style="width: 25px;height: 25px;border-radius: 50%;margin-left: -30px;position: absolute;margin-top: 5px;" />
              <div class="title" style="cursor: pointer;" @click="enterChannel">{{ item.name }}</div>
              <div class="title-desc">{{ item.description }}</div>
            </div>
          </el-col>
        </el-row> 
      </div>
    </div>
</template>

<script setup>

import {
  allMyChannel , 
} from '@/api/base/im/channel'

const loading = ref(false)
const router = useRouter();

const recomondChatChannel = ref([]);
const publicChatChannel = ref([]);

const buttons = ref([
  { type: '', text: '最新' },
  { type: 'primary', text: '需求讨论' },
  { type: 'success', text: '架构设计' },
  { type: 'success', text: '架构设计' },
  { type: 'warning', text: '市场运维' },
  { type: 'danger', text: '项目规范' },
  { type: 'info', text: '市场推广' },
  { type: 'warning', text: '市场运维' },
  { type: 'danger', text: '项目规范' },
])

/** 查询所所有我在参与的频道 */
function handleAllMyChannel() {
  loading.value = true ; 
  allMyChannel().then(response => {
    recomondChatChannel.value = response.recommend ;
    publicChatChannel.value = response.public;
    loading.value = false; 
  })
}

/** 进入频道 */
function enterChannel(){
  router.push({ path: "/chat" });
}

handleAllMyChannel();

</script>

<style lang="scss" scoped>

.channel-panel-header{
  padding: 10px;
}

.channel-panel-body{

  .channel-info-box {
    margin: 10px;
    line-height: 1.5rem;
    padding-left: 30px;
  }

  .channel-item-box{
    margin-bottom: 30px;
    margin-top: 10px;
    margin-right: 10px;
  }

  .title {
    font-size: 14px;
    font-weight: bold;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
  }

  .title-desc {
    font-size: 13px;
    color: #a5a5a5;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
  }

  .img-bannel {
    margin: 10px;
    height: 90px;
    overflow: hidden;
    border-radius: 5px;

    img {
      width:100%;
      border-radius: 5px;
    }
  }
}
</style>