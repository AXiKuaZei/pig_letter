  <template>
    <q-toolbar class="q-pa-sm">

      <span class="q-mr-md">
        {{ paginationLabel }}
      </span>

      <q-select dense outlined v-model="itemNum" :options="numsPerPage" />

      <q-space />

      <q-pagination
        v-model="currentPage"
        :max="maxPage"
        direction-linkscurrentPage
        boundary-links
      />
      
    </q-toolbar>
  </template>

  <script>
    import { defineComponent, ref } from 'vue'
    
    const numsPerPage = ref([
        10, 20, 30, 50, 'All'
    ])

    const itemNum = ref(10)

    const currentPage = ref(1)


    export default defineComponent({
      name: 'pagination',
      props: {
        paginationLabel: {
          type: String,
          default: '每页数量'
        },
        maxPage: {
          type: Number,
          default: 5
        }
      },

      setup(){
        return {
          numsPerPage,
          itemNum,
          currentPage
        }
      }
    })
  </script>

  <style>
      
  </style>