<template>
  <div style="padding-top:0px;">
    <el-row :gutter="20" style="float:left;width:100%;margin-bottom:0px;">
      <el-col :span="24" style="padding:0px !important;border:0px;">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 服务运行状态</div>
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
      </el-col>
    </el-row>

    <el-row :gutter="20" style="float:left;width:100%;">

      <el-col :span="12" style="border:0px;">
        <div id="echarts-bar-chart-2" :style="{ width: '100%', height: '180px' }"></div>
      </el-col>

      <el-col :span="12" style="border:0px;">
        <div id="echarts-bar-chart" :style="{ width: '100%', height: '180px' }"></div>
      </el-col>

    </el-row>

    <el-row :gutter="20" style="float:left;width:100%;">
      <el-col :span="24" style="padding:0px !important;border:0px;">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 服务运行状态</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">

              <div class="direct-box">
                <ul>
                  <li class="box-item" v-for="item in directContent" :key="item">
                    <div class="dire-panel">
                      <div class="panel-title">
                        <!-- <img class="dire-panel-icon" :src="item.icon" :alt="item.name" /> -->
                        <i :class="item.icon" /> {{ item.name }} 
                      </div>
                      <div class="panel-describe">通过简单几步，图中7种主流开发环境轻松部署，摆脱海量文档搜索之苦。</div>
                    </div>
                  </li>
                </ul>
              </div>

          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>

        <!-- <div class="WidgetHomeProductMy-detailContainer-3W8nd">

          <h3 class="h3-title">
            <span tooltipicon="help" class="nb-rc-text product-title">
              <span class="the-text"><i class="fas fa-pencil-ruler"></i> 接入教程</span>
            </span>
          </h3>

          <ul class="product_list thm-uglier">
            <li class="product_list_li" v-for="(item, index) in learnDocumentArr" :key="index">
              <div class="text-title" @click="goTarget(item.link)">
                  {{ item.title }}
                <span v-if="item.status == 1" class="recom-label">推荐</span>
                <span class="text-icons"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="text-descript">
                {{ item.desc }}
              </div>
            </li>
          </ul>
        </div> -->
      </el-col>
    </el-row>
  </div>
</template>

<script setup>

