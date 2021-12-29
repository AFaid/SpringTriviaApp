<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Trivia</title>
    </head>

    <body>
        <h2>Create players</h2>
        <form method="post">
            <c:forEach begin="1" end="${player_num}" var="i">
                <label for="player${i}_nickname">Enter Player ${i} name:</label>
                <input type="text" id="player${i}_nickname" name="player${i}_nickname"><br><br>
            </c:forEach>

            <input type="submit">
        </form>

        <h2>RULES!!!!!!!!!!!!!!</h2>
        <ul>
          <li>Each player will get a total of 5 multiple choice questions from each category</li>
          <li>The 5 questions will contain 3 easy questions, 1 medium questions and 1 hard question</li>
          <li>Answering an easy question rewards 1 point</li>
          <li>Answering a medium questions rewards 3 points</li>
          <li>Answering a hard question rewards 5 points</li>
          <li>The player with the most points wins the game</li>
        </ul>

    </body>

</html>