<template>
    <q-page class="flex justify-center">
      <q-form>
        <q-toolbar>
          <q-btn 
          color="orange" 
          label="保存为草稿" 
          icon="save"
          />
          <q-space />
          <q-btn
          :disable="title.length===0 || title.length>50"
          type="submit"
          color="green" 
          label="发布" 
          icon="publish"
          />
        </q-toolbar>

        <q-input 
        outlined 
        v-model="title" 
        placeholder="请输入标题（少于50个字）"
        class="q-ma-md"
        >
          <template v-slot:append>
            <q-icon name="close" @click="title = ''" class="cursor-pointer" />
          </template>
        </q-input>

        <q-editor v-model="editor"/>

      </q-form>
    </q-page>
</template>

<script>
import { defineComponent, ref } from 'vue';

export default defineComponent({
  name: 'write',

  setup () {
    const title = ref('')

    return {
      title,
      editor: ref('What you see is <b>what</b> you get.')
    }
  }
})
</script>

<style scoped>
  .q-form { 
    min-width: 800px;
  }
  .q-editor {
    height: 100%;
  } 

</style>
