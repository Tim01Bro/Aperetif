<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<p class="test">Test</p>
    Orders - >
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
        <a href="/AP_Main/orders/delete/${or.getId()}">Delete</a>


     </#list>
<a href="/AP_Main/checkoutorder/${userId}">GO</a>
    <script src="js/main.js"></script>

</body>
</html>