<template>
  <div class="Fill LandingPage currentMode">
    <div class="container-fluid">

      <div class="row-fluid status-and-charts">
        <div class="status-pane">
          <section id="statusPane" class="status-section">
            <div id="statusPaneContent">
              <!-- <div class="cluster-title-container">
                <h2 style="padding-bottom: 0px;margin-top: 0px;font-size: 18px;line-height: 30px;font-weight: 550;">
                  <span><i class="fas fa-server"></i> 数据治理套件</span>
                </h2>
              </div> -->
              <div class="panel-header">
                <div class="header-title"><i class="fas fa-server"></i> 数据治理套件</div>
              </div>
              <table class="DataTable noStripe status-table" id="servicesTable1" >
                <tbody>
                  <tr class="hosts">
                    <td class="host-status-and-name" align="center" width="60%">
                        服务列表
                    </td>
                    <td class="badges-column" align="center">
                      <span class="counter issues-label">问题列表</span>
                    </td>
                  </tr>

                  <tr class="service" v-for="(item, index) in apps" :key="index">
                    <td class="service-status-and-name">
                      <a class="display-status">
                        <span>
                          <i v-if="item.url === null" class="fas fa-stop-circle"></i>
                          <i v-else style="color:#3b5998" class="fa-solid fa-circle-play"></i>
                        </span>
                      </a>
                      <a class="showTooltip" :title="item.name" :href="item.url" target="_blank">
                        <i :class="item.icon"></i> <span> {{ item.name }} </span>
                      </a>
                    </td>
                    <td class="service-status-and-name" align="center">
                        <a class="health-issues-link link-with-counter showTooltip off" title=""
                          data-service-name="hbase">
                          <i class="fas fa-tools"></i>
                          <span class="counter issues-label" style="margin-left:10px;">30</span>
                        </a>
                    </td>
                  </tr>

                </tbody>
              </table>
              <div class="cluster-title-container">
                <h2>
                  <span data-cluster-id-for="0" title="Cloudera Management Service ">状态</span>
                </h2>
              </div>
              <table class="DataTable noStripe status-table" id="servicesTable0">
                <tbody>
                  <tr class="service">
                    <td class="host-status-and-name" width="60%">
                      <i class="fas fa-window-restore"></i> <span data-service-id-for="1" style="margin-left:10px">异常统计</span>
                    </td>
                    <td class="badges-column" align="center">
                        <i class="fa-solid fa-truck-fast"></i> <span class="counter issues-label" style="margin-left:10px">2</span>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </section>
        </div>
        <div class="charts-pane">

          <!-- 
          <h2 style="padding-left:0px;padding-bottom: 0px;">图表
            <i class="fas fa-chart-line"></i>
          </h2> 
          -->
          <div class="panel-header">
            <div class="header-title"><i class="fas fa-chart-line"></i> 图表</div>
          </div>
          <section class="chart-section">
            <div class="gridster ready">

              <run-status />

            </div>
          </section>
        </div>
      </div>
    </div>


  </div>
</template>

<script setup>

const apps = ref([
  { icon: 'fa-solid fa-charging-station', name: '主数据服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-brands fa-slack', name: '数据上报服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '数据集成服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fab fa-github-square', name: '数据编排计算服务', desc: 'With EC2 (2 分钟)' },
  { icon: 'fa-solid fa-tags', name: '实时计算服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '数据安全服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fas fa-paper-plane', name: '数据总线服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-hammer', name: '数据资产服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fas fa-feather fa-fw', name: '数据接口服务', desc: 'With Route 53 (3 分钟)' },
]);

</script>

<script>

import RunStatus from './runStatus.vue';

// import { getOperationList } from '@/api/cloud/dashboard'

export default {
  components: {
    RunStatus
  },
  data() {
    return {
      timeArr: [
        { text: '30分钟', value: '30' },
        { text: '1小时', value: '30' },
        { text: '2小时', value: '30' },
        { text: '6小时', value: '30' },
        { text: '12小时', value: '30' },
        { text: '24小时', value: '30' },
        { text: '7天', value: '30' },
        { text: '30天', value: '30' },
      ],
    }
  },
  mounted() {
    // this.getSideList();
  },
  methods: {
    getSideList(){
      getOperationList().then(res => {
        console.log("res = " + res) ;
        this.componentsArr = res.data ;
      })
    }
  }
}
</script>

<style lang="scss" scoped>

@import '@/assets/styles/portal.scss';

.container-fluid .PageTitle {
  padding-left: 10px;
  padding-right: 10px;
}

li {
  line-height: 20px;
  float:left ;
  list-style: none;

  a {
    border-top: none;
    border-right: none;
    border-left: none;
    border-color: transparent;
    background-color: inherit;
    padding-left: 5px;
    padding-right: 5px;
    margin: 0 5px;
    border-bottom: 2px solid transparent;

    padding-top: 8px;
    padding-bottom: 8px;
    float: left;
    font-size: 14px;
    line-height: 20px;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
  }
}

#cmsTimeRangeSelection{
  margin-top: 0px;
}

.container-fluid {
  float:left;
  // background-color: #fff;
  // padding-left: 10px;
}

.service-status-and-name{
  font-size: 14px;
}

.badges-column , .host-status-and-name{
  line-height: 24px;
  font-size: 14px;
}

</style>