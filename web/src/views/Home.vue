<template>

  <a-layout-content style="padding: 0 50px">
    <a-layout style="padding: 24px 0; background: #fff">
      <a-layout-sider width="200" style="background: #ffffff">
        <a-menu
            mode="inline"
            style="height: 100%"
        >
          <a-sub-menu key="sub1">
            <template #title>
                <span>
                  <user-outlined />
                  qwdfqefqfqwfqef
                </span>
            </template>
            <a-menu-item key="1">option1</a-menu-item>
            <a-menu-item key="2">option2</a-menu-item>
            <a-menu-item key="3">option3</a-menu-item>
            <a-menu-item key="4">option4</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
                <span>
                  <laptop-outlined />
                 fqwefqwefqwefqwef
                </span>
            </template>
            <a-menu-item key="5">option5</a-menu-item>
            <a-menu-item key="6">option6</a-menu-item>
            <a-menu-item key="7">option7</a-menu-item>
            <a-menu-item key="8">option8</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
                <span>
                  <notification-outlined />
                  subnav 3
                </span>
            </template>
            <a-menu-item key="9">option9</a-menu-item>
            <a-menu-item key="10">option10</a-menu-item>
            <a-menu-item key="11">option11</a-menu-item>
            <a-menu-item key="12">option12</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
        <a-list item-layout="vertical" size="large" :data-source="ebook" :grid="{ gutter: 20, column: 4 }">
          <template #renderItem="{ item }">
            <a-list-item key="item.name">
              <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
              </template>
              <a-list-item-meta :description="item.description">
                <template #title>
                  <a :href="item.href">{{ item.name }}</a>
                </template>
                <template #avatar><a-avatar :src="item.cover" /></template>
              </a-list-item-meta>
            </a-list-item>
          </template>
        </a-list>
      </a-layout-content>
    </a-layout>
  </a-layout-content>
</template>

<script lang="ts">
//要使用vue的生命周期函数,必须要导入
import { defineComponent , onMounted , ref , toRef , reactive } from 'vue';
import { StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';
import axios from 'axios';


const listData: any = [];

for (let i = 0; i < 23; i++) {
  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
  });
}

export default defineComponent({

  name: 'Home',
  components: {
    StarOutlined,
    LikeOutlined,
    MessageOutlined,
  },
  setup(){
    //使用ref的话,先要调用ref函数来声明他是一个动态的变量
    const ebook = ref();
    //使用reactive的话，则是要使用reactive函数创建一个空的对象，里面声明属性，来接受参数
    // const ebook1 = reactive({book:[]});


    const pagination = {
      onChange: (page: number) => {
        console.log(page);
      },
      pageSize: 3,
    };

    const actions: Record<string, string>[] = [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
    ];
    onMounted(() =>{
      axios.get("/ebook/list").then((res) =>{
        const data = res.data;
        ebook.value = data.content;
        // ebook1.book = data.content;

      })
    })
    return {
      ebook,
      // ebook1:toRef(ebook1 , "book"),
      listData,
      pagination,
      actions
    }

  }
});
</script>


<style scoped>
.ant-avatar {
  width: 50px;
  height: 50px;
  line-height: 50px;
  border-radius: 8%;
  margin: 5px 0;
}
</style>

