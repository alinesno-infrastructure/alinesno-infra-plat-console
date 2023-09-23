<template>
  <div id="header" class="homeHeaderBox">
    <div class="toolbar">
      <div class="tabs">
        <div class="react-grid-layout">

          <div class="react-grid-item static cssTransforms react-resizable-hide react-resizable"
            v-for="(item, index) in menuList" :key="index" :style="'transform: translate(' + (180 * index) + 'px, 0px);'">

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
  </div>
</template>

<script setup>

const router = useRouter();
const route = useRoute() //获取到值

const props = defineProps({
    currentTab: {
        type: String,
        required: true
    }
})

let type = ref(-1);

const dialogVisible = false;
const menuList = [
  { status: 0, icon: 'fas fa-chalkboard fa-fw', name: '概览', type: '0', path: '/index', desc: '统一的中台门户服务管理' },
  { status: 0, icon: 'fa-solid fa-pen-ruler', name: '业务服务', type: '1', path: '/dashboard/businessWorkspace', desc: '公共的业务建设组件服务' },
  { status: 0, icon: 'fa-solid fa-rocket', name: '数据治理', type: '2', path: '/dashboard/dataWorkspace', desc: '数据治理开发治理' },
  { status: 0, icon: 'fas fa-shipping-fast', name: '运营监控', type: '3', path: '/dashboard/operationWorkspace', desc: '整体服务的运营监控' },
  { status: 0, icon: 'fa-solid fa-sailboat', name: '智能服务', type: '4', path: '/dashboard/smartWorkspace', desc: '智能化专家服务' },
  { status: 0, icon: 'fas fa-feather fa-fw', name: '自定义视图', type: '5', path: '/dashboard/customWorkspace', desc: '个性化服务视图配置' },
];

/** 选择类 */
function addSelectClass(t) {
  console.log('props.currentTab= ' + props.currentTab) ; 
  console.log('t = ' + t) ; 

  if(props.currentTab == null){
    props.currentTab = 0 ; 
  }


  return props.currentTab == t? 'select' : '';
};

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

</script>