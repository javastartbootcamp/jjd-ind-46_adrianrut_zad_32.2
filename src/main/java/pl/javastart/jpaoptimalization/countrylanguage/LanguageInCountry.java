package pl.javastart.jpaoptimalization.countrylanguage;

import pl.javastart.jpaoptimalization.country.Country;

import java.util.List;

public class LanguageInCountry {

    private String country;
    private String language;

    public LanguageInCountry(String country, String language) {
        this.country = country;
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
