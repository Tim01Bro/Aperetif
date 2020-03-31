<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-favorite-wine</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
<p id="cred">HELLONIGGA</p>

<#list FavWines as fw>
      ${WineService.getWineById(fw.getIdWine()).getNameWine()}
      <a href="/AP_Main/deleteFavoriteWine/${WineService.getWineById(fw.getIdWine()).getId()}">Delete</a>
        <a href="/AP_Main/AddToCart/${WineService.getWineById(fw.getIdWine()).getId()}">AddToCart</a>
</#list>

</body>
</html>