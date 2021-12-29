<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Trivia</title>
    </head>

    <body>
        <h2>QUESTION</h2>
        <h5>Category: ${category}</h5>
        <h5>Difficulty: ${difficulty}</h5>
        <h5>Player: ${player}</h5>
        <h5>Question: ${question}</h5>

        <form method="post">
            <c:forEach items="${answers}" var="answer">
                <input type="radio" name="answer" value="${answer}">${answer}<br>
            </c:forEach>

            <br>
            <c:if test="${!answered}">
                <input type="submit">
            </c:if>
            <c:if test="${answered}">
                <c:if test="${end}">
                    <button type="button" onclick="window.location= '/endGame'"> Next </button>
                </c:if>
                <c:if test="${!end}">
                    <button type="button" onclick="window.location= '/question?turn=${turn}'"> Next </button>
                </c:if>
            </c:if>
        </form>

        <p <c:if test="${correct}"> style="color:green" </c:if> <c:if test="${!correct}"> style="color:red" </c:if>>
            ${message}
        </p>


    </body>

</html>