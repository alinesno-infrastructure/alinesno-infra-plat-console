<template>
  <div id="header" class="homeHeaderBox">
    <div class="toolbar">
      <div class="tabs">
        <div class="react-grid-layout">

          <div class="react-grid-item static cssTransforms react-resizable-hide react-resizable"
            v-for="(item, index) in menuList" :key="index" :style="'transform: translate(' + (150 * index) + 'px, 0px);'">

            <button class="next-btn next-large next-btn-normal grid-tab" @click="jumpTo(item, index)" :class="addSelectClass(index)">
              <span class="title">
                <i :class="item.icon"></i> {{ item.name }}
              </span>
            </button>
          </div>

        </div>
      </div>

      <div class="toolkit">

        <div class="acp-sign-day-box">
          <i class="fa-solid fa-computer"></i> 
          你已经签到 <span class="sign-number">{{ signDay }}</span> 天
        </div>

        <button class="next-btn next-medium next-btn-normal" @click="dialogVisible = true">
          <i class="fa-solid fa-file-pen"></i> <span class="">视图配置</span>
        </button>

      </div>

    </div>

    <el-dialog v-model="dialogVisible" title="视图配置" width="500" >

      <!-- 实现 viewList 上下排序的配置 -->
       <draggable v-model="menuList" :options="{ group: 'items', animation: 200 }" @end="onSortEnd">
        <template #item="{ element, index }">
          <el-card style="margin-bottom:5px;cursor: pointer;" shadow="hover" class="item-card">
            <i :class="element.icon"></i>&nbsp;
            <span v-if="!element.editing" @click="editName(index)">
              {{ element.name }}
            </span>
            <el-input style="width: 80%;" size="large" v-else v-model="element.name" ref="inputRef" @blur="saveName(index)" @keyup.enter="saveName(index)" />
          </el-card>
        </template>
      </draggable>

      <div style="margin-top: 10px;">双击可自定义名称.</div>

      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleConfirmViewList()">
            确认 
          </el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup>

import {
  getViewList ,
  daySignIn , 
  updateViewList
} from '@/api/console/dashboard';
import { ref } from 'vue';

import draggable from "vuedraggable";

const { proxy } = getCurrentInstance();
const router = useRouter();
const route = useRoute() //获取到值

const props = defineProps({
    currentTab: {
        type: String,
        required: true
    }
})

let type = ref(-1);

const dialogVisible = ref(false)
const signDay = ref(0);

const menuList = ref([]);

/** 选择类 */
function addSelectClass(t) {
  console.log('props.currentTab= ' + props.currentTab) ; 
  console.log('t = ' + t) ; 

  if(props.currentTab == null){
    props.currentTab = 0 ; 
  }


  return props.currentTab == t? 'select' : '';
};

/** 获取视图列表 */
function handleViewList() {
  getViewList().then(res => {
    console.log(res);
    menuList.value = res.data;
  });
}

function editName(index) {
  const item = menuList.value[index];
  if (!item.editing) {
    item.editing = true;
    // 确保输入框获取焦点
    nextTick(() => {
      $refs.inputRef[index].focus();
    });
  }
}

function saveName(index) {
  const item = menuList.value[index];
  item.editing = false;
}

function onSortEnd(event) {
  // 在这里可以处理排序结束后的逻辑
}


/** 确认视图配置 */
function handleConfirmViewList(){
  dialogVisible.value = false ;
  updateViewList(menuList.value).then(res => {
    console.log(res);
    proxy.$modal.msgSuccess("修改成功");
  });
}

/** 路径跳转 */
function jumpTo(item, index) {
  if (item.status == 1) {
    this.$message({
      type: "warning",
      message: "模块正在建设中.",
    });
    return;
  }
  router.push({ name : item.path, params: { type: index } });
}

/** 签到 */
function handleDaySignIn(){
  daySignIn().then(res => {
    signDay.value = res.data ;
  });
}

handleViewList() ;
handleDaySignIn() ;

</script>