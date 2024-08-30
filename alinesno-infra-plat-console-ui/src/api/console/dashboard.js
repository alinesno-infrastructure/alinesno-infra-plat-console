import request from '@/utils/request'

const prefix = '/api/infra/plat/console/status'

// 获取到视图列表 
export function getViewList() {
  return request({
    url: prefix + '/viewList' , 
    method: 'get'
  })
}

// 更新保存视图
export function updateViewList(data) {
  return request({
    url: prefix + '/updateViewList' , 
    method: 'post',
    data: data
  })
}

// 用户签到
export function daySignIn(){
  return request({
    url: prefix + '/daySignIn' , 
    method: 'get'
  })
}

// 打招呼信息
export function getGreeting(){
  return request({
    url: prefix + '/getGreeting' , 
    method: 'get'
  })
}

// 建议与反馈
export function addFeedback(data){
  return request({
    url: prefix + '/feedback' , 
    method: 'post',
    data: data
  })
}

// 查询组织信息
export function findOrg(){
  return request({
    url: prefix + '/findOrg' , 
    method: 'get'
  })
}

// 更新用户组织信息
export function updateOrgCustomTheme(data) {
  return request({
    url: prefix + '/updateOrgCustomTheme' , 
    method: 'post',
    data: data
  })
}