<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

    <title>Upcoming games</title>
    <script>
        var i = 0;
        var bets = [];
        function makePrediction(homeTeam,  awayTeam )
        {bets[i++] = {homeTeam: homeTeam, awayTeam: awayTeam, result: result};}
    </script>

</head>
<body>
    <table cellspacing="2" cellpadding="2" border="1">
        <tr>
            <th>Date</th>
            <th>Home Team</th>
            <th>Away Team</th>
            <th>Make prediction</th>
        </tr>
        <c:forEach items="${sessionScope.matches}" var="match">
            <tr>
                <td>${match.data}</td>
                <td>${match.homeTeam}</td>
                <td>${match.awayTeam}</td>
                <td>
                    <form action="/bets/{home}/{away}/{result}" method="post">
                        <input list="Results" name="result">
                        <datalist id="Results">
                            <option value="${match.homeTeam}" name="home">
                            <option value="${match.awayTeam}" name="away">
                            <option value="Ничья">
                        </datalist>
                        <input type="submit">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

