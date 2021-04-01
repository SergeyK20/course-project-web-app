package dto;

public class CountryDTO {

    private long idCountry;
    private String nameCountry;

    public CountryDTO(long idCountry, String nameCountry) {
        this.idCountry = idCountry;
        this.nameCountry = nameCountry;
    }

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "idCountry=" + idCountry +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
