<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
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
                        <img class="dire-panel-icon" :src="item.icon" :alt="item.name" />
                        {{ item.name }} 
                      </div>
                      <div class="panel-describe">通过简单几步，图中7种主流开发环境轻松部署，摆脱海量文档搜索之苦。</div>
                      <div class="panel-tip">访问链接</div>
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
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 构建解决方案</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:100%" v-for="item in apps" :key="item">
                  <div class="app-icon">
                    <img :src="item.icon" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }} <i class="fa-solid fa-arrow-up-right-from-square"></i>
                    </div>
                    <div class="app-item desc">{{ item.desc }}</div>
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
      </el-col>
    </el-row>

  </div>
</template>

<script setup>

const directContent = ref([
  { icon: 'fa-solid fa-ship', name: '快速搭建网站', desc: 'With EC2 (2 分钟)' },
  { icon: 'fa-solid fa-helmet-un', name: '部署开发环境', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/3da5e8169d2f1426f99fbef54575fe96-6382cb2dfdd2f74c99bc8a64a338358e.svg', name: '搭建云上博客', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg', name: '搭建小程序', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-truck-fast', name: '云上高可用架构', desc: 'With Route 53 (3 分钟)' },
]);

const apps = ref([
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/051de32597041e41f73b97d61c67a13b-9cbdaf85e3bcf29b656fdedd8e6d1305.svg', name: '构建 Web 应用程序', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg', name: '部署无服务器微服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/7177e919b32ad97825f95e902595014b-1594766d92813b5baeb706c453f91de0.svg', name: '使用虚拟服务器构建', desc: 'With Route 53 (3 分钟)' },
  { icon: 'fa-solid fa-ship', name: '启动虚拟机', desc: 'With EC2 (2 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/3da5e8169d2f1426f99fbef54575fe96-6382cb2dfdd2f74c99bc8a64a338358e.svg', name: '启动开发项目', desc: 'With Route 53 (3 分钟)' },
]);

</script>