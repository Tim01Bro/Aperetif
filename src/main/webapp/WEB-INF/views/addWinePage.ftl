<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif-add-wine</title>
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

</head>
<body>
    <form action="/AP_Main/adminPage/addWine" method="post">
        <input name="nameWine">
        <input name="rating">

        <input name="typeWines">

        <input name="describe">

        <input name="quantity">
        <input name="price">

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button type="submit" value="Save">SAVE</button>

    </form>
</body>
</html>