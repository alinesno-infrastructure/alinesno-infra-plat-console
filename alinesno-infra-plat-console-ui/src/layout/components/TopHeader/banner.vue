<template>
  <div>
    <router-link class="header-logo-bar" to="/index">
      <div class="header-logo" v-if="enableLogo" @click="enterDomain">
        <img :src="saasLogoUrl" alt="" />
      </div>
      <a :title="saasTitle" target="_self" class="header-logo-label">
        <span>{{ saasTitle }} </span>
      </a>
      <div v-if="saasUrl" class="dashboard-home" @click="dashboardHome()">
        <i class="fa-solid fa-house"></i> 工作台
      </div>
    </router-link>
  </div>
</template>

<script>

export default {
  name: 'TopHeader',
  components: {
  },
  computed: {
  },
  data() {

    let saasTitle = 'AIP智能设施'
    let enableLogo = true;
    let saasUrl = '/index' ; 
    let saasLogoUrl = 'http://data.linesno.com/logo_2.png' ;
    let displayUrl = ''; 


    return {
      saasTitle,
      saasUrl,
      saasLogoUrl,
      enableLogo,
      displayUrl,
      domainName: null,
    }
  },
  created() {
  },
  methods: {
    dashboardHome() {
      window.location.href = this.saasUrl
    },
    // 进入企业官网
    enterDomain() {
      if (this.domainName) { // 跳转进入官网
        window.open(this.domainName)
      }
    }
  }
}
</script>
