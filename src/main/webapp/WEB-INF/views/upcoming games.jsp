<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Upcoming games</title>
</head>
<body>
<table cellspacing="2" cellpadding="2" border="1">
    <tr>
        <th>Date and time</th>
        <th>Home team</th>
        <th>Away team</th>
    </tr>
    <c:forEach items="${sessionScope.matches}" var="match">
        <tr>
            <td>${match.Date_Time}</td>
            <td>${match.homeTeam}</td>
            <td>${match.awayTeam}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

