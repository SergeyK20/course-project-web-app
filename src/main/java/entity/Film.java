package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID_FILM")
    private Long idFilm;

    @NotNull
    @Column(name = "NAME_FILM")
    private String nameFilm;

    @NotNull
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @NotNull
    @Column(name = "RATING")
    private int rating;

    @NotNull
    @Column(name = "COLLECTION")
    private double collection;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "ACTORS_IN_FILM",
            joinColumns = @JoinColumn(name = "ID_FILM"),
            inverseJoinColumns = @JoinColumn(name = "ID_ACTOR")
    )
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "GENRES_IN_FILM",
            joinColumns = @JoinColumn(name = "ID_FILM"),
            inverseJoinColumns = @JoinColumn(name = "ID_GENRE")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "COUNTRY_IN_FILM",
            joinColumns = @JoinColumn(name = "ID_FILM"),
            inverseJoinColumns = @JoinColumn(name = "ID_COUNTRY")
    )
    private Set<Country> countries = new HashSet<>();

    public void addActor(Actor actor){
        actors.add(actor);
    }

    public void removeActor(Actor actor){
        actors.remove(actor);
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
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

    public String toString() {
        return idFilm + " " +
                nameFilm + " " +
                releaseDate + " " +
                rating + " " +
                collection + " \n";
    }
}
