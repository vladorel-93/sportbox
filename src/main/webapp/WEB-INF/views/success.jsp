<%@page contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        img{height: 100px; width: auto}
    </style>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="1">
    <c:forEach var="team" items="repository">
        <tr>
            <td>
                Team
            </td>
            <td>${team.name}</td>
        </tr>
        <tr>
            <td>Position</td>
            <td>${team.id}</td>
        </tr>
        <tr>
            <td>photo</td>
            <td>
                <img src="${pageContext.request.contextPath}/resources/images/${team.photo}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="newTeam">Add one more team</a>
</body>
</html>