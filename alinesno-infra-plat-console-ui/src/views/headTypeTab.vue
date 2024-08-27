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
          你已经签到 <span class="sign-number">402</span> 天
        </div>

        <button class="next-btn next-medium next-btn-normal" @click="dialogVisible = true">
          <i class="fa-solid fa-file-pen"></i> <span class="">视图配置</span>
        </button>

      </div>

    </div>

    <el-dialog v-model="dialogVisible" title="视图配置" width="500" :before-close="handleClose">

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

      <span>双击可自定义名称.</span>

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
  updateViewList
} from '@/api/console/dashboard';

import draggable from "vuedraggable";

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

const menuList = ref([
  // { status: 0, icon: 'fa-brands fa-slack', name: '仪盘表', type: '0', path: '/index', desc: '运营自动化门户' },
  // { status: 0, icon: 'fa-solid fa-pen-ruler', name: '研发服务', type: '1', path: '/dashboard/businessWorkspace', desc: '公共的业务建设组件服务' },
  // { status: 0, icon: 'fa-solid fa-rocket', name: '数据治理', type: '2', path: '/dashboard/dataWorkspace', desc: '数据治理开发治理' },
  // { status: 0, icon: 'fa-solid fa-sailboat', name: '智能服务', type: '3', path: '/dashboard/smartWorkspace', desc: '智能化专家服务' },
  // { status: 0, icon: 'fas fa-shipping-fast', name: '运维资产', type: '4', path: '/dashboard/operationWorkspace', desc: '整体服务的运营监控' },
  // { status: 0, icon: 'fas fa-feather fa-fw', name: '业务服务', type: '5', path: '/dashboard/customWorkspace', desc: '个性化服务视图配置' },
]);

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

handleViewList() ;

</script>