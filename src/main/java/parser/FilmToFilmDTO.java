package parser;

import dto.ActorDTO;
import dto.FilmDTO;
import entity.Actor;
import entity.Film;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FilmToFilmDTO implements Parse<Film, FilmDTO> {
    @Override
    public FilmDTO parse(Film film) throws NullPointerException {
        Objects.requireNonNull(film);

        return new FilmDTO(film.getIdFilm(),
                film.getNameFilm(),
                film.getReleaseDate(),
                film.getRating(),
                film.getCollection(),
                new ActorToActorsDTO().parseCollection(film.getActors()),
                new GenreToGenreDTO().parseCollection(film.getGenres()),
                new CountryToCountryDTO().parseCollection(film.getCountries())
        );
    }

    @Override
    public Set<FilmDTO> parseCollection(Set<Film> films) throws NullPointerException {
        Objects.requireNonNull(films);

        Set<FilmDTO> filmsDTO = new HashSet<>();
        films.stream().forEach(film -> filmsDTO.add(parse(film)));
        return filmsDTO;
    }
}
