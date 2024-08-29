<template>
  <div class="acp-support-container content">
    <h1 class="cttll">产品专业服务(PSO)模块</h1>
    <ul>
      <li v-for="(item, index) in items" :key="index">
        <div class="yysyycon">
          <div class="font-icons">
            <i :class="item.icon"></i>
          </div>
          <h1>{{ item.title }}</h1>
          <h2>{{ item.description }}</h2>
          <dl>
            <dt>主要内容：</dt>
            <dd v-for="detail in item.details" :key="detail">
              <p>{{ detail }}</p>
            </dd>
          </dl>
          <div class="clearfix"></div>
        </div>
      </li>
    </ul>
    <div class="clearfix"></div>
  </div>
</template>

<script setup>
const items = ref([
  {
    "icon": "fas fa-kaaba",
    "title": "概念验证（POC）",
    "description": "目标：在约定的时间和范围内，通过设计制作相应的业务范例，证明产品的价值和特性，并达到双方事先要求的评估要求。",
    "details": [
      "与客户共同制定POC任务目标和评估办法",
      "与客户共同进行任务目标范围内的环境搭建、设计、开发、测试、部署等工作",
      "在POC任务完成后协同客户对结果进行评估"
    ]
  },
  {
    "icon": "fab fa-hornbill",
    "title": "原型制作",
    "description": "目标：通过简化项目非关键或非难点需求，实现关键的或有疑问的业务，以达到验证某种设计或展现价值的目的。",
    "details": [
      "与客户共同制定原型目标和范围",
      "目标范围内的环境搭建、设计、开发、测试、部署等工作",
      "在提供原型制作的全部设计文档、代码和搭建原型运行环境说明"
    ]
  },
  {
    "icon": "fab fa-drupal",
    "title": "高级解决方案咨询服务",
    "description": "企业业务应用云化过程是一个持续渐进的过程，必然存在传统架构与云化架构并存的阶段，而混合云架构复杂，存在技术和运维风险，难以掌控。",
    "details": [
      "提供面向构件的应用软件框架、案例咨询",
      "根据客户需求提出面向构件的应用解决方案的建议"
    ]
  },
  {
    "icon": "fas fa-envelope-open",
    "title": "应用设计咨询",
    "description": "目标：在项目需求分析和系统设计阶段，通过为客户提供基于产品的应用软件分析设计咨询服务，使得客户能够更好地利用产品进行系统设计。",
    "details": [
      "参与客户项目的需求分析和设计",
      "结合应用特点提出基于产品的设计咨询建议（包括整体结构实现描述、例举性一般流程实现方法和指定特殊流程实现方法等）"
    ]
  },
  {
    "icon": "fab fa-firefox",
    "title": "项目开发支持",
    "description": "目标：通过提供熟悉基于产品的工程师，帮助客户在项目工期紧张、资源短缺、技能补足的情况下按期保质地实现项目需求。",
    "details": [
      "可以提供高效的有关产品的开发、调试、测试、部署、维护等环节的技术支持、问题解答和帮助",
      "对开发过程的组织管理提出建议"
    ]
  },
  {
    "icon": "fab fa-freebsd",
    "title": "应用上线支持",
    "description": "目标：通过对产品和相关技术环境配置熟悉的工程师的专业服务，保障基于产品的应用系统快速顺利安装、调试并且上线成功。",
    "details": [
      "根据用户的需要提供与产品相关的现场安装、部署、联调、辅助勘错、性能优化等系列配套服务，提交相应的处理跟踪日志"
    ]
  }
]);
</script>

<style scoped>
/* Your CSS styles go here */
</style>