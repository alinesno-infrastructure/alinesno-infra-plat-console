<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="24">

        <div class="grid-content" v-for="item in apps">
          <div class="panel-header">
            <div class="header-title"><i :class="item.icon"></i> {{ item.name }}</div>
          </div>
          <div class="panel-body" style="height: auto;padding: 10px;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" 
                    style="width: calc(33% - 10px);background-color: #f5f5f5;border-radius: 5px;margin: 5px;padding-left: 10px;" 
                    v-for="i in item.children" 
                    :key="i">
                  <div class="app-icon">
                    <i :class="i.icon"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ i.name }}</div>
                    <div class="app-item desc">{{ i.desc }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>

      </el-col>

    </el-row>

  </div>
</template>

<script setup>

// const apps = ref([
//   { icon: 'fa-solid fa-ship', name: '启动虚拟机', desc: 'With EC2 (2 分钟)' },
//   { icon: 'fa-solid fa-helmet-un', name: '注册域', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-ship', name: '启动虚拟机', desc: 'With EC2 (2 分钟)' },
//   { icon: 'fa-solid fa-helmet-un', name: '注册域', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-charging-station', name: '托管静态 Web 应用程序', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-truck-fast', name: '在 AIP 上构建 SQL Server', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-ship', name: '部署 SAP on AIP', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-helmet-un', name: '注册域', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-ship', name: '启动虚拟机', desc: 'With EC2 (2 分钟)' },
//   { icon: 'fa-solid fa-charging-station', name: '托管静态 Web 应用程序', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-truck-fast', name: '在 AIP 上构建 SQL Server', desc: 'With Route 53 (3 分钟)' },
//   { icon: 'fa-solid fa-ship', name: '部署 SAP on AIP', desc: 'With Route 53 (3 分钟)' },
// ]);

const apps = ref([
  {
    icon: 'fa-solid fa-laptop-code',
    name: '常用应用',
    desc: '常用的应用程序集合',
    children: [
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-truck-fast', name: '物流管理子系统', desc: '物流跟踪和管理' },
      { icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' },
      { icon: 'fa-solid fa-box-open', name: '供应链管理系统', desc: '供应链管理和优化' },
      { icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' },
    ]
  },
  {
    icon: 'fa-solid fa-laptop-code',
    name: '核心业务应用',
    desc: '直接服务于主营业务的应用程序集合',
    children: [
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-truck-fast', name: '物流管理子系统', desc: '物流跟踪和管理' },
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' },
      { icon: 'fa-solid fa-box-open', name: '供应链管理系统', desc: '供应链管理和优化' },
      { icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' },
      { icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' },
      { icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' },
      { icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' },
      { icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' },
    ]
  },
  {
    icon: 'fa-solid fa-server',
    name: '辅助管理应用',
    desc: '用于内部管理和服务支持的应用程序',
    children: [
      { icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' },
      { icon: 'fa-solid fa-building', name: '人力资源管理系统', desc: '人力资源管理和招聘流程' },
      { icon: 'fa-solid fa-shield-alt', name: '安全管理子系统', desc: '网络安全和风险管理' },
      { icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' },
      { icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' },
    ]
  },
  {
    icon: 'fa-solid fa-chart-line',
    name: '分析决策应用',
    desc: '提供数据分析和决策支持的应用程序',
    children: [
      { icon: 'fa-solid fa-chart-line', name: '数据分析平台', desc: '数据分析和报表生成' },
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-truck-fast', name: '物流管理子系统', desc: '物流跟踪和管理' },
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' },
      { icon: 'fa-solid fa-box-open', name: '供应链管理系统', desc: '供应链管理和优化' },
      { icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' },
      { icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' },
      { icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' },
      { icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' },
      { icon: 'fa-solid fa-truck-fast', name: '物流管理子系统', desc: '物流跟踪和管理' },
    ]
  }
]);

</script>