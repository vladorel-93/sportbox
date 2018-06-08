<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Upcoming games</title>
    <script>
        var i = 0;
        var bets = [];
        function makePrediction(homeTeam,  awayTeam )
        {
            bets[i++] = {homeTeam: homeTeam, awayTeam: awayTeam, result: result};
        }
    </script>
</head>
<body>
<form action="/bets" method="post">
    <table cellspacing="2" cellpadding="2" border="1">
        <tr>
            <th>Date and time</th>
            <th>Home team</th>
            <th>Away team</th>
            <th>Make prediction</th>
        </tr>
        <c:forEach items="${sessionScope.matches}" var="match">
            <tr>
                <td>${match.Date_Time}</td>
                <td>${match.homeTeam}</td>
                <td>${match.awayTeam}</td>
                <td>
                    <select onselect="makePrediction(match.homeTeam, match.awayTeam)" name="result">
                        <option>${match.homeTeam}</option>
                        <option>${match.awayTeam}</option>
                        <option>Draw</option>
                    </select>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Save bets</button>
</form>
</body>
</html>

