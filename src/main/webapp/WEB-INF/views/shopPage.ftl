<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-shop-list</title>
</head>
<body>
<#list Wines as wn>
    <#if wn.getFilename()??>
    <img src="img/${wn.getFilename()}" width="40" height="100">

    </#if>
</#list>

<form action="/AP_Main/filter" method="post">
    <label>
        NameWine<input name="filter"/>
    </label>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">find</button>
</form>
</body>
</html>