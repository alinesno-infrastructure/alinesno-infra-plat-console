<template>
  <div>
    <el-button @click="loadYaml">加载YAML</el-button>
    <el-button @click="saveYaml">保存YAML</el-button>
    <el-tree
      :data="treeData"
      :props="defaultProps"
      node-key="key"
      :expand-on-click-node="false"
      :highlight-current="true"
      @node-click="handleNodeClick"
    >
      <template #default="{ data }">
        <div>
          <!-- 显示节点名称 -->
          <span class="node-label">{{ data.label }}:</span>
          <!-- 显示节点值 -->
          <el-input v-if="editingKey === data.key" v-model="data.value" @blur="saveEdit(data)" @keyup.enter="saveEdit(data)" />
          <span v-else>{{ data.value }}</span>
        </div>
      </template>
    </el-tree>
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import { ElMessage } from 'element-plus';
import jsYaml from 'js-yaml';

// 示例YAML数据
const sampleYaml = `
application:
  name: example-app
  version: 1.0.0
  description: A simple application for demonstration purposes

services:
  - name: api-gateway
    port: 8080
    endpoints:
      - path: /users
        method: GET
      - path: /users/{userId}
        method: GET
  - name: user-service
    port: 8081
    endpoints:
      - path: /login
        method: POST
      - path: /logout
        method: POST

database:
  host: localhost
  port: 3306
  username: root
  password: secret
  name: exampledb

logging:
  level: INFO
  path: /var/log/example-app.log
`;

// 解析YAML数据为树形结构
const treeData = ref([]);
const editingKey = ref(null);
const defaultProps = ref({
  children: 'children',
  label: 'label'
});

// 将YAML转换为树形结构
function parseYamlToTree(yamlString) {
  const data = jsYaml.load(yamlString);
  const tree = convertObjectToTree(data);
  return tree;
}

function convertObjectToTree(obj, parentKey='') {
  let nodes = [];
  Object.keys(obj).forEach(key => {
    const value = obj[key];
    const fullKey = parentKey ? `${parentKey}.${key}` : key;
    nodes.push({
      key: fullKey,
      label: key,
      value: value,
      children: Array.isArray(value) || typeof value === 'object' && value !== null ? convertArrayOrObjectToTree(value, fullKey) : undefined
    });
  });
  return nodes;
}

function convertArrayOrObjectToTree(value, parentKey='') {
  if (Array.isArray(value)) {
    return value.map((item, index) => ({
      key: `${parentKey}[${index}]`,
      label: `${parentKey}[${index}]`,
      value: item,
      children: Array.isArray(item) || typeof item === 'object' && item !== null ? convertArrayOrObjectToTree(item, `${parentKey}[${index}]`) : undefined
    }));
  } else if (typeof value === 'object') {
    return convertObjectToTree(value, parentKey);
  }
  return [];
}

// 加载YAML数据
function loadYaml() {
  try {
    treeData.value = parseYamlToTree(sampleYaml);
  } catch (error) {
    ElMessage.error(`无法加载YAML数据: ${error.message}`);
  }
}

// 保存YAML数据
function saveYaml() {
  try {
    const yamlContent = jsYaml.safeDump(convertTreeToObject(treeData.value));
    console.log('Saved YAML:', yamlContent);
    ElMessage.success('YAML数据已保存');
  } catch (error) {
    ElMessage.error(`无法保存YAML数据: ${error.message}`);
  }
}

function convertTreeToObject(nodes) {
  return nodes.reduce((acc, node) => {
    const parts = node.key.split('.');
    const lastPart = parts.pop();
    let current = acc;
    parts.forEach(part => {
      if (!current[part]) current[part] = {};
      current = current[part];
    });
    current[lastPart] = node.value;
    return acc;
  }, {});
}

// 处理节点点击事件
function handleNodeClick(data) {
  editingKey.value = data.key;
}

// 保存编辑
function saveEdit(data) {
  editingKey.value = null;
}

watchEffect(() => {
  loadYaml();
});
</script>

<style scoped>
.node-label {
  font-weight: bold;
  margin-right: 5px;
}
</style>