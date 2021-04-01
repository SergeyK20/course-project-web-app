package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor implements Serializable, InterfaceSideElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID_ACTOR")
    private Long idActor;

    @NotNull
    @Column(name = "NAME_ACTOR")
    private String nameActor;

    @ManyToMany(mappedBy = "actors",
            fetch = FetchType.EAGER)
    private Set<Film> films = new HashSet<>();

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public long getIdActor() {
        return idActor;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String toString() {
        return idActor + " " + nameActor + "\n";
    }

}

