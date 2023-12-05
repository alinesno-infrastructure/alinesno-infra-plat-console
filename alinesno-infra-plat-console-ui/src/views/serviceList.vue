<template>
    <div class="container-main" style="padding-top: 20px;background-color: #fff;">
        <div class="tpl-app app-main-content" v-loading="fullscreenLoading">

            <div class="header">
                服务列表
                <span style="font-size: 13px;color: #a5a5a5;">这里包含所有需要运营的能力服务列表</span>
            </div>

            <section class="section" v-for="(type, index) in productList" :key="index">
                <h2 class="section-title">
                    <i :class="type.banner" /> {{ type.name }}
                </h2>
                <div class="section-body">
                    <div class="app-item border-bottom" v-for="(item, index) in type.subList" :key="index">
                        <div class="app-item__icon wk wk-icon-user">
                            <i v-if="index % 4 == 1" style="color:#3b5998;" class="icon-img fa-brands fa-slack" />
                            <i v-if="index % 4 == 0" style="color:#3b5998;" class="fab fa-pinterest-p fa-fw" />
                            <i v-if="index % 4 == 2" style="color:#3b5998;" class="icon-img fas fa-feather fa-fw" />
                            <i v-if="index % 4 == 3" style="color:#3b5998;" class="icon-img fa-brands fa-slack" />
                        </div>
                        <div class="content">
                            <h3 class="app-item__title">
                                {{ item.name }}
                                <a class="cf-service-nav-item-label" style="margin-left:10px"
                                    @click="saveCollectProduct(item)" :title="item.name">
                                    <el-button type="text" size="medium"><i class="fa-regular fa-star"></i> 收藏</el-button>
                                </a>

                            </h3>
                            <div class="app-item__desc">
                                业务基础服务规划和建设，描述待补充
                            </div>
                        </div>
                        <div class="app-item__control">
                            <a class="cf-service-nav-item-label" @click="openService(item)" :title="item.name">
                                <el-button type="text" size="medium" icon="el-icon-link">打开服务</el-button>
                            </a>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</template>
  
<script setup name="ServiceList">

const productList = ref([]);
const fullscreenLoading = false;
import { getProduct } from "@/api/console/product";

function getProductList() {
    getProduct().then(response => {
        console.log('response = ' + response);
        productList.value = response.data ;
    });
};

function openService(item){
    var link = item.linkPath ;
    // 使用 window.open 在当前窗口打开链接
    window.open(link, '_self');
}

// 获取产品列表
getProductList() ;


</script>
  
<style lang="scss" scoped>
.tpl-app {
    overflow: auto;
    color: #172b4d;
    background-color: #fff;
    padding: 10px;
    margin: 10px;
    width: 90%;
    margin: auto;

    .header {
        font-size: 24px;
        margin-left: 0px;
    }

    .popular {
        display: flex;
        align-content: center;
        justify-content: space-between;
        width: calc(100% - 20px);
        padding-bottom: 24px;
        margin-top: 24px;

        .popular-item {
            width: calc(25% - 20px);
            padding-right: 20px;
            cursor: pointer;
        }

        .popular-item__banner {
            width: 100%;
            border-radius: 4px;
        }

        .popular-item__title {
            margin: 20px 0 6px;
            font-size: 20px;

            i {
                font-size: 40px;
                color: #3b5998;
                margin-right: 10px;
            }
        }

        .popular-item__desc {
            font-size: 13px;
            color: #6b778c;
        }
    }

    .section {
        padding: 26px 20px 30px;

        &:last-child {
            border-bottom: 0 none;
        }

        .section-title {
            margin-left: -20px;
            font-size: 20px;
        }

        .section-body {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            flex-wrap: wrap;
            width: 100%;
            margin: 0 -2.5%;

            .app-item {
                width: calc(33% - 20px);
                padding: 20px 0;
                margin: 0 10px;

                .content {
                    -webkit-box-flex: 1;
                    -ms-flex: 1;
                    flex: 1;
                    overflow: hidden;
                }
            }

            .app-item__icon {
                display: flex;
                align-items: center;
                justify-content: center;
                margin-top: 15px;
                width: 48px;
                height: 48px;
                margin-right: 5px;
                font-size: 35px;
                background-color: #fff;
                border-radius: 4px;
            }

            .app-item__control {
                margin-left: 15px;

                .plain-btn {
                    padding: 8px 12px;
                    color: #3b5998;
                    font-size: 13px;
                    cursor: pointer;
                    border: 1px solid #3b5998;
                    border-radius: 4px;
                }
            }

            .app-item__title {
                margin-bottom: 0px;
                font-size: 16px;
            }

            .app-item__desc {
                overflow: hidden;
                font-size: 13px;
                color: #6b778c;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
        }
    }
}

.border-bottom {
    border-bottom: 1px solid #dfe1e6;
}

img {
    border-style: none;
}

.tpl-app .section .section-body .app-item,
.tpl-app .section .section-body {
    display: flex;
    align-items: center;
    justify-content: flex-start;
}

.wk {
    font-family: wk !important;
    font-size: 16px;
    font-style: normal;
}

span.product-text-label {
    color: #3b5998;
    font-size: .7rem !important;
    border: 1px solid #3b5998;
    padding: 2px 5px;
    border-radius: 3px;
}

span.normal {
    color: #fe892c;
    border: 1px solid #fe892c;
}

span.design {
    color: #d5d5d5 !important;
    border: 1px solid #d5d5d5 !important;
}
</style>
