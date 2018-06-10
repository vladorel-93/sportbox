<%@page contentType="text/html; ISO-8859-1" %>
<html>
<head>
    <title>Teams</title>
</head>
<body>
<h5>Hello! Select a date to see upcoming matches</h5>
<a href="/newTeam">Add new team</a>
<p>
    <form action="show_upcoming_games">
    <input type="date" name="calendar"/>
    <input type="submit" name="submit" value="/show_upcoming_games"/>
</form>

</p>
</body>
</html>