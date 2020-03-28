<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-About-Us</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
<p id="cred">HELLONIGGA</p>
<form method="post" action="/AP_Main/checkoutorder/check/${userId}">
    <input name="firstName">
    <input name="lastName">
    <input name="companyName">
    <input name="country">
    <input name="StreetAddress">
    <input name="city">
    <input name="postCode">
    <input name="phone">
    <input name="email">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Checko</button>
</form>
<#list ordersUser as or>
    <#if wineService.getWineById(or.getWineId()).getNameWine()??>
        ${wineService.getWineById(or.getWineId()).getNameWine()}
    </#if>
    <#if wineService.getWineById(or.getWineId()).getDescribe()??>
        ${wineService.getWineById(or.getWineId()).getDescribe()}
    </#if>
    <#if wineService.getWineById(or.getWineId()).getPrice()??>
        <span>Price${wineService.getWineById(or.getWineId()).getPrice()}</span>
    </#if>
</#list>
</html>