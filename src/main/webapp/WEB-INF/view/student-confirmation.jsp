<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Confirmation Page</title>
</head>
<body>
    The student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country: ${student.country}
    <br><br>
    Favourite Language: ${student.favouriteLanguage}
    <br><br>
    Operating Systems:
    <ul>
        <c:forEach items="${student.operatingSystems}" var="system">
            <li>${system}</li>
        </c:forEach>
    </ul>
    <br><br>
    <a href="<c:url value="/" />">Back to index page</a>
</body>
</html>