import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'


//看到#app就想到了public目录下index.html中页面的id
//在实现逻辑上，vue是通过执行main.ts将内容页App.Vue中的内容渲染到index.html上
createApp(App).use(store).use(router).mount('#app')
