<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <title>Customer Registration Form</title>
</head>
<body>

<i>Fill out the form . Asterisk (&ast;) means required.</i>
<br><br>

<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName" />
    <br><br>
    Last name (&ast;): <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />
    <br><br>
    Free passes (&ast;): <form:input path="freePasses" />
    <form:errors path="freePasses" cssClass="error" />
    <br><br>
    Postal Code: <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error" />
    <br><br>
    Course Code: <form:input path="courseCode" />
    <form:errors path="courseCode" cssClass="error" />
    <br><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>