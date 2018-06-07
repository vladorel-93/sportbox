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
        <tr>
            <th>
                Team
            </th>
            <th>photo</th>
        </tr>
    <c:forEach var="team" items="${sessionScope.teams}">
    <tr>
        <td>${team.name}</td>
        <td>
            <img src="${pageContext.request.contextPath}/resources/images/${team.photo}"/>
        </td>
    </tr>
    </c:forEach>
</table>
<a href="newTeam">Add one more team</a>
</body>
</html>