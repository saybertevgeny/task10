<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Введите ваше имя</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="blocks/breadcrumbs.jsp"/>
</div>
<span class="error">${errorMessage}</span>
<form action="person" method="post">
    <label for="firstname">Ваше имя</label>
    <input id="firstname" name="firstname" required>
    <label for="lastname">Ваша фамилия</label>
    <input id="lastname" name="lastname" required>
    <label for="middlename">Ваше отчество</label>
    <input id="middlename" name="middlename" required>
    <label for="birthday">Ваша дата рождения</label>
    <input id="birthday" name="birthday" type="date" required>
    <button>Отправить</button>
</form>
</body>
</html>
