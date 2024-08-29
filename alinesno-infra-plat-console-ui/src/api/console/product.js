import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/product/' ;
var managerUrl = {
    datatables : prefix +"datatables" ,
    createUrl: prefix + 'add' ,
    saveUrl: prefix + 'save' ,
    updateUrl: prefix +"modify" ,
    statusUrl: prefix +"changeStatus" ,
    cleanUrl: prefix + "clean",
    detailUrl: prefix +"detail",
    removeUrl: prefix + "delete" ,
    exportUrl: prefix + "exportExcel",
    changeField: prefix + "changeField",
    downloadfile: prefix + "downloadfile"
}

// 查询数据库列表
export function listProduct(query) {
  return request({
    url: managerUrl.datatables ,
    method: 'post',
    params: query
  })
}

// 查询数据库详细
export function getProductList(databaseId) {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(databaseId),
    method: 'get'
  })
}

// 新增数据库
export function addProduct(data) {
  return request({
    url: managerUrl.saveUrl ,
    method: 'post',
    data: data 
  })
}

// 修改数据库
export function updateProduct(data) {
  debugger
  return request({
    url: managerUrl.updateUrl ,
    method: 'put',
    params: query
  })
}

// 删除数据库
export function delProduct(id) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  })
}


// 获取产品列表 
export function getProduct() {
  return request({
    url: '/api/product/getProduct' , 
    method: 'get'
  })
}

// 通过类型获取接口
export function getProductByTypeCode(typeCode) {
  return request({
    url: '/api/product/getProductByTypeCode?typeCode=' + typeCode , 
    method: 'get'
  })
}