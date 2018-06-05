<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Home page</h1>
<s:form method="post" modelAttribute="team" enctype="multipart/form-data" action="/save">
<table>
    <tr>
        <td>
            Team
        </td>
        <td>
            <s:input path="name"/>
        </td>
    </tr>
    <tr>
        <td>Photo</td>
        <td>
            <input type="file" name="file"/>
        </td>
    </tr>
    <tr>
        <td>&nbsp</td>
        <td>
            <input type="submit" value="save">
        </td>
    </tr>
</table>
</s:form>
</body>
</html>