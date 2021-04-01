package dto;

public class GenreDTO {

    private long idGenre;
    private String nameGenre;

    public GenreDTO(long idGenre, String nameGenre) {
        this.idGenre = idGenre;
        this.nameGenre = nameGenre;
    }

    public long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(long idGenre) {
        this.idGenre = idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    @Override
    public String toString() {
        return "GenreDTO{" +
                "idGenre=" + idGenre +
                ", nameGenre='" + nameGenre + '\'' +
                '}';
    }
}
