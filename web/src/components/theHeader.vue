<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="Home">
        <router-link to="/">首页</router-link>
      </a-menu-item>
      <a-menu-item key="AdminEbook">

        <router-link to="/About">关于我们</router-link>
      </a-menu-item>
      <a-menu-item key="About">

        <router-link to="/admin/Admin-Ebook">电子书管理</router-link>
        </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'theHeader'
});
</script>
