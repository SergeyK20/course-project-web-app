package parser;

import dto.GenreDTO;
import entity.Genre;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenreToGenreDTO implements Parse<Genre, GenreDTO> {
    @Override
    public GenreDTO parse(Genre genre) throws NullPointerException {
        Objects.requireNonNull(genre);

        return new GenreDTO(
                genre.getIdGenre(),
                genre.getNameGenre()
        );
    }

    @Override
    public Set<GenreDTO> parseCollection(Set<Genre> genres) throws NullPointerException {
        Objects.requireNonNull(genres);
        Set<GenreDTO> genresDTO = new HashSet<>();
        genres.stream().forEach(genre -> genresDTO.add(parse(genre)));
        return genresDTO;
    }
}
