package dto;

public class ActorDTO {

    private long idActor;
    private String nameActor;

    public ActorDTO(long idActor, String nameActor) {
        this.idActor = idActor;
        this.nameActor = nameActor;
    }

    public long getIdActor() {
        return idActor;
    }

    public void setIdActor(long idActor) {
        this.idActor = idActor;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    @Override
    public String toString() {
        return "ActorDTO{" +
                "idActor=" + idActor +
                ", nameActor='" + nameActor + '\'' +
                '}';
    }
}
