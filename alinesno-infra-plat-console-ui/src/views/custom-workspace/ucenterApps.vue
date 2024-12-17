<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="24">

        <div class="grid-content" v-for="item in apps">
          <div class="panel-header" style="border-bottom: 0px;">
            <div class="header-title"><i :class="item.icon"></i> {{ item.name }}</div>
          </div>
          <div class="panel-body" style="height: auto;padding: 10px;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items ucenter-app-item" 
                    v-for="i in item.productItem" 
                    :key="i">

                  <div class="app-icon">
                    <i :class="i.icon"></i>
                  </div>

                  <div class="app-info">
                    <div class="app-item-title">
                      <a class="app-item-title" :underline="false" :href="i.linkPath" target="_blank">
                        {{ i.name }}
                      </a>
                    </div>
                    <div class="app-item desc">{{ i.productDescribe }}</div>
                  </div>

                  <div style="float:right">
                    <el-button productTypeId="primary" text class="app-item-btn" size="small" @click="handleUpdate(i)">修改</el-button>

                    <el-popconfirm
                        confirm-button-text="确认"
                        cancel-button-text="取消"
                        :icon="InfoFilled"
                        icon-color="#626AEF"
                        title="确认删除么?"
                        @confirm="confirmEvent(i)"
                      >
                        <template #reference>
                          <el-button productTypeId="danger" text class="app-item-btn" size="small">删除</el-button>
                        </template>
                      </el-popconfirm>

                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>

      </el-col>

    </el-row>

    <el-dialog v-model="dialogVisible" :title="title" width="680">
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
          <el-form-item label="产品类型" prop="productTypeId">
            <el-radio-group v-model="form.productTypeId">
              <el-radio v-for="item in apps"
                :value="item.id"
                :key="item.id"
                :label="item.id"
                >
                <i :class="item.icon"></i>{{ item.name }}
              </el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="产品名称" prop="name">
            <el-input v-model="form.name" placeholder="请输入类型名称" maxlength="128" />
          </el-form-item>
          <el-form-item label="产品描述" prop="productDescribe">
            <el-input v-model="form.productDescribe" placeholder="请输入类型描述" maxlength="128" />
          </el-form-item>
          <el-form-item label="排序" prop="sortNumber">
            <el-input-number v-model="form.sortNumber" class="mx-4" :min="1" :max="100" controls-position="right" @change="handleChange" />
          </el-form-item>
          <el-form-item label="产品链接" prop="linkPath">
            <el-input v-model="form.linkPath" placeholder="请输入产品链接" maxlength="128" />
          </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button productTypeId="primary" @click="submitForm()">
           确认 
          </el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup>

import {
   listProduct,
   delProduct,
   getProduct,
   updateProduct,
   addProduct
} from "@/api/console/product";

import {defineEmits} from 'vue'
const emit = defineEmits(['refresh'])

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

const router = useRouter();
const { proxy } = getCurrentInstance();

const dialogVisible = ref(false)
const title = ref("添加应用类型")

const data = reactive({
  form: {
    sortNumber: 1
  },
  rules: {
     icon: [{ required: true, message: "请选择图标", trigger: "blur" }] , 
     name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] , 
     productDescribe: [{ required: true, message: "类型描述不能为空", trigger: "blur" }],
     productTypeId: [{ required: true, message: "产品类型不能为空", trigger: "blur" }],
     linkPath: [{ required: true, message: "产品链接不能为空", trigger: "blur" }],
  }
});

const { form, rules } = toRefs(data);

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProduct(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               dialogVisible.value = false;
               emit('refresh');
               //  getList();
            });
         } else {
            addProduct(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               dialogVisible.value = false;
               emit('refresh');
               //  getList();
            });
         }
      }
   });
};

/** 查询类型列表 */
function getList() {
   loading.value = true;
   listProduct(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductList.value = res.rows;
      total.value = res.total;
   });
};

/** 修改按钮操作 */
function handleUpdate(row) {
   const ProductItemId = row.id ;
   getProduct(ProductItemId).then(response => {
      form.value = response.data;
      dialogVisible.value = true;
      title.value = "修改业务产品";
   });
};

/** 新增按钮操作 */
function handleAdd() {
  dialogVisible.value = true;
  title.value = "添加业务产品";
}

const confirmEvent = (row) => {
  console.log('confirm!')
  delProduct(row.id).then(response => {
    if (response.code === 200) {
      ElMessage.success("删除成功");
      getList();
    } else {
      ElMessage.error("删除失败");
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
   const tmpIds = row.id 
   const tmpIdName = row.name
   proxy.$modal.confirm('是否确认删除应用编号为"' + tmpIdName + '"的数据项？').then(function () {
      return delProduct(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 刷新应用列表 */
function refreshApps(types){
  apps.value = types ;
}

// 主动暴露方法
defineExpose({ handleAdd , refreshApps , handleUpdate , handleDelete , submitForm })

</script>

<style lang="scss" scoped>
.ucenter-app-item{
  width: calc(33% - 10px) !important;
  background-color: #f5f5f5;
  border-radius: 5px;
  margin: 5px;
  padding-left: 10px !important;

  &:hover{
    .app-item-btn{
      display: inline-block;
    }
  }

  .app-item-btn{
    cursor: pointer;
    display: none;
    margin-right:10px;
  }
}
</style>