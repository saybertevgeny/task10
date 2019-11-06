<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Введите адрес</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <div>
        <jsp:include page="blocks/breadcrumbs.jsp"/>
    </div>
    <span class="error">${errorMessage}</span>
    <form action="address" method="post">
        <label for="street">Пользователь</label>
        <select name="person" required>
            <c:forEach items="${requestScope.persons}" var="person">
                <option value="${person.id}">${person.firstName}</option>
            </c:forEach>
        </select>
        <label for="street">Улица</label>
        <input id="street" name="street" required >
        <label for="house">дом</label>
        <input id="house" name="house" required>
        <label for="flat">квартира</label>
        <input id="flat" name="flat" required>
        <button>Отправить</button>
    </form>
</body>
</html>
