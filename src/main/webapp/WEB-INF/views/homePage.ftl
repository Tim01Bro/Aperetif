<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aperetif</title>
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
</body>
</html>