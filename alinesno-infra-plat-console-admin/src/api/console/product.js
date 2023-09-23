import request from '@/utils/request'

// 获取产品列表 
export function getProduct() {
  return request({
    url: '/api/product/getProduct' , 
    method: 'get'
  })
}