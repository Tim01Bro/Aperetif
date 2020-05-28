<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-registration</title>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
<span style="font-size: 30px; color: #000000;">
    <#if message??>
        ${message}
    </#if>
</span>
<form method="post" action="/AP_Main/registration">

    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Email: <input type="email" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><label> Confirm: <input type="password" name="passwordConfirm"/> </label></div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    <div><input type="submit" value="Sign In"/></div>

</form>
</body>
</html>