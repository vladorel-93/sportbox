<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Upcoming games</title>
    <script>
        var i = 0;
        var bets = [];
        function makePrediction(homeTeam,  awayTeam )
        {bets[i++] = {homeTeam: homeTeam, awayTeam: awayTeam, result: result};}
    </script>

</head>
<body>
<form action="/bets" method="post">
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
                    <select onselect="makePrediction(match.homeTeam, match.awayTeam)" name="result">
                        <option>${match.homeTeam}</option>
                        <option>${match.awayTeam}</option>
                        <option>Ничья</option>
                    </select>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Save</button>
</form>
</body>
</html>

