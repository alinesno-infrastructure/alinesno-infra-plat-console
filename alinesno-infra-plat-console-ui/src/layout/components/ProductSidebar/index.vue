<template>
  <div class="siderbar">
    <el-menu default-active="1" class="el-menu-vertical" :collapse="isCollapse" @open="handleOpen" @close="handleClose">

      <el-tooltip :content="item.content" placement="right" v-for="item in menuItems">
        <el-menu-item :index="item.index" @click="jumpTo(item.link)">
          <i :class="item.icon"></i>
        </el-menu-item>
      </el-tooltip>

    </el-menu>

    <el-menu style="" class="el-menu-vertical acp-suggest" :collapse="isCollapse" @open="handleOpen" @close="handleClose">
      <el-menu-item index="11" @click="jumpToConstomTheme">
        <i class="fa-solid fa-file-pen"></i>
      </el-menu-item>
      <el-menu-item index="12" @click="openFeekback()">
        <i class="fa-solid fa-paper-plane"></i>
      </el-menu-item>
    </el-menu>

    <!-- 建议和反馈 -->
    <el-dialog v-model="dialogVisible" title="使用建议和反馈" width="30%" :append-to-body="true" :before-close="handleClose">

      <el-form ref="databaseRef" label-position="top" :model="form" :rules="rules" label-width="120px" status-icon>

        <el-form-item label="您对控制台首页满意吗？" prop="problemDesc">
          <el-input type="textarea" :rows="4" resize="none" v-model="form.problemDesc"  placeholder="请输入您的建议或者反馈" maxlength="128" />
        </el-form-item>

        <el-form-item label="使用等级" prop="grade">
          <el-rate v-model="form.grade" :colors="colors" />
        </el-form-item>

        <el-form-item style="margin-top:30px">
          <el-button type="primary" @click="submitForm()">保存</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>

      </el-form>

    </el-dialog>

  </div>
</template>

<script setup>

const dialogVisible = ref(false)

import { addFeedback } from '@/api/console/dashboard'

const router = useRouter();
const { proxy } = getCurrentInstance();

const data = reactive({
  form: {
    grade: '' , 
    problemDesc: ''
  },
  rules: {
     name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] , 
     grade: [{ required: true, message: "类型描述不能为空", trigger: "blur" }],
  }
});

const { form, rules } = toRefs(data);

const menuItems = ref([
  {"index": "1","content": "平台监控","icon": "fa-solid fa-desktop","onClick": "jumpTo" , "link":"/index"},
  {"index": "3","content": "Agent智能体","icon": "fa-solid fa-user-shield","onClick": "openSmartService" , "link":"/dashboard/channelHome"},
  {"index": "2", "content": "支撑平台", "icon": "fa-solid fa-sailboat", "onClick": "openServiceList" , "link":"/dashboard/serviceList"}
]);

// 打开客户配置
function jumpToConstomTheme() {
  router.push({ path: "/dashboard/dashboardTheme" });
}

function openFeekback(){
  dialogVisible.value = true ; 

  form.value.grade = '' ; 
  form.value.problemDesc= '' ;
}

// 打开首页
function jumpTo(path) {
  router.push({ path: path });
}

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
          addFeedback(form.value).then(response => {
              proxy.$modal.msgSuccess("反馈成功，非常有帮助！");
              dialogVisible.value = false;
          });
      }
   });
};

</script>

<style lang="scss" scoped>
.el-menu-vertical:not(.el-menu--collapse) {
  width: 65px;
}

.acp-suggest {
  bottom: 20px;
  position: absolute;
}

.siderbar {
  float: left;
  height: 100%;
  width: 64px;
  border-right: 1px solid #e6e6e6;
  padding-top: 40px;
  overflow: hidden;
  background-color: #fff;
  position: fixed;
}
</style>
