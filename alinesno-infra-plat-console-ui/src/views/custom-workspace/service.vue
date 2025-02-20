<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col :span="19">
        <UcenterApps ref="ucenterAppRef" :types="apps" @refresh="getList" />
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
                <li class="app-items"
                    style="width: calc(100% - 10px);padding: 10px 0px;display: flex;flex-wrap: nowrap;"
                    v-for="item in apps" :key="item">
                  <div class="app-icon" style="font-size:1.4rem">
                    <i :class="item.icon"></i>
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.typeDescribe }}</div>
                  </div>
                  <div class="app-tip" @click="handleUpdate(item)" style="float: right;font-size: 0.8rem;color:#a5a5a5;width:80px;text-align:right">
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
              <el-button type="warning" size="large" @click="handleAddType()" text bg style="width:100%"><i class="fas fa-credit-card"></i> &nbsp; 添加服务类型</el-button>
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
          <el-form-item label="图标" prop="icon">
            <el-radio-group v-model="form.icon">
              <el-radio v-for="item in icons"
                :value="item.icon"
                :key="item.icon"
                :label="item.icon"
                >
                <i :class="item.icon"></i>
              </el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="类型名称" prop="name">
            <el-input v-model="form.name" placeholder="请输入类型名称" maxlength="128" />
          </el-form-item>
          <el-form-item label="排序" prop="sortNumber">
            <el-input-number v-model="form.sortNumber" class="mx-4" :min="1" :max="100" controls-position="right" @change="handleChange" />
          </el-form-item>
          <el-form-item label="类型描述" prop="typeDescribe">
            <el-input v-model="form.typeDescribe" placeholder="请输入类型描述" maxlength="128" />
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

const icons = ref([
  { id: 1, icon: 'fa-solid fa-charging-station'} ,
  { id: 1, icon: 'fa-solid fa-truck'} ,
  { id: 2, icon: 'fa-solid fa-paper-plane'} ,
  { id: 2, icon: 'fa-solid fa-ship'} ,
  { id: 3, icon: 'fa-solid fa-chart-column'},
  { id: 4, icon: 'fa-solid fa-server'}, 
  { id: 5, icon: 'fa-solid fa-box-open'}, 
  { id: 8, icon: 'fa-solid fa-file-invoice-dollar'}, 
  { id: 9, icon: 'fa-solid fa-user-tie'},
]);

const apps = ref([]);

const data = reactive({
  form: {
    sortNumber: 1,
    typeDescribe: ''
  },
  rules: {
     icon: [{ required: true, message: "请选择图标", trigger: "blur" }] , 
     name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] , 
     typeDescribe: [{ required: true, message: "类型描述不能为空", trigger: "blur" }],
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
               dialogVisible.value = false;
               getList();
            });
         } else {
            addProductType(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               dialogVisible.value = false;
               getList();
            });
         }
      }
   });
};

/** 查询类型列表 */
function getList() {
   listProductType().then(res => {
      apps.value = res.data;
      ucenterAppRef.value.refreshApps(apps.value);
   });
}

/** 重置按钮操作 */
function resetForm(){
  form.value = {
    icon: '' , 
    name: '' , 
    typeDescribe: '' , 
    sortNumber: 1,
  };
}

/** 修改按钮操作 */
function handleUpdate(row) {
   const ProductItemId = row.id ;
   getProductType(ProductItemId).then(response => {
      form.value = response.data;
      dialogVisible.value = true;
      title.value = "修改业务类型";
   });
}

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
function handleAddType() {
   resetForm();
   dialogVisible.value = true;
}

/** 新增业务类型 */
function handleAddProduct(){
  ucenterAppRef.value.handleAdd()
}

getList();

</script>

<style lang="scss" scope>
.grid-content {
    float: left;
    width: 100%;
}
</style>