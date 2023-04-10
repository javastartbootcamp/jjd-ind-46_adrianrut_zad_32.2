package pl.javastart.jpaoptimalization.countrylanguage;


import pl.javastart.jpaoptimalization.country.Country;

import java.util.List;

public class LanguageInCountry {

    private String language;
    private List<Country> country;

    public LanguageInCountry(String language, List<Country> country) {
        this.language = language;
        this.country = country;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
