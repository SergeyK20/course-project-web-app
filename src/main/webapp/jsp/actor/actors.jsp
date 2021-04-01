<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="../../js/scriptDialog.js"></script>
    <link rel="stylesheet" href="../../css/dialogStyle.css">
    <title>Actors</title>
</head>
<body>
<h1>
    Актеры
</h1>
<div style="color: red">
    ${error}
</div>
<form action="/actor" method="post" onsubmit="return confirm('Вы уверенны?');" id="delete"></form>
<form action="/actor" method="post" id="edit"></form>
<form action="/actor" method="post" id="add"></form>
<form action="/actor" method="get" id="filter"></form>
<input type="hidden" form="delete" name="command" value="DELETE_ACTOR"/>
<input type="hidden" form="edit" name="command" value="EDIT_ACTOR"/>
<input type="hidden" form="add" name="command" value="ADD_ACTOR"/>
<input type="hidden" form="filter" name="command" value="FILTER_ACTOR"/>
<div>
    <a href="/film">Фильмы</a><br>
    <a href="/genre">Жанры</a><br>
    <a href="/country">Страны</a><br>
</div>
<div>
    <input type="text" name="nameActorFilter">
    <button type="submit" form="filter">Фильтровать</button>
</div>
<table>
    <c:forEach var="actor" items="${actors}" varStatus="stat">
        <tr>
            <td><c:out value="${stat.index}"/></td>
            <td><c:out value="${actor.nameActor}"/></td>
            <td>
                <button type="submit" name="id" form="delete" value="${actor.idActor}">Удоли</button>
            </td>
            <td>
                <button type="button" onclick="openDialogEdit(${actor.idActor});" id="element${actor.idActor}"
                        value="${actor}">Обнови
                </button>
            </td>
            <td>
                <button type="button" name="id" onclick="openDialogSave();">Добавь</button>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="back-dialog" id="dialogEdit">
    <div class="dialog-content">
        <div class="dialog-title">
            <span>Edit actor</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameEdit" name="nameActor" form="edit"><br>
        <button type="submit" id="butEdit" name="id" form="edit">Изменить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
<div class="back-dialog" id="dialogSave">
    <div class="dialog-content">
        <div class="dialog-title">
            <span>Save actor</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameSave" name="nameActor" form="add"><br>
        <button type="button" onclick="this.form.submit()" name="id" id="butSave" form="add">Сохранить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
</body>
</html>
