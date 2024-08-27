import request from '@/utils/request'

// 获取到视图列表 
export function getViewList() {
  return request({
    url: '/api/infra/plat/console/status/viewList' , 
    method: 'get'
  })
}

// 更新保存视图
export function updateViewList(data) {
  return request({
    url: '/api/infra/plat/console/status/updateViewList' , 
    method: 'post',
    data: data
  })
}