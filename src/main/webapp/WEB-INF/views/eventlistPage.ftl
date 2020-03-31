<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-event-list</title>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
    <#list eventList as el>
        Time:${eventDetailsService.getEventById(el.getEventDetailsId()).getDateStart()}
        <a href="/AP_Main/eventList/${el.getId()}">Get1</a>
    </#list>

    <form action="/AP_Main/findEventByName" method="post">
        <input name="filter">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">find</button>
    </form>

</body>
</html>