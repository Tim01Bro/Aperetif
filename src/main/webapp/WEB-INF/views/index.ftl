<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
</head>
<body>
<p id="cred">HELLONIGGA</p>
<form action="/AP_Main/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">exit</button>
</form>
<a href="#login" class="modal-inline">Открыть окно</a>

<div id="login">
    <form action="">
        <input type="text" placeholder="Name">
        <input type="text" placeholder="Phone Number">
        <input type="submit" value="send">
    </form>
</div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/jquery.fancybox.min.js"></script>
<script src="js/main.js"></script>
</html>