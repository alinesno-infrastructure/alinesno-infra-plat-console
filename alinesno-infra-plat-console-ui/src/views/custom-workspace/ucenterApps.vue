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
                    v-for="i in item.children" 
                    :key="i">

                  <div class="app-icon">
                    <i :class="i.icon"></i>
                  </div>

                  <div class="app-info">
                    <div class="app-item-title">
                      <el-link class="app-item-title" :underline="false" :href="item.linkPath" target="_blank">
                        {{ item.name }}
                      </el-link>
                    </div>
                    <div class="app-item desc">{{ i.desc }}</div>
                  </div>

                  <div style="float:right">
                    <el-button type="primary" text class="app-item-btn" size="small" @click="handleUpdate(i)">修改</el-button>

                    <el-popconfirm
                        confirm-button-text="确认"
                        cancel-button-text="取消"
                        :icon="InfoFilled"
                        icon-color="#626AEF"
                        title="确认删除么?"
                        @confirm="confirmEvent(i)"
                      >
                        <template #reference>
                          <el-button type="danger" text class="app-item-btn" size="small">删除</el-button>
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
          <el-form-item label="产品类型" prop="type">
            <el-radio-group v-model="form.type">
              <el-radio v-for="item in props.types"
                :value="item.id"
                :key="item.id"
                :label="item.name"
                >
                <i :class="item.icon"></i>{{ item.name }}
              </el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="产品名称" prop="name">
            <el-input v-model="form.name" placeholder="请输入类型名称" maxlength="128" />
          </el-form-item>
          <el-form-item label="产品描述" prop="desc">
            <el-input v-model="form.desc" placeholder="请输入类型描述" maxlength="128" />
          </el-form-item>
          <el-form-item label="排序" prop="order">
            <el-input-number v-model="form.order" class="mx-4" :min="1" :max="100" controls-position="right" @change="handleChange" />
          </el-form-item>
          <el-form-item label="产品链接" prop="link">
            <el-input v-model="form.link" placeholder="请输入产品链接" maxlength="128" />
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

import {
   listProduct,
   delProduct,
   getProduct,
   updateProduct,
   addProduct
} from "@/api/console/product";

const props = defineProps({
  // 当前选中的节点
  types: {
    type: Object,
    default: () => {}
  }
})

const apps = ref([
  {
    id: 1, // 添加 id 字段
    icon: 'fa-solid fa-laptop-code',
    name: '核心业务应用',
    desc: '直接服务于主营业务的应用程序集合',
    children: [
      { id: 2, icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' }, // 添加 id 字段
      { id: 3, icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' }, // 添加 id 字段
      { id: 4, icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' }, // 添加 id 字段
      { id: 5, icon: 'fa-solid fa-box-open', name: '供应链管理系统', desc: '供应链管理和优化' }, // 添加 id 字段
      { id: 6, icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' }, // 添加 id 字段
      { id: 7, icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' }, // 添加 id 字段
      { id: 8, icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' }, // 添加 id 字段
      { id: 9, icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' }, // 添加 id 字段
    ]
  },
  {
    id: 10, // 添加 id 字段
    icon: 'fa-solid fa-server',
    name: '辅助管理应用',
    desc: '用于内部管理和服务支持的应用程序',
    children: [
      { id: 11, icon: 'fa-solid fa-server', name: '资源管理系统', desc: '管理组织的IT资源' }, // 添加 id 字段
      { id: 12, icon: 'fa-solid fa-building', name: '人力资源管理系统', desc: '人力资源管理和招聘流程' }, // 添加 id 字段
      { id: 13, icon: 'fa-solid fa-shield-alt', name: '安全管理子系统', desc: '网络安全和风险管理' }, // 添加 id 字段
      { id: 14, icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' }, // 添加 id 字段
      { id: 15, icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' }, // 添加 id 字段
    ]
  },
  {
    id: 16, // 添加 id 字段
    icon: 'fa-solid fa-chart-line',
    name: '分析决策应用',
    desc: '提供数据分析和决策支持的应用程序',
    children: [
      { id: 17, icon: 'fa-solid fa-chart-line', name: '数据分析平台', desc: '数据分析和报表生成' }, // 添加 id 字段
      { id: 18, icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' }, // 添加 id 字段
      { id: 19, icon: 'fa-solid fa-warehouse', name: '库存管理系统', desc: '管理库存和订单' }, // 添加 id 字段
      { id: 20, icon: 'fa-solid fa-user-tie', name: '客户关系管理系统', desc: '管理客户关系和销售过程' }, // 添加 id 字段
      { id: 21, icon: 'fa-solid fa-file-invoice-dollar', name: '财务管理系统', desc: '财务记录和报告' }, // 添加 id 字段
      { id: 22, icon: 'fa-solid fa-chart-column', name: '业务管理系统', desc: '用于管理日常业务操作' }, // 添加 id 字段
      { id: 23, icon: 'fa-solid fa-truck-fast', name: '物流管理子系统', desc: '物流跟踪和管理' }, // 添加 id 字段
    ]
  }
]);

const router = useRouter();
const { proxy } = getCurrentInstance();

const dialogVisible = ref(false)
const title = ref("添加应用类型")

const data = reactive({
  form: {
    order: 1
  },
  rules: {
     name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] , 
     desc: [{ required: true, message: "类型描述不能为空", trigger: "blur" }],
     type: [{ required: true, message: "产品类型不能为空", trigger: "blur" }],
     link: [{ required: true, message: "产品链接不能为空", trigger: "blur" }],
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
               open.value = false;
               getList();
            });
         } else {
            addProduct(form.value).then(response => {
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

/** 鼠标移入事件 */
function handleMouseEnter() {
  console.log('鼠标移入');
}

/** 鼠标移出事件 */
function handleMouseLeave() {
  console.log('鼠标移出');
}

// 主动暴露方法
defineExpose({ handleAdd , handleUpdate , handleDelete , submitForm })

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