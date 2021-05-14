<template>
  <q-page class="flex flex-top">
    <q-img src="../../statics/img/HowlsMovingCastle.png">
      <div class="absolute-center transparent">
        <q-form
          @submit="onSubmit"
          @reset="onReset"
          class="q-pa-md q-gutter-y-sm bg-blue-grey-2 text-dark"
        >
          <div class="text-center text-h5 q-mb-lg">注 册</div>

          <q-banner
            rounded
            dense
            inline-actions
            :class="
              available ? 'bg-green-2 text-green-7' : 'bg-red-2 text-red-7 '
            "
          >
            {{
              available
                ? "恭喜！用户名/昵称未被注册！"
                : "抱歉！用户名/昵称已被注册"
            }}
            <q-icon
              v-if="available"
              size="sm"
              name="sentiment_satisfied_alt"
              color="green-7"
            />
            <q-icon
              v-else
              size="sm"
              name="sentiment_very_dissatisfied"
              color="red-7"
            />
            <template v-slot:action>
              <q-icon
                size="sm"
                name="close"
                color="primary"
                class="cursor-pointer"
              />
            </template>
          </q-banner>

          <q-input
            filled
            v-model="username"
            placeholder="请输入用户名/昵称"
            :rules="usernameRules"
            lazy-rules
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
            v-model="password"
            placeholder="请输入密码"
            :rules="passwordRules"
            lazy-rules
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

          <q-input
            filled
            :type="isPwdCheck ? 'password' : 'text'"
            v-model="passwordCheck"
            placeholder="请再次输入密码"
            :rules="passwordCheckRules"
            lazy-rules
          >
            <template v-slot:prepend>
              <q-icon name="lock" />
            </template>
            <template v-slot:append>
              <q-icon
                :name="isPwdCheck ? 'visibility_off' : 'visibility'"
                @click="isPwdCheck = !isPwdCheck"
                class="cursor-pointer"
              />
            </template>
          </q-input>

          <q-input
            filled
            type="email"
            v-model="mail"
            placeholder="请输入邮箱"
            :rules="mailRules"
            lazy-rules
          >
            <template v-slot:prepend>
              <q-icon name="mail" />
            </template>
            <template v-slot:append>
              <q-icon name="close" @click="mail = ''" class="cursor-pointer" />
            </template>
          </q-input>

          <div align="center">
            <q-btn
              flat
              label="已有帐号？去登录"
              to="/account/login"
              color="primary"
              class="q-mr-lg"
            />
            <q-btn label="注册" type="submit" color="primary" />
          </div>
        </q-form>
        <div align="center" class="q-mt-md">
          <router-link to="/" class="q-mt-lg text-white center"
            >回首页逛逛</router-link
          >
        </div>
      </div>
    </q-img>
  </q-page>
</template>

<script>
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "login",

  setup() {
    const username = ref("");
    const password = ref("");
    const passwordCheck = ref("");
    const mail = ref("");
    const available = ref(true);
    const isPwd = ref(true);
    const isPwdCheck = ref(true);

    return {
      username,
      password,
      passwordCheck,
      mail,
      available,
      isPwd,
      isPwdCheck,
      usernameRules: [
        (val) => (val && val.length > 0) || "用户名/昵称不得为空",
        (val) => val.length <= 12 || "用户名/昵称长度不得超过12个字符",
      ],
      passwordRules: [
        (val) => val.length !== 0 || "密码不得为空",
        (val) =>
          (val.length >= 8 && val.length <= 16) ||
          "密码长度需大于8个字符且不得超过16个字符",
      ],
      passwordCheckRules: [
        (val) => val === password.value || "两次输入的密码不一致",
      ],
      mailRules: [
        (val) => (val && val.length > 0) || "邮箱不得为空",
        (val) =>
          (function () {
            let pattern =
              /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/g;
            return pattern.test(val);
          })() || "请输入正确的邮箱格式",
      ],
    };
  },
});
</script>

<style scoped>
.q-page {
  background-color: #0655b7;
}

.q-form {
  width: 500px;
}
</style>
