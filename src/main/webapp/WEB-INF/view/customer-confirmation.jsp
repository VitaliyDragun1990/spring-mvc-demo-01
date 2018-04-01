<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Confirmation</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
Free passes: ${customer.freePasses}
<c:if test="${customer.postalCode != null}">
    <br><br>
    Postal Code: ${customer.postalCode}
</c:if>
<c:if test="${customer.courseCode != null}">
    <br><br>
    Course Code: ${customer.courseCode}
</c:if>
<br><br>
<a href="<c:url value="/" />">Back to Index page</a>
</body>
</html>