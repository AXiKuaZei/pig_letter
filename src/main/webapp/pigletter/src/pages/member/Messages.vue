<template>
  <q-page class="flex flex-center">
    <q-img src="../../statics/img/CellsAtWork.png" width="80%" >
      <div class="text-white text-h3 absolute-center">
        页面仍在施工中...
      </div>
    </q-img>
  </q-page>
</template>

<script>
import { defineComponent } from "vue";
import underConstruction from 'components/UnderConstruction.vue'

export default defineComponent({
  name: "messages",
});

components: {
      underConstruction
  }
</script>

<style scoped>
  .q-page {
    background-color: #f87554;
  }
</style>
