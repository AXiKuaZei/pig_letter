<template>
    <div class="login-box">
    <h1>Login</h1>
    <form action="login" method="post">
        <div class="text-box">
            <i class="fa fa-user-circle" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username" required="required">
        </div>
        <div class="text-box">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password" name="password" required="required">
        </div>
        <div class="message"></div>
        <input class="button" type="submit" name="submit" value="Sign in">
    </form>
</div>
</template>

<style>
@import url(../css/login.css);
</style>
