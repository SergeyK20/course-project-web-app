package parser;

import dto.CountryDTO;
import entity.Country;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CountryToCountryDTO implements Parse<Country, CountryDTO> {
    @Override
    public CountryDTO parse(Country country) {
        Objects.requireNonNull(country);

        return new CountryDTO(
                country.getIdCountry(),
                country.getNameCountry()
        );

    }

    @Override
    public Set<CountryDTO> parseCollection(Set<Country> countries) throws NullPointerException {
        Objects.requireNonNull(countries);

        Set<CountryDTO> countriesDTO = new HashSet<>();
        countries.stream().forEach(country -> countriesDTO.add(parse(country)));
        return countriesDTO;
    }
}
