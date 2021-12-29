<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Trivia</title>
    </head>

    <body>
        <h2>TRIVIAAA!!!!!!!!!!!!!!</h2>

        <form method="post">
            <label for="player_num">Enter Number of Players:</label>
            <input type="number" id="player_num" name="player_num" required><br><br>

            <label>Choose 3 Categories for The Questions:</label><br><br>
            <select id="category1" name="category1" required>
                <option value="">Select Category</option>
                <c:forEach items="${category_lst}" var="category">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>

            <select id="category2" name="category2" required>
                <option value="">Select Category</option>
                <c:forEach items="${category_lst}" var="category">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>

            <select id="category3" name="category3" required>
                <option value="">Select Category</option>
                <c:forEach items="${category_lst}" var="category">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form>

    </body>

</html>