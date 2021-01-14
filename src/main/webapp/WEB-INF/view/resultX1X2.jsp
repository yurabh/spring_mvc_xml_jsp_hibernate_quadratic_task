<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>resultX1X2Page</title>
</head>

<body style="background-color: darkgray">

<div align="center" style="margin:10%">

    <h3>Result of Root X1 and X2</h3>

    <table>
        <tr>
            <td>Coefficient a</td>
            <td>${a}</td>
        </tr>
        <tr>
            <td>Coefficient b</td>
            <td>${b}</td>
        </tr>
        <tr>
            <td>Coefficient c</td>
            <td>${c}</td>
        </tr>

        <tr>
            <td>The root of the equation x1</td>
            <td>${x1}</td>
        </tr>

        <tr>
            <td>The root of the equation x2</td>
            <td>${x2}</td>
        </tr>
    </table>

</div>
</body>
</html>
