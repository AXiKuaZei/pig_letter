<template>
<div class="register-box">

    <div class="message" th:text="${msg}"></div>

    <h1>Sign Up</h1>

    <form action="register" method="post">
        <div class="text-box">
            <i class="fa fa-user-circle" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username" required="required">
        </div>
        <div class="text-box">
            <i class="fa fa-envelope" aria-hidden="true"></i>
            <input type="text" placeholder="Email" name="email">
        </div>
        <div class="text-box">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password" name="password" required="required">
        </div>
        <div class="text-box">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password again" name="password2" required="required">
        </div>
        <input class="button" type="submit" name="submit" value="Create Account">
    </form>
    <a href="login.html">Already have one?</a>
</div>
</template>

<style>
@import url(../css/login.css);
</style>