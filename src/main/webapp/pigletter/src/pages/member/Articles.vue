<template>
    <q-page class="flex flex-center">
      <div class="q-pa-md">
        <q-table
          :rows="rows"
          :columns="columns"
          row-key="id"
          :selected-rows-label="getSelectedString"
          selection="multiple"
          v-model:selected="selected"
          v-model:pagination="pagination"
          :rows-per-page-options="rowsPerPageOptions"
          >

          <template v-slot:top>
            <q-btn 
              color="green" 
              label="写文章" 
              icon="add"
              to="/workspace/write" 
            />
            <q-btn 
              class="q-ml-sm" 
              color="red"
              label="删除"
              @click="deleteAll"
              icon="delete_forever"
            />
            <q-space />
            <q-input dense debounce="300" color="primary" v-model="filter" placeholder="搜索">
              <template v-slot:append>
                <q-icon name="search" />
              </template>
            </q-input>
          </template>

          <template v-slot:body-cell-isPrivate="props">
              <q-td :props="props">
                <q-btn flat round >
                  <q-icon  v-if="props.value"  name="lock" size="1.5em" />
                  <q-icon  v-else name="lock_open" size="1.5em" />
                </q-btn>
              </q-td>
          </template>

          <template v-slot:body-cell-manipulation="props">
              <q-td key="manipulation" :props="props">
                <q-btn flat round >
                  <q-icon color="primary" name="edit" size="1.5em" />
                </q-btn>
                <q-btn flat round >
                  <q-icon color="red" name="delete" size="1.5em" />
                </q-btn>
              </q-td>
          </template>

          <template v-slot:bottom="scope">

            <span class="q-mr-md">
              {{ pageLabel }}
            </span>
      
            <q-select 
            dense 
            outlined 
            v-model="pagination.rowsPerPage" 
            :options="rowsPerPageOptions" 
            :option-label="(item) => item === 0 ? 'All' : item"/>
      
            <q-space />

            <q-pagination
              v-model="pagination.page"
              :max="scope.pagesNumber"
              icon-first="skip_previous"
              icon-last="skip_next"
              icon-prev="fast_rewind"
              icon-next="fast_forward"
              :max-pages="5"
              direction-links
              boundary-links
              push
              dense
              color="teal"
            />
          </template>

        </q-table>
      </div>
      <div class="q-mt-md">
        Selected: {{ JSON.stringify(selected) }}
      </div>
    </q-page>
  </template>

<script>
  import { defineComponent, ref } from 'vue';

  const columns = ref([
    {
      name: 'index',
      label: '#',
      field: 'index'
    },
    {
      name: 'title',
      required: true,
      label: '标题',
      align: 'left',
      field: row => row.title,
      format: val => `${val}`,
      sortable: true
    },
    { 
      name: 'publishTime', 
      align: 'center', 
      label: '发布时间', 
      field: 'publishTime', 
      sortable: true 
    },
    { 
      name: 'lastUpdatedTime', 
      align: 'center',
      label: '修改时间', 
      field: 'lastUpdatedTime', 
      sortable: true 
    },
    { 
      name: 'stars', 
      align: 'center',
      label: '收到的星星', 
      field: 'stars', 
      sortable: true 
    },
    { 
      name: 'isPrivate', 
      align: 'center',
      label: '私密', 
      field: 'isPrivate', 
      sortable: true 
    },
    { 
      name: 'manipulation', 
      align: 'center',
      label: '操作', 
      field: '', 
    }
  ])
  
  const rows = ref([
    {
      index: 1,
      id: 1,
      title: '第一篇',
      publishTime: '2021/10/1',
      lastUpdatedTime: '2021/10/1',
      stars: 0,
      content: '啦啦啦啦啦啦',
      isPrivate: false
    },
    {
      index: 2,
      id: 2,
      title: '第二篇',
      publishTime: '2021/10/5',
      lastUpdatedTime: '2021/10/1',
      stars: 0,
      content: '啦啦啦啦啦啦',
      isPrivate: false
    },
    {
      index: 3,
      id: 3,
      title: '第二篇',
      publishTime: '2021/10/6',
      lastUpdatedTime: '2021/10/1',
      stars: 0,
      content: '啦啦啦啦啦啦',
      isPrivate: false
    },
    {
      index: 4,
      id: 4,
      title: '第二篇',
      publishTime: '2021/10/7',
      lastUpdatedTime: '2021/10/1',
      stars: 1,
      content: '优点东西',
      isPrivate: true
    },
    {
      index: 5,
      id: 5,
      title: '第二篇',
      publishTime: '2021/10/2',
      lastUpdatedTime: '2021/10/1',
      stars: 2,
      content: '啦啦啦啦啦啦',
      isPrivate: true
    },
    {
      index: 6,
      id: 6,
      title: '第二篇',
      publishTime: '2021/11/11',
      lastUpdatedTime: '2021/10/1',
      stars: 5,
      content: '啦啦啦啦啦啦',
      isPrivate: true
    },
    {
      index: 7,
      id: 7,
      title: '第7篇',
      publishTime: '2021/11/11',
      lastUpdatedTime: '2021/10/1',
      stars: 5,
      content: '啦啦啦啦啦啦',
      isPrivate: true
    }
  ])
  
  export default defineComponent({
    name: 'articles',

    setup () {
      const selected = ref([]) 
      const filter = ref('')
      const pageLabel = ref('每页数量')
      const rowsPerPageOptions = ref([
        5, 10, 20, 30, 50, 0
      ])
      const pagination = ref({
        sortBy: 'desc',
        descending: false,
        page: 1,
        rowsPerPage: 10
      })

      return {
        selected,
        columns,
        rows,
        pageLabel,
        pagination,
        rowsPerPageOptions,

        getSelectedString () {
          return selected.value.length === 0 ? '' : `${selected.value.length} record${selected.value.length > 1 ? 's' : ''} selected of ${rows.value.length}`
        }
      }
    }
  })
  </script>