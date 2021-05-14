<template>
  <div class="flex flex-center">
    <q-img src="../statics/img/canna.png" width="80%">
      <div class="absolute-center">
        <div class="text-white text-h2">404</div>

        <div class="text-h3" style="opacity: 0.4">页面被吃掉啦...</div>

        <div class="row justify-end">
          <q-btn
            class="q-mt-xl"
            color="white"
            text-color="blue"
            unelevated
            to="/"
            label="返回主页"
          />
        </div>
      </div>
    </q-img>
  </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "Error404",
});
</script>
