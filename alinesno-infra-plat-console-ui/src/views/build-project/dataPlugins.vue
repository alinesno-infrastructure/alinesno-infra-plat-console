<template>
  <div class="acp-component-container">
    <div class="acp-compoent-title">
      已集成能力
      <div class="componet-add-plugins"><i class="fa-solid fa-pen-nib"></i> 添加能力</div>
    </div>
    <div class="acp-component-plugins-panel">
      <ul>
        <li class="acp-plugins-item" v-for="item in selectPluginItemList" :key="item">
          <div class="acp-plugins-item-title">{{ item.title }}</div>
          <div class="acp-plugins-item-desc">{{ item.desc }}</div>
          <div class="acp-plugins-item-checkbox"></div> 
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>

const selectPluginItemList = ref([
  { id: '5', title: '数据资产服务', icon: '', desc: '阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案.' },
  { id: '6', title: '数据集成服务', icon: '', desc: '通过Alibaba Nacos实现配置管理：支持分布式系统中的外部化配置、配置更改时自动刷新功能' },
  { id: '6', title: '数据集成服务', icon: '', desc: '通过Alibaba Nacos实现配置管理：支持分布式系统中的外部化配置、配置更改时自动刷新功能' },
  { id: '7', title: '实时数据服务(Flink) ', icon: '', desc: '一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务.' },
  { id: '11', title: '数据网关服务', icon: '', desc: 'AIP关系型数据库RDS（Relational Database Service）可弹性伸缩的在线数据库彻底解决数据库运维的烦恼。' },
  { id: '5', title: '数据资产服务', icon: '', desc: '阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案.' },
  { id: '6', title: '数据集成服务', icon: '', desc: '通过Alibaba Nacos实现配置管理：支持分布式系统中的外部化配置、配置更改时自动刷新功能' },
  { id: '1', title: '项目生成器服务', icon: '', desc: 'AIP关系型数据库RDS（Relational Database Service）是一种稳定可靠、可弹性伸缩的在线数据库服务。' },
  { id: '2', title: '权限资源引擎服务', icon: '', desc: '高可靠双机热备架构及可无缝扩展的集群架构，满足高读写性能场景及容量需弹性变配的业务需求。' },
])


const pluginItemList = ref([
  { id: '1', title: '项目生成器服务', icon: '', desc: 'AIP关系型数据库RDS（Relational Database Service）是一种稳定可靠、可弹性伸缩的在线数据库服务，提供容灾、备份、恢复、迁移等方面的全套解决方案，彻底解决数据库运维的烦恼。' },
  { id: '2', title: '权限资源引擎服务', icon: '', desc: '高可靠双机热备架构及可无缝扩展的集群架构，满足高读写性能场景及容量需弹性变配的业务需求。' },
  { id: '3', title: '分布式消息服务', icon: '', desc: 'AIP对象存储服务（Object Storage Service，简称 OSS），是AIP提供的海量、安全、低成本、高可靠的云存储服务.' },
  { id: '4', title: '多渠道通知服务', icon: '', desc: '通过nacos实现的服务发现平台.' },
  { id: '5', title: '数据资产服务', icon: '', desc: '阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案.' },
  { id: '6', title: '数据集成服务', icon: '', desc: '通过Alibaba Nacos实现配置管理：支持分布式系统中的外部化配置、配置更改时自动刷新功能' },
  { id: '7', title: '实时数据服务(Flink) ', icon: '', desc: '一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务.' },
  { id: '11', title: '数据网关服务', icon: '', desc: 'AIP关系型数据库RDS（Relational Database Service）是一种稳定可靠、可弹性伸缩的在线数据库服务，提供容灾、备份、恢复、迁移等方面的全套解决方案，彻底解决数据库运维的烦恼。' },
  { id: '12', title: '数据上报服务', icon: '', desc: '高可靠双机热备架构及可无缝扩展的集群架构，满足高读写性能场景及容量需弹性变配的业务需求。' },
  { id: '13', title: '主数据服务', icon: '', desc: 'AIP对象存储服务（Object Storage Service，简称 OSS），是AIP提供的海量、安全、低成本、高可靠的云存储服务.' },
  { id: '14', title: '审计日志服务', icon: '', desc: '通过nacos实现的服务发现平台.' },
  { id: '15', title: '配置管理服务', icon: '', desc: '阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案.' },
  { id: '16', title: '自动化操作服务', icon: '', desc: '通过Alibaba Nacos实现配置管理：支持分布式系统中的外部化配置、配置更改时自动刷新功能' },
  { id: '17', title: '一体化安全触感服务 ', icon: '', desc: '一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务.' },
])

</script>

<style lang="scss" scoped>
.acp-component-container {
  font-size: 14px;
  padding-left: 30px;

  .acp-compoent-title {
    font-size: 17px;
    margin-bottom: 20px;
    font-weight: bold;
    background-color: #fafafa;
    padding: 16px 20px;
    border-bottom: 1px solid #eaeded;

    .componet-add-plugins {
    float: right;
    color: #3b5998;
    font-size: 14px;
    font-weight: 550;
}
  }

  ul {
    margin: 0px;
    padding: 0px;

    li {
      list-style: none;
    }
  }

  .acp-component-plugins-panel {

    li.acp-plugins-item {
      margin-bottom: 15px;
      position: relative;
      background: #fafafa;
      padding: 15px;
      height: 100px;
      overflow: hidden;
      width: calc(50% - 10px);
      float: left;
      margin-right: 5px;
      margin-left: 5px;
      padding-right: 70px;
      line-height: 30px;
      border-radius: 2px;

      .acp-plugins-item-title {
        font-size: 15px;
        font-weight: 500;
        margin-bottom: 5px;
      }

      .acp-plugins-item-desc {
        font-size: 12px;
        color: #545b64;
        line-height: 1.2rem;
      }

      .acp-plugins-item-checkbox {
        position: absolute;
    display: block;
    border: 2px solid #e4e4e4;
    height: 24px;
    width: 24px;
    margin-top: -12px;
    top: 50%;
    right: 16px;
    border-radius: 14px;
      }

    }
  }

}
</style>