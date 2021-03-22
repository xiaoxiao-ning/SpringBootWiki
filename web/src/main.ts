import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue';
import axios from 'axios';

//看到#app就想到了public目录下index.html中页面的id
//在实现逻辑上，vue是通过执行main.ts将内容页App.Vue中的内容渲染到index.html上
const app = createApp(App);

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
axios.interceptors.response.use(function (response) {
    console.log('返回结果：', response);
    return response;
}, error => {
    console.log('返回错误：', error);
    const response = error.response;
    const status = response.status;
    if (status === 401) {
        // 判断状态码是401 跳转到首页或登录页
        console.log("未登录，跳到首页");
        store.commit("setUser", {});
        // message.error("未登录或登录超时");
        router.push('/');
    }
    return Promise.reject(error);
});


app.use(store).use(router).use(Antd).mount('#app');


const icons : any = Icons;
for(const i in icons){
    app.component(i,icons[i]);
}

console.log("环境:" ,process.env.NODE_ENV);
console.log("环境:" ,process.env.VUE_APP_SERVER);
