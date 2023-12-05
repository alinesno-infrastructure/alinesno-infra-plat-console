<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="14">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 我的业务应用</div>
          </div>
          <div class="panel-body">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" v-for="item in apps" :key="item">
                  <div class="app-icon">
                    <img :src="item.icon" :alt="item.name" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
              查看所有服务
            </div>
          </div>
        </div>
      </el-col>

      <el-col class="panel-col" :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">常见业务建议</div>
          </div>
          <div class="panel-body">
            <el-empty :image-size="100" description="这可能是因为您没有运行 Trusted Advisor 检查，或者您没有 AWS Business 或 AWS Enterprise Support 计划。" />
          </div>
          <div class="panel-footer">
            <div class="footer-link">
              查看所有服务
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">最新博客文章</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png" alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP入门</div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" alt="" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？ </div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" alt="" />
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
              查看所有服务
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script setup>

const apps = ref([
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/051de32597041e41f73b97d61c67a13b-9cbdaf85e3bcf29b656fdedd8e6d1305.svg', name: '构建 Web 应用程序', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg', name: '部署无服务器微服务', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/7177e919b32ad97825f95e902595014b-1594766d92813b5baeb706c453f91de0.svg', name: '使用虚拟服务器构建', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/d88319dfa5d204f019b4284149886c59-7d586ea82f792b61a8c87de60565133d.svg', name: '启动虚拟机', desc: 'With EC2 (2 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/f5d2c00d40914bff4f82f29f9ef768bc-53a84099cf556710383a52b4612a8612.svg', name: '注册域', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/3da5e8169d2f1426f99fbef54575fe96-6382cb2dfdd2f74c99bc8a64a338358e.svg', name: '启动开发项目', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/fb0cde6228b21d89ec222b45efec54e7-0856e92285f4e7ed254b2588d1fe1829.svg', name: '开始迁移到 AIP', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/9da5a168cf8194c8ee5ed192a443d563-674375b53bc8ae94f48cfdb5c81e8363.svg', name: '托管静态 Web 应用程序', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/a5ffe5487f62ef75d8e5cf78c18525a5-d4867f9d4adcd749f0c5aff987232847.svg', name: '在 AIP 上构建 SQL Server', desc: 'With Route 53 (3 分钟)' },
  { icon: 'https://d1by4p17n947rt.cloudfront.net/icon/6e9e16955bd76c1d3a9996e0d6d3ad15-04cfc8c62f597690680d948b366980cf.svg', name: '部署 SAP on AIP', desc: 'With Route 53 (3 分钟)' },
]);

</script>