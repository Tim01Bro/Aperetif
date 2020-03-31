<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-Home</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
    <p id="cred">HELLONIGGA</p>
    <#list Wine as wn>
        ${wn.getDateAdded()}
    </#list>
    <#list Events as ev>
        ${ev.getEventDetails().getCostEvent()}
    </#list>
    <a href="/AP_Main/aboutus">about us</a>
    <a href="#feedback" rel="nofollow" class="modalbox">Обратная связь</a>

    <div id="feedback" style="display:none "><!-- hidden inline form -->
        <h2>Отправка сообщения</h2>
        <form id="f_contact" name="contact" action="#" method="post">
            <label for="f_name">Ваше имя</label><br>
            <input type="text" id="f_name" name="f_name"><br>
            <label for="f_email">Ваш E-mail</label><br>
            <input type="text" id="f_email" name="f_email"><br>
            <label for="f_msg">Введите сообщение</label><br>
            <textarea id="f_msg" name="f_msg" class="txtarea"></textarea>
            <button id="f_send">Отправить E-mail</button>
        </form>
    </div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/jquery.fancybox.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".modalbox").fancybox();

    });
</script>
</html>