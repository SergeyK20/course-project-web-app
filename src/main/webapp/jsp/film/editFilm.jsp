<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/scriptAddAndEditFilm.js"></script>
    <title>Add</title>
</head>
<body>
<h1>Edit film</h1>
<form action="/film" method="post" id="edit"></form>
<form action="/film" method="get" id="main"></form>


<input type="hidden" id="idFilm" value="${currentFilm.idFilm}">
<input type="hidden" id="currentActors" value="${currentFilm.actors}">
<input type="hidden" id="currentGenres" value="${currentFilm.genres}">
<input type="hidden" id="currentCountries" value="${currentFilm.countries}">

<div style="width: 800px; margin: 0 auto;">
    <div>
        Название фильма
        <input type="text" name="nameFilm" style="width: 100%" form="edit" value="${currentFilm.nameFilm}">
    </div>
    <div>
        Дата выхода фильма
        <input type="text" name="releaseDate" style="width: 100%" form="edit" value="${currentFilm.releaseDate}">
    </div>
    <div>
        Рейтинг
        <input type="text" name="rating" style="width: 100%" form="edit" value="${currentFilm.rating}">
    </div>
    <div>
        Сборы
        <input type="text" name="collection" style="width: 100%" form="edit" value="${currentFilm.collection}"/>
    </div>
    <div>
        <select multiple id="idActor" onchange="addTextActor()" >
            <c:forEach var="actor" items="${actors}">
                <option selected value="${actor.idActor}">${actor.nameActor}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenActor" name="actor" form="edit">
        Актеры
        <input type="text" readonly id="idTextActor" name="nameFilm" style="width: 100%">
    </div>
    <div>
        <select multiple id="idGenre" onchange="addTextGenre()">
            <c:forEach var="genre" items="${genres}">
                <option selected value="${genre.idGenre}">${genre.nameGenre}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenGenre" name="genre" form="edit">
        Жанры
        <input type="text" readonly id="idTextGenre" name="nameFilm" style="width: 100%">
    </div>
    <div>
        <select multiple  id="idCountry" onchange="addTextCountry()">
            <c:forEach var="country" items="${countries}">
                <option selected value="${country.idCountry}">${country.nameCountry}</option>
            </c:forEach>
        </select>
        <input type="hidden" id="idHiddenCountry" name="country" form="edit">
        Страны
        <input type="text" readonly id="idTextCountry" name="nameFilm" style="width: 100%">
    </div>
</div>
<button type="submit" form="edit" name="id" value="${currentFilm.idFilm}">Добавить</button>
<button type="submit" form="main">На главную</button>
<input type="hidden" name="command" value="GET_FILM" form="main">
<input type="hidden" name="command" value="EDIT_FILM" form="edit">

</body>
</html>