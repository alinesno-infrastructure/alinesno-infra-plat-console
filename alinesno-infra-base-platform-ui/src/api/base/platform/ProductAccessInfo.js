import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

/**
 * 数据库接口操作
 * 
 * @author luoxiaodong
 * @since 1.0.0
 */

// 接口配置项
var prefix = '/api/infra/base/platform/ProductAccessInfo/' ;
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
    downloadFile: prefix + "downloadFile"
}

// 查询数据库列表
export function listProductAccessInfo(query) {
  return request({
    url: managerUrl.datatables ,
    method: 'post',
    params: query
  })
}

// 查询数据库详细
export function getProductAccessInfo(databaseId) {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(databaseId),
    method: 'get'
  })
}

// 新增数据库
export function addProductAccessInfo(data) {
  debugger
  return request({
    url: managerUrl.saveUrl ,
    method: 'post',
    params: query
  })
}

// 修改数据库
export function updateProductAccessInfo(data) {
  debugger
  return request({
    url: managerUrl.updateUrl ,
    method: 'put',
    params: query
  })
}

// 删除数据库
export function delProductAccessInfo(databaseId) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(databaseId),
    method: 'delete'
  })
}


// 状态【请填写功能名称】修改
export function changeProductAccessInfoStatus(id , status) {
    const data = {
        id ,
        status
    }
    return request({
        url: managerUrl.statusUrl,
        method: 'put',
        params: query
    })
}