<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/scriptAddAndEditFilm.js"></script>
    <title>Add and edit</title>
</head>
<body>
<h1>Add film</h1>
<form action="/film" method="post" id="add"></form>
<form action="/film" method="get" id="main"></form>
<div style="width: 800px; margin: 0 auto;">
    <div>
        Название фильма
        <input type="text" name="nameFilm" style="width: 100%" form="add">
    </div>
    <div>
        Дата выхода фильма
        <input type="text" name="releaseDate" style="width: 100%" form="add">
    </div>
    <div>
        Рейтинг
        <input type="text" name="rating" style="width: 100%" form="add">
    </div>
    <div>
        Сборы
        <input type="text" name="collection" style="width: 100%" form="add">
    </div>
    <div>
        <select multiple id="idActor" onchange="addTextActor()" >
            <c:forEach var="actor" items="${actors}">
                <option selected value="${actor.idActor}">${actor.nameActor}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenActor" name="actor" form="add">
        Актеры
        <input type="text" readonly id="idTextActor" name="nameFilm" style="width: 100%">
    </div>
    <div>
        <select multiple id="idGenre" onchange="addTextGenre()">
            <c:forEach var="genre" items="${genres}">
                <option selected value="${genre.idGenre}">${genre.nameGenre}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenGenre" name="genre" form="add">
        Жанры
        <input type="text" readonly id="idTextGenre" name="nameFilm" style="width: 100%">
    </div>
    <div>
        <select multiple  id="idCountry" onchange="addTextCountry()">
            <c:forEach var="country" items="${countries}">
                <option selected value="${country.idCountry}">${country.nameCountry}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenCountry" name="country" form="add">
        Страны
        <input type="text" readonly id="idTextCountry" name="nameFilm" style="width: 100%">
    </div>
</div>
<button type="submit" form="add">Добавить</button>
<button type="submit" form="main">На главную</button>
<input type="hidden" name="command" value="GET_FILM" form="main">
<input type="hidden" name="command" value="ADD_FILM" form="add">

</body>
</html>
