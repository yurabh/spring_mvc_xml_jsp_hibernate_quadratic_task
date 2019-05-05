<%--
  Created by IntelliJ IDEA.
  User: Юрій
  Date: 05.05.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IndexPage</title>
</head>
<body style="background-color: cadetblue">

<div align="center" style=margin:12%>
    <h2>Quadratic Information </h2>
    <form:form method="POST" action="/addCof">
        <table>
            <tr>
                <td><form:label path="a">Enter coefficient A</form:label></td>
                <td><form:input path="a"/></td>
            </tr>
            <tr>
                <td><form:label path="b">Enter coefficient B</form:label></td>
                <td><form:input path="b"/></td>
            </tr>
            <tr>
                <td><form:label path="c">Enter coefficient C</form:label></td>
                <td><form:input path="c"/></td>
            </tr>
            <tr>
                <td colspan="2" style="margin-right: 20px">
                    <input type="submit" value="Сalculate"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
