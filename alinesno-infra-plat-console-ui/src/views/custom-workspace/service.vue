<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col :span="19">
        <UcenterApps ref="ucenterAppRef" :types="apps" />
      </el-col>

      <el-col class="panel-col" :span="5">
        <div class="grid-content">
          <div class="panel-header" style="border-bottom: 0px;">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 业务服务类型
              <el-button type="primary" @click="dialogVisible = true" style="float:right" link>
                添加 
              </el-button>
            </div>
          </div>
          <div class="panel-body" style="height:auto">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:calc(100% - 10px);padding:10px 0px" v-for="item in apps" :key="item">
                  <div class="app-icon" style="font-size:1.4rem">
                    <i :class="item.icon"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                  <div class="app-tip" @click="handleUpdate(item)" style="float: right;font-size: 0.8rem;color:#a5a5a5">
                    <i class="fas fa-tools"></i> <span class="counter issues-label">编辑</span>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="panel-footer" style="border-top: 0px;">
            <div class="footer-link">
              <el-button type="primary" size="large" @click="handleAddProduct()" text bg style="width:100%"><i class="fa-solid fa-server"></i> &nbsp; 添加业务应用</el-button>
              <br/><br/>
              <el-button type="warning" size="large" @click="dialogVisible = true" text bg style="width:100%"><i class="fas fa-credit-card"></i> &nbsp; 添加服务类型</el-button>
            </div>
          </div>
        </div>
      </el-col>

    </el-row>

    <el-dialog v-model="dialogVisible" :title="title" width="500">
      <el-form
          ref="databaseRef" 
          :model="form"
          :rules="rules"
          label-width="auto"
          status-icon>
          <el-form-item label="类型名称" prop="name">
            <el-input v-model="form.name" placeholder="请输入类型名称" maxlength="128" />
          </el-form-item>
          <el-form-item label="类型描述" prop="desc">
            <el-input v-model="form.desc" placeholder="请输入类型描述" maxlength="128" />
          </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm()">
           确认 
          </el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup>

import UcenterApps from './ucenterApps.vue'

import {
   listProductType,
   delProductType,
   getProductType,
   updateProductType,
   addProductType
} from "@/api/console/productType";

const router = useRouter();
const { proxy } = getCurrentInstance();

const ucenterAppRef = ref(null)
const dialogVisible = ref(false)
const title = ref("添加应用类型")

const apps = ref([
  {icon: 'fa-solid fa-charging-station' , name:'权限资源引擎服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-truck' , name:'网关配置服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-paper-plane' , name:'分布式配置中心服务' , desc:'With Route 53 (3 分钟)'},
  {icon: 'fa-solid fa-ship' , name:'公共存储服务' , desc:'With EC2 (2 分钟)'},
]);

const data = reactive({
  form: {},
  rules: {
     name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] , 
     desc: [{ required: true, message: "类型描述不能为空", trigger: "blur" }],
  }
});

const { form, rules } = toRefs(data);

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProductType(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductType(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

/** 查询类型列表 */
function getList() {
   loading.value = true;
   listProductType(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductTypeList.value = res.rows;
      total.value = res.total;
   });
};

/** 修改按钮操作 */
function handleUpdate(row) {
   const ProductItemId = row.id ;
   getProductType(ProductItemId).then(response => {
      form.value = response.data;
      dialogVisible.value = true;
      title.value = "修改业务类型";
   });
};

/** 删除按钮操作 */
function handleDelete(row) {
   const tmpIds = row.id 
   proxy.$modal.confirm('是否确认删除应用编号为"' + tmpIds + '"的数据项？').then(function () {
      return delProductType(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 新增业务类型 */
function handleAddProduct(){
  ucenterAppRef.value.handleAdd()
}

</script>