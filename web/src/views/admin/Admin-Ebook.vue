<template>
  <a-layout>
    <a-layout-content
      :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
  >
    <a-table
        :columns="columns"
        :row-key="record => record.id"
        :data-source="ebooks"
        :pagination="pagination"
        :loading="loading"
        @change="handleTableChange"
    >
      <template #cover="{ text: cover }">
        <img v-if="cover" :src="cover" alt="avatar"/>
      </template>
      <template v-slot:action="{ text, record }">
        <a-space size="small">
          <a-button type="primary">
            编辑
          </a-button>
          <a-button type="danger">
            删除
          </a-button>
        </a-space>
      </template>
    </a-table>
  </a-layout-content>
  </a-layout>

</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from 'axios';

export default defineComponent({
  name: 'AdminEbook',
  setup() {
    const ebooks = ref();
    const pagination = ref({
      current: 1,
      pageSize: 2,
      total: 0
    });
    const loading = ref(false);

    const columns = [
      {
        title: '封面',
        dataIndex: 'cover',
        slots: {customRender: 'cover'}
      },
      {
        title: '名称',
        dataIndex: 'name'
      },
      {
        title: '分类一',
        key: 'category1Id',
        dataIndex: 'category1Id'
      },
      {
        title: '分类二',
        dataIndex: 'category2Id'
      },
      {
        title: '文档数',
        dataIndex: 'docCount'
      },
      {
        title: '阅读数',
        dataIndex: 'viewCount'
      },
      {
        title: '点赞数',
        dataIndex: 'voteCount'
      },
      {
        title: 'Action',
        key: 'action',
        slots: {customRender: 'action'}
      }
    ];

    /**
     * 数据查询
     **/
    const handleQuery = (params: any) => {
      console.log(params);
      console.log(params.page + " " + params.size);

      loading.value = true;
      //调用axios方法，去请求后端的接口
      axios.get("/ebook/list", {
        params: {
          //将参数展开,需要传几个参数，则用几个参数,减少性能消耗
          page: params.page,
          size: params.size
        }
      }).then((response) => {
        //请求成功之后,将响应的data赋值给data，ebooks的value为data的content
        loading.value = false;
        const data = response.data;
        ebooks.value = data.content.respList;

        // 重置分页按钮
        pagination.value.current = params.page;
        pagination.value.total = data.content.page;
      });
    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥："+ pagination);
      handleQuery({
        page: 1,
        size: pagination.pageSize
      });
    };

    onMounted(() => {
      handleQuery({
        page: 1,
        size: pagination.value.pageSize
      });
    });

    return {
      ebooks,
      pagination,
      columns,
      loading,
      handleTableChange
    }
  }
});
</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>