const directContent = ref([
  { icon: 'fa-solid fa-ship', name: '快速搭建网站', desc: 'With EC2 (2 分钟)' },
  { icon: 'fa-solid fa-helmet-un', name: '部署开发环境', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fas fa-laptop-code', name: '搭建云上博客', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '搭建小程序', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '云上高可用架构', desc: 'With Route 53 (3 分钟)' },
]);

</script>

<script>
import * as echarts from 'echarts';

export default {
  name: "index",
  data() {
    return {
      appCount: 10,
      runCountArr:[
        {name:'监控服务器统计' , count:812 , icon:'fas fa-server' , link:'https://192.168.1.170:3000/d/aka/node-exporter-dashboard?orgId=1&kiosk=tv'} ,
        {name:'服务运行健康报告' , count:292 , icon:'fas fa-shipping-fast' , link:'https://192.168.1.161:30090/promethues/alerts'} ,
        {name:'运行监控日志审计' , count:322 , icon:'fas fa-pencil-ruler' , link:"https://192.168.1.55:5601/app/discover#/view/ae40de50-d919-11ed-a141-51d122929855?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-1y,to:now))&_a=(columns:!(message,'@timestamp',service,host),filters:!(),index:'32258160-bfb4-11ec-8af6-65a485b4d749',interval:auto,query:(language:kuery,query:''),sort:!(!('@timestamp',desc)))"} ,
        {name:'审计日志监控统计' , count:932 , icon:'fas fa-laptop-code' , link:"https://192.168.1.55:5601/app/dashboards#/view/722b74f0-b882-11e8-a6d9-e546fe2bba5f?_g=(filters:!(),refreshInterval:(pause:!f,value:900000),time:(from:now-7d,to:now))&_a=(description:'Analyze%20mock%20eCommerce%20orders%20and%20revenue',filters:!(),fullScreenMode:!f,options:(hidePanelTitles:!f,useMargins:!t),query:(language:kuery,query:''),tags:!(),timeRestore:!t,title:'%5BeCommerce%5D%20Revenue%20Dashboard',viewMode:edit)"} ,
        {name:'容器云运行状态' , count:122 , icon:'fas fa-server' , link:"https://192.168.1.161:30080/kubernetes/default/cluster/overview"} ,
        {name:'自动化任务管理' , count:932 , icon:'fas fa-train' , link:"https://192.168.1.161:8000/view/%E8%87%AA%E5%8A%A8%E5%8C%96%E8%BF%90%E7%BB%B4%E4%BB%BB%E5%8A%A1/"} ,
        {name:'自动化任务脚本' , count:132 , icon:'fas fa-server' , link: "https://192.168.1.79/-/ide/project/capinfo-platform-jm/capinfo-platform-operation-manager/edit/jm-gjj/-/"} ,
        {name:'中间件运行统计' , count:312 , icon:'fas fa-pencil-ruler'} ,
        {name:'系统访问统计' , count:192 , icon:'fas fa-shipping-fast'} ,
      ],
      functionCount: 123,
      accountCount: 1200,
      learnDocumentArr: [
        {
          title: "日志集成监控",
          status: "1",
          desc: "集成分布式日志服务和容器、服务日志",
          link: "#" , 
        },
        {
          title: "自动化任务集成",
          status: "1",
          desc: "集成自动化任务管理，日志迁移备份等",
          link: "#" , 
        },
        {
          title: "服务器集成监控",
          status: "0",
          desc: "服务器和中间件集成监控，资源状态监控",
          link: "#" , 
        },
        {
          title: "分布式链路集成(APM)",
          status: "0",
          desc: "应用运行状态监控，集成Java应用运行状态",
          link: "#" , 
        },
        {
          title: "预警集成监控",
          desc: "集成邮件、企业微信机器从通知预警",
          link: "#" , 
        },
      ],
    };
  },
  components: {
  },
  mounted() {
    this.drawBar();
    this.drawBar2();
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    jumpToPage(page) {
      this.$router.push(page);
    },
    drawBar2() {
      let barChart = echarts.init(document.getElementById('echarts-bar-chart-2'))
        var lineOption;

      // prettier-ignore
      const hours = [
          '12a', '1a', '2a', '3a', '4a', '5a', '6a',
          '7a', '8a', '9a', '10a', '11a',
          '12p', '1p', '2p', '3p', '4p', '5p',
          '6p', '7p', '8p', '9p', '10p', '11p'
      ];
      // prettier-ignore
      const days = ['星期六', '星期五', '星期四','星期三', '星期二', '星期一', '星期日'];

      // prettier-ignore
      const data = [[0, 0, 5], [0, 1, 1], [0, 2, 0], [0, 3, 0], [0, 4, 0], [0, 5, 0], 
                    [0, 6, 0], [0, 7, 0], [0, 8, 0], [0, 9, 0], [0, 10, 0], [0, 11, 2], 
                    [2, 1, 1], [2, 2, 0], [2, 3, 0], [2, 4, 0], [2, 5, 0], [2, 6, 0], [2, 7, 0], 
                    [2, 22, 2], [2, 23, 4], [3, 0, 7], [3, 1, 3], [3, 2, 0], [3, 3, 0], [3, 4, 0], 
                    [3, 5, 0], [3, 6, 0], [3, 7, 0], [3, 8, 1], [3, 9, 0], [3, 10, 5], [3, 11, 4], 
                    [3, 12, 7], [3, 13, 14], [3, 14, 13], [3, 15, 12], [3, 16, 9], [3, 17, 5], [3, 18, 5], 
                    [3, 19, 10], [3, 20, 6], [3, 21, 4], [3, 22, 4], [3, 23, 1], [4, 0, 1], [4, 1, 3], 
                    [0, 12, 4], [0, 13, 1], [0, 14, 1], [0, 15, 3], [0, 16, 4], [0, 17, 6], 
                    [0, 18, 4], [0, 19, 4], [0, 20, 3], [0, 21, 3], [0, 22, 2], [0, 23, 5], 
                    [2, 8, 0], [2, 9, 0], [2, 10, 3], [2, 11, 2], [2, 12, 1], [2, 13, 9], [2, 14, 8], 
                    [2, 15, 10], [2, 16, 6], [2, 17, 5], [2, 18, 5], [2, 19, 5], [2, 20, 7], [2, 21, 4], 
                    [1, 0, 7], [1, 1, 0], [1, 2, 0], [1, 3, 0], [1, 4, 0], [1, 5, 0], [1, 6, 0], 
                    [1, 7, 0], [1, 8, 0], [1, 9, 0], [1, 10, 5], [1, 11, 2], [1, 12, 2], 
                    [1, 13, 6], [1, 14, 9], [1, 15, 11], [1, 16, 6], [1, 17, 7], [1, 18, 8], 
                    [1, 19, 12], [1, 20, 5], [1, 21, 5], [1, 22, 7], [1, 23, 2], [2, 0, 1], 
                    [4, 2, 0], [4, 3, 0], [4, 4, 0], [4, 5, 1], [4, 6, 0], [4, 7, 0], [4, 8, 0], [4, 9, 2], [4, 10, 4], [4, 11, 4], [4, 12, 2], [4, 13, 4], [4, 14, 4], [4, 15, 14], [4, 16, 12], [4, 17, 1], [4, 18, 8], [4, 19, 5], [4, 20, 3], [4, 21, 7], [4, 22, 3], [4, 23, 0], [5, 0, 2], [5, 1, 1], [5, 2, 0], [5, 3, 3], [5, 4, 0], [5, 5, 0], [5, 6, 0], [5, 7, 0], [5, 8, 2], [5, 9, 0], [5, 10, 4], [5, 11, 1], [5, 12, 5], [5, 13, 10], [5, 14, 5], [5, 15, 7], [5, 16, 11], [5, 17, 6], [5, 18, 0], [5, 19, 5], [5, 20, 3], [5, 21, 4], [5, 22, 2], [5, 23, 0], [6, 0, 1], [6, 1, 0], [6, 2, 0], [6, 3, 0], [6, 4, 0], [6, 5, 0], [6, 6, 0], [6, 7, 0], [6, 8, 0], [6, 9, 0], [6, 10, 1], [6, 11, 0], [6, 12, 2], [6, 13, 1], [6, 14, 3], [6, 15, 4], [6, 16, 0], [6, 17, 0], [6, 18, 0], [6, 19, 0], [6, 20, 1], [6, 21, 2], [6, 22, 2], [6, 23, 6]]
          .map(function (item) {
          return [item[1], item[0], item[2] || '-'];
      });

      lineOption= {
        title: {
          text: '日志采集量统计'
        },
        tooltip: {
          position: 'top'
        },
        grid: {
          height: '85%',
          width: '90%',
          top: '1%'
        },
        xAxis: {
          type: 'category',
          data: hours,
          splitArea: {
            show: true
          }
        },
        yAxis: {
          type: 'category',
          data: days,
          splitArea: {
            show: true
          }
        },
        visualMap: {
          min: 0,
          max: 10,
          calculable: true,
          orient: '',
          left: 'left',
          bottom: '0%'
        },
        series: [
          {
            name: '异常次数',
            type: 'heatmap',
            data: data,
            label: {
              show: true
            },
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }; 
      barChart.setOption(lineOption);

      window.addEventListener('resize', () => {
        barChart.resize();
      });

    },
    drawBar() {
      let barChart = echarts.init(document.getElementById('echarts-bar-chart'))
      let lineOption = {
        title: {
          text: '定时任务状态'
        },
        tooltip: {
          trigger: 'axis'
        },
        grid: {
          height: '85%',
          width: '90%',
          top: '1%'
        },
        legend: {
          data: ['执行成功', '执行失败']
        },
        // grid: {
        //   x: 40,
        //   x2: 40,
        //   y2: 24
        // },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            boundaryGap: false,
            data: [
              '1', '2', '3', '4', '5', '6', '7',
              '22', '23', '24', '25', '26', '27', '28',
            ]
          }
        ],
        yAxis: [
          {
            type: 'value',
            axisLabel: {
              formatter: '{value} K'
            }
          }
        ],
        series: [
          {
            name: '正常日志',
            type: 'line',
            data: [
              11, 10, 12, 13, 5, 13, 8,
              11, 9, 15, 8, 12, 8, 8,
            ],
            markPoint: {
              data: [
                { type: 'max', name: '最大值' },
                { type: 'min', name: '最小值' }
              ]
            },
            markLine: {
              data: [
                { type: 'average', name: '平均值' }
              ]
            }
          },
          {
            name: '异常日志',
            type: 'line',
            data: [
              8, 2, 7, 5, 9, 10, 7,
              8, 2, 7, 5, 9, 10, 7,
            ],
            markPoint: {
              data: [
                { name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }
              ]
            },
            markLine: {
              data: [
                { type: 'average', name: '平均值' }
              ]
            }
          }
        ]
      };
      barChart.setOption(lineOption);

      window.addEventListener('resize', () => {
        barChart.resize();
      });

    }
  },
};
</script>

<style scoped lang="scss">
.chart {
  height: 400px;
}

.homeHeader {
  position: relative;
  box-sizing: border-box;
  padding: 24px 24px 0;
  background-color: #fff;
  box-shadow: 0 1px 0 0 #e3e4e6;
  z-index: 1;
}

.homeHeader h1 {
  margin: 0 0 8px;
  font-size: 16px;
  color: #333;
  line-height: 24px;
}

.widget-title {
  font-size: 14px;
  color: #333;
  line-height: 24px;
  font-weight: 400;
  //    float: left;
  width: 100%;
}

.function-btn{
  width: 100%;
  float: left;
  margin-bottom: 10px;
  margin-left: 0px;
}

.app-icon {
  width: 32px;
  height: 32px;
  position: relative;
}

.el-row {
  margin-bottom: 20px;

  &:last-child {
    margin-bottom: 0;
  }
}

.el-col {
  border-radius: 2px;
  background: #fff;
  padding: 20px !important;
  padding-left: 20px !important;
  padding-right: 20px !important;
  border: var(--card-border-width, 1px) var(--card-border-style, solid) var(--card-border-color, #e3e4e6);
}

.el-col-8 {
  width: calc(33.3333333333% - 10px);
  margin-left: 10px;
}

.widget-bulletin-list .item {
  height: 32px;
  line-height: 32px;
  white-space: nowrap;
  -o-text-overflow: ellipsis;
  text-overflow: ellipsis;
  overflow: hidden;
  font-size: 12px;

  a {
    color: #555;
  }
}

.product_list_li:nth-child(3),
.product_list_li:nth-child(6) {
  border-right: 0px;
}

.product_list_li {
  width: 30% !important;
  padding: 16px !important;
  border-radius: 0px !important;
  border-right: 1px solid #eee;
  font-size: 12px;
  height: 90px;
  overflow: hidden;

  .text-title {
    font-size: 16px;
    color: #333;
    cursor: pointer;
    letter-spacing: 0;
    line-height: 24px;

    span.recom-label {
      color: #005bd4;
      font-weight: 700;
      border: 1px solid #005bd4;
      border-radius: 3px;
      margin-left: 10px;
      padding: 2px;
      position: absolute;
      line-height: 18px;
      font-size: 8px;
    }
  }

  .text-descript {
    margin-top: 8px;
    font-size: 13px;
    color: #333;
    letter-spacing: 0.37px;
    line-height: 20px;
  }
}

.widget-bulletin-list {
  .line {
    position: absolute;
    left: -16px;
    right: -16px;
    height: 1px;
    background-color: #e3e4e6;
  }

  .pin {
    position: relative;
    margin-bottom: 15px;
    margin-top: 15px;

    .msg {
      padding: 8px 12px;
      line-height: 18px;
      color: #333;
      font-size: 12px;
      background-color: #eff3f8;
      -webkit-border-radius: 2px;
      -moz-border-radius: 2px;
      border-radius: 2px;
      margin-bottom: 16px;
    }
  }
}

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.next-col-4 {
  -ms-flex: 0 0 16.66667%;
  -webkit-flex: 0 0 16.66667%;
  flex: 0 0 16.66667%;
  width: 16.66667%;
  max-width: 16.66667%;
  float: left;
}

.subtitle {
  font-weight: 500;
  font-size: 12px;
  color: #666;
  line-height: 20px;
  margin: 16px 0 8px;
}

.thm-uglier {
  list-style: none;
  margin: 0;
  padding: 0;
}

.product_list {
  a {
    display: flex;
    align-items: center;
    padding: 0 16px;
    background-color: #f9f9f9;
    width: 100%;
    line-height: 36px;
    text-decoration: none;
    color: #333;
    transition: all 250ms linear;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}

.product_list>li {
  padding: 0 8px 8px 0;
  overflow: hidden;
  flex: none;
  float: left;
  border-radius: 4px;

  a {
    line-height: 42px;

    i {
      display: none;
      border: 1px solid #dedede;
      border-radius: 14px;
      width: 28px;
      height: 28px;
      text-align: center;
    }
  }

  .WidgetHomeProductMy-product_name-TNtW6 {
    flex: 1;
    margin-left: 8px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}

.h3-title {
  font-size: 16px;
  font-weight: 500;
  margin-top: 0px;
  margin-bottom: 10px;
  padding-left: 16px;
}

.text-icons {
  float: right;
  margin-right: 10px;
  font-size: 16px;
  font-weight: 200;
  color: #ccc;
}

li.product_list_li.count-li {
  width: calc(50% - 16px) !important;
  height: 160px;
  border-right: 0px;
  border-radius: 5px !important;
  margin: 0px 0px 16px 16px !important;
}

.count-text-button>button {
  padding: 0 16px;
  height: 32px;
  line-height: 30px;
  font-size: 12px;
  border-width: 1px;
  border-style: solid;
  background-color: #005bd4;
  border-color: transparent;
  margin-top: 20px;
  color: #fff;
  border-radius: 3px;
  cursor: pointer;
}

.el-main,
.el-aside {
  padding: 0px;
  background: #fafafa !important;
}

.el-aside {
  padding: 20px 10px;
}

.secondary {
  font-weight: 500;
  margin-left: 5px;
  padding-left: 0;
}

.data-card {
  background: #fff;
  border-radius: 2px;
  float: left;
  width: 100%;
  margin-bottom: 15px;

  .title {
    margin-top: 0px;
    margin-bottom: 10px;
    font-size: 16px;
    font-weight: 500;
  }

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
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
      border-color: #f7f9fa;
      flex: 1;
      position: relative;
      text-align: left;
      margin-right: 8px;
      padding: 10px 15px;
      width: calc(20% - 20px);
      text-decoration: none;
      overflow: hidden;
      border-width: 0px;
      border-style: solid;
      border-radius: 2px;
      transition: all 0.1s linear;
      height: 70px;
      margin-bottom: 10px;
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
}

.summary-panel {
  .el-col {
    border-radius: 5px;
    border-width: 0px;
  }

  i,
  .task-num {
    color: #fff;
  }

  .bg-red {
    background: #f25643;
  }

  .bg-green {
    background: #3296fa;
  }

  .bg-orange {
    background: #fe892c;
  }
}

</style>