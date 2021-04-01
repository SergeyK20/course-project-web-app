<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EL operation</title></head>
<body>
<h1>Заголовок</h1>
<div style="color: red">
    ${error}
</div>
<form action="/film" method="post" onsubmit="return confirm('Вы уверенны?');" id="delete"></form>
<form action="/film" method="post" id="edit"></form>
<form action="/film" method="post" id="add"></form>
<form action="/film" method="post" id="filter"></form>
<input type="hidden" form="delete" name="command" value="DELETE_FILM"/>
<input type="hidden" form="edit" name="command" value="EDIT_BEFORE_FILM"/>
<input type="hidden" form="add" name="command" value="ADD_BEFORE_FILM"/>
<input type="hidden" form="filter" name="command" value="FILTER_FILM"/>
<div>
    <a href="/actor">Актеры</a><br>
    <a href="/genre">Жанры</a><br>
    <a href="/country">Страны</a><br>
</div>
<div>
    Жанр
    <select name="genreFilter" form="filter">
        <c:forEach var="genre" items="${genres}">
            <option value="${genre.idGenre}">${genre.nameGenre}</option>
        </c:forEach>
        <option selected value=""></option>
    </select>
    Страны
    <select name="countryFilter" form="filter">
        <c:forEach var="country" items="${countries}">
            <option value="${country.idCountry}">${country.nameCountry}</option>
        </c:forEach>
        <option selected value=""></option>
    </select>
    <button type="submit" form="filter">Фильтровать</button>
</div>
<table>
    <c:forEach var="film" items="${films}">
        <tr>
            <td><c:out value="${film.nameFilm}"/></td>
            <td><c:out value="${film.releaseDate}"/></td>
            <td><c:out value="${film.rating}"/></td>
            <td><c:out value="${film.collection}"/></td>
            <td><c:out value="${film.actors}"/></td>
            <td><c:out value="${film.genres}"/></td>
            <td><c:out value="${film.countries}"/></td>
            <td>
                <button type="submit" name="id" form="delete"  value="${film.idFilm}">Удоли</button>
            </td>
            <td>
                <button type="submit" name="id" form="edit" value="${film.idFilm}">Обнови</button>
            </td>
            <td>
                <button type="submit" name="id" form="add" value="${film.idFilm}">Добавь</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>