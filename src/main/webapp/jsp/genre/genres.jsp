<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="../../js/scriptDialog.js"></script>
    <link rel="stylesheet" href="../../css/dialogStyle.css">
    <title>Genres</title>
</head>
<body>
<h1>
    Жанры
</h1>
<div style="color: red">
    ${error}
</div>
<form action="/genre" method="post" onsubmit="return confirm('Вы уверенны?');" id="delete"></form>
<form action="/genre" method="post" id="edit"></form>
<form action="/genre" method="post" id="add"></form>
<form action="/genre" method="get" id="filter"></form>
<input type="hidden" form="delete" name="command" value="DELETE_GENRE"/>
<input type="hidden" form="edit" name="command" value="EDIT_GENRE"/>
<input type="hidden" form="add" name="command" value="ADD_GENRE"/>
<input type="hidden" form="filter" name="command" value="FILTER_GENRE"/>
<div>
    <a href="/film">Фильмы</a><br>
    <a href="/country">Страны</a><br>
    <a href="/actor">Актеры</a><br>
</div>
<div>
    <input type="text" name="nameGenreFilter">
    <button type="submit" form="filter">Фильтровать</button>
</div>
<table>
    <c:forEach var="genre" items="${genres}" varStatus="stat">
        <tr>
            <td><c:out value="${stat.index}"/></td>
            <td><c:out value="${genre.nameGenre}"/></td>
            <td>
                <button type="submit" name="id" form="delete" value="${genre.idGenre}">Удоли</button>
            </td>
            <td>
                <button type="button" name="id" onclick="openDialogEdit(${genre.idGenre})"
                        id="element${genre.idGenre}" value="${genre}">Обнови
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
            <span>Edit genre</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameEdit" name="nameGenre" form="edit"><br>
        <button type="submit" id="butEdit" name="id" form="edit">Изменить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
<div class="back-dialog" id="dialogSave">
    <div class="dialog-content">
        <div class="dialog-title">
            <span>Save genre</span>
            <a class="close-dialog" href="javascript: closedialog();">X</a>
        </div>
        Контент<br>
        <input type="text" id="nameSave" name="nameGenre" form="add"><br>
        <button type="button" onclick="this.form.submit()" name="id" id="butSave" form="add">Сохранить</button>
        <button type="button" onclick="closedialog();">Отмена</button>
    </div>
</div>
</body>
</html>
