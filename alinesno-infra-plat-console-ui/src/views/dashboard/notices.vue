<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="13">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">运行优化建议</div>
          </div>
          <div class="panel-body" style="padding:0px;">
            <el-empty v-if="tableData.length == 0" :image-size="100" description="这可能是因为您没有运行 Trusted Advisor 检查，或者您没有 Business 或 Enterprise Support 计划。" />

            <el-table :data="tableData" stripe style="width: 100%">
              <el-table-column type="index" width="55" label="序号" align="center" />
              <el-table-column label="图标" align="center" width="55px" prop="icon">
                  <template #default="scope">
                    <span style="font-size:25px;color:#3b5998">
                        <i class="fa-solid fa-file-word" />
                    </span>
                  </template>
              </el-table-column>
              <el-table-column prop="busType" label="业务类型" width="80" />
              <el-table-column prop="projectName" label="应用名称" width="100" :show-overflow-tooltip="true" />
              <el-table-column prop="content" label="优化建议" :show-overflow-tooltip="true" />
              <el-table-column prop="level" align="center" label="建议级别" width="80">
                <template #default="scope">
                  <div class="role-icon">
                    <span v-if="scope.row.level == 9">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-bomb" style="font-size: 20px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 1">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-fire" style="font-size: 20px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 2">
                      <el-button type="danger" bg link>
                        <i class="fa-solid fa-bug" style="font-size: 20px"></i>
                      </el-button>
                    </span>
                    <span v-if="scope.row.level == 3">
                      <el-button type="warning" bg link>
                        <i class="fa-solid fa-triangle-exclamation" style="font-size: 20px"></i>
                      </el-button>
                    </span>
                  </div>
              </template>
              </el-table-column>
            </el-table>

          </div>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">探索AIP使用</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-analytics.27a6ebec1a9e415ef6cea6ec2c9f7761c8aa3ea6.png" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP 有什么新动向？ </div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" />
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">AIP入门</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-icon">
                  <img
                    src="https://d1.awsstatic.com/webteam/homepage/solutions/60-storage.2fae209fbce7aa8e4eee9b6bde7c64e2798fe1e3.png" />
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
            </div>
          </div>
        </div>
      </el-col>

      <!-- 协助列表-->
      <el-col :span="6">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title">新最公告</div>
          </div>
          <div class="panel-body">
            <ul class="panel-item-text">
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">在AIP使用k8s快速搭建基设平台服务系统</div>
                  <div class="item-text-main-desc">了解基础知识并找到有用的信息</div>
                </div>
              </li>
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">在校园数据开发项目上使用AIP集成的实战经验</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
              <li>
                <div class="item-datetime">
                  <div class="item-datetime-month">7月</div>
                  <div class="item-datetime-date">12</div>
                </div>
                <div class="item-text">
                  <div class="item-text-main-title">某集团在使用AIP服务构建和集成的示例</div>
                  <div class="item-text-main-desc">探索新的 AIP 服务、功能和区域。</div>
                </div>
              </li>
            </ul>
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
const tableData = [
  { inde2x: 1, busType: '在线支付', projectName: '支付宝', content: '优化支付流程，提升用户体验，包括简化支付步骤，增加支付方式选择，提高支付成功率', level: '9' },
  { inde2x: 2, busType: '电商平台', projectName: '淘宝', content: '增加推荐算法，提高用户购买转化率，包括个性化推荐，热门商品推荐，购买引导等方面', level: '2' },
  { inde2x: 5, busType: '出行服务', projectName: '滴滴打车', content: '提高司机端APP稳定性，减少崩溃情况，改善司机使用体验，优化内存管理和异常处理机制', level: '9' },
  { inde2x: 6, busType: '餐饮外卖', projectName: '美团外卖', content: '优化订单配送算法，减少配送时间，提高用户满意度，优化骑手调度和路线规划', level: '2' },
  { inde2x: 3, busType: '社交网络', projectName: '微信', content: '改进朋友圈算法，减少低质量内容展示，提高用户参与度和粘性，加强内容审核机制', level: '2' },
  { inde2x: 7, busType: '社交媒体', projectName: '抖音', content: '改进内容推荐算法，增加用户粘性，提高用户留存率，优化视频推荐和用户关注推荐', level: '2' },
]

</script>