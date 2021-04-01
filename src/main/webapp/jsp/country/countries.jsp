<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="../../js/scriptDialog.js"></script>
    <link rel="stylesheet" href="../../css/dialogStyle.css">
    <title>Countries</title>
</head>
<body>
<h1>
    Страны
</h1>
<div style="color: red">
    ${error}
</div>
<form action="/country" method="post" onsubmit="return confirm('Вы уверенны?');" id="delete"></form>
<form action="/country" method="post" id="edit"></form>
<form action="/country" method="post" id="add"></form>
<form action="/country" method="get" id="filter"></form>
<input type="hidden" form="delete" name="command" value="DELETE_COUNTRY"/>
<input type="hidden" form="edit" name="command" value="EDIT_COUNTRY"/>
<input type="hidden" form="add" name="command" value="ADD_COUNTRY"/>
<input type="hidden" form="filter" name="command" value="FILTER_COUNTRY"/>
<div>
    <a href="/film">Фильмы</a><br>
    <a href="/genre">Жанры</a><br>
    <a href="/actor">Актеры</a><br>
</div>
<div>
    <input type="text" name="nameCountryFilter">
    <button type="submit" form="filter">Фильтровать</button>
</div>
<table>
    <c:forEach var="country" items="${countries}" varStatus="stat">
        <tr>
            <td><c:out value="${stat.index}"/></td>
            <td><c:out value="${country.nameCountry}"/></td>
            <td>
                <button type="submit" name="id" form="delete" value="${country.idCountry}">Удоли</button>
            </td>
            <td>
                <button type="button" name="id" onclick="openDialogEdit(${country.idCountry})"
                        id="element${country.idCountry}" value="${country}">Обнови
                </button>
            </td>
            <td>
                <button type="button" name="id" onclick="openDialogSave()">Добавь</button>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="back-dialog" id="dialogEdit">
    <div class="dialog-content">
        <div class="dialog-title">
            <span>Edit country</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameEdit" name="nameCountry" form="edit"><br>
        <button type="submit" id="butEdit" name="id" form="edit">Изменить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
<div class="back-dialog" id="dialogSave">
    <div class="dialog-content">
        <div class="dialog-title">
            <span>Save country</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameSave" name="nameCountry" form="add"><br>
        <button type="button" onclick="this.form.submit()" name="id" id="butSave" form="add">Сохранить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
</body>
</html>
