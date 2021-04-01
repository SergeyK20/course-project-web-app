package dto;

import java.sql.Date;
import java.util.Set;

public class FilmDTO {

    private long idFilm;
    private String nameFilm;
    private Date releaseDate;
    private int rating;
    private double collection;
    private Set<ActorDTO> actors;
    private Set<GenreDTO> genres;
    private Set<CountryDTO> countries;

    public FilmDTO(long idFilm,
                   String nameFilm,
                   Date releaseDate,
                   int rating,
                   double collection,
                   Set<ActorDTO> actors,
                   Set<GenreDTO> genres,
                   Set<CountryDTO> countries
    ) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.collection = collection;
        this.actors = actors;
        this.genres = genres;
        this.countries = countries;
    }

    public long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    public Set<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDTO> actors) {
        this.actors = actors;
    }

    public Set<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDTO> genres) {
        this.genres = genres;
    }

    public Set<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(Set<CountryDTO> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "FilmDTO{" +
                "idFilm=" + idFilm +
                ", nameFilm='" + nameFilm + '\'' +
                ", releaseDate=" + releaseDate +
                ", rating=" + rating +
                ", collection=" + collection +
                ", actors=" + actors +
                ", genres=" + genres +
                ", countries=" + countries +
                '}';
    }
}
