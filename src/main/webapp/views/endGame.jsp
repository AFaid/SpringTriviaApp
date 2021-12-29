<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Trivia</title>
    </head>

    <body>

        <h2>WINNERS</h2>
        <c:forEach items="${winners}" var="winner">
          <h4>${winner}</h4>
        </c:forEach>

        <h2>SCORES</h2>
        <c:forEach items="${players}" var="player">
            <p>${player.getNickname()}: ${player.getScore()}</p>
        </c:forEach>

    </body>

</html>