<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-shop-list</title>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
<#list Wines as wn>
    <#if wn.getFilename()??>
    <img src="img/${wn.getFilename()}" width="40" height="100">
    <a href="/AP_Main/addtoFavorite/${wn.getId()}">Add</a>
    <a href="/AP_Main/GetCurrentWine/${wn.getId()}">More</a>
    <a href="/AP_Main/addToOrder/${wn.getId()}">Order</a>
    </#if>
</#list>
<#list TypeWine as tw>
    <#if tw.getName()??>
        <a href="/AP_Main/getAllWineByType/${tw.getName()}">${tw.getName()}</a>
    </#if>
</#list>
<a href="/AP_Main/shoplist">All</a>

<form method="post" action="/AP_Main/getAllByPrice">
<label>
    ЦЕНА<input type="range" name="rangePrice" min="1" max="25" value="1" />
</label>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">find</button>
</form>
<form action="/AP_Main/filter" method="post">
    <label>
        NameWine<input name="filter"/>
    </label>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">find</button>
</form>
</body>
</html>