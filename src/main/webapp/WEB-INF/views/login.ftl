<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/AP_Main/login">

    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    <div><input type="submit" value="Sign In"/></div>

</form>

</body>
</html>