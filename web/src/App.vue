<template>
  <a-layout>
   <the-header></the-header>
<!--    <Home></Home>-->
    <router-view to="/Home" ></router-view>
    <the-footer></the-footer>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import theHeader from "@/components/theHeader.vue";
import theFooter from "@/components/theFooter.vue";
import Home  from "@/views/Home.vue";

export default defineComponent({
  name:"App",
  components:{
    theHeader,
    theFooter,
    Home
  }
})

</script>

<style>
#components-layout-demo-top-side .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
