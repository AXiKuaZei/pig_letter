<template>
  <q-page class="flex flex-top">
    <q-parallax height="700" >

      <template v-slot:media>
        <img  height="700" src="../../statics/img/SpiritedAway.png">
      </template>

      <template v-slot:content >
        <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-pa-md q-gutter-y-md bg-blue-grey-2"
      >
        <div class="text-center text-h5 q-mb-lg">登 录</div>

        <q-input
          filled
          v-model="name"
          placeholder="请输入用户名或邮箱"
          lazy-rules
          :rules="usernameRules"
        >
          <template v-slot:prepend>
            <q-icon name="account_circle" />
          </template>
          <template v-slot:append>
            <q-icon
              name="close"
              @click="username = ''"
              class="cursor-pointer"
            />
          </template>
        </q-input>

        <q-input
          filled
          :type="isPwd ? 'password' : 'text'"
          v-model="age"
          placeholder="请输入密码"
          lazy-rules
          :rules="passwordRules"
        >
          <template v-slot:prepend>
            <q-icon name="lock" />
          </template>
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              @click="isPwd = !isPwd"
              class="cursor-pointer"
            />
          </template>
        </q-input>

        <div align="center" class="q-mt-xl">
          <q-btn
            flat
            label="没有帐号？去注册"
            color="primary"
            class="q-mr-lg"
          />
          <q-btn label="登录" type="submit" color="primary" />
        </div>
      </q-form>
      </template>
    </q-parallax>
  </q-page>
</template>

<script>
import { defineComponent, ref, onMounted } from "vue";
import { useRouter } from 'vue-router';

export default defineComponent({
  name: "login",

  setup() {
    const username = ref("")
    const password = ref("")
    const isPwd = ref(true)    

    return {
      username,
      password,
      isPwd,
      usernameRules: [
        (val) => (val && val.length > 0) || "用户名或邮箱不得为空",
      ],
      passwordRUles: [(val) => (val && val.length > 0) || "密码不得为空"],
    };
  },
});
</script>

<style scoped>
.q-page {
  background-color: #6daea7;
}

.q-form {
  width: 500px;
}
</style>
