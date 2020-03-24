<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<p id="cred">HELLONIGGA</p>
<form action="/AP_Main/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">exit</button>
</form>
</body>
</html>