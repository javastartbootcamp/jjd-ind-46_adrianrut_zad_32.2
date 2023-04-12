package pl.javastart.jpaoptimalization.countrylanguage;

import javax.persistence.Column;
import java.io.Serializable;
public class CountryLanguageKey implements Serializable {

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "Language")
    private String language;
}
