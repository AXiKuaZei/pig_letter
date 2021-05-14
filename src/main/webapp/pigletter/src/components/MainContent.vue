<template>
    <div class="
    column 
    items-end
    q-pa-md
    q-gutter-md
    bg-grey-3">
        <q-card v-for="x in 5" :key="x">
          <q-card-section>
             <div class="text-h6">title</div>
          </q-card-section>

          <q-card-section>
            {{ x }} content
        </q-card-section>

          <q-separator inset/>
    
          <q-card-actions >
            <q-btn 
            flat
            label="展开全文"
            icon="expand_more"
            ></q-btn>
          </q-card-actions>
          
        </q-card>
      </div>
</template>

<script>
import { defineComponent, ref } from 'vue'

export default defineComponent({
    name: 'MainContent'
})

</script>

<style scoped>
    .q-card {
    width: 770px;
    min-height: 200px;
    max-height: 400px;
  }

  body {
      min-width: 800px;
  }
</style>