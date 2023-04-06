package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javastart.jpaoptimalization.country.Country;

import java.util.List;
import java.util.Set;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

    @Query("SELECT DISTINCT cl.language as language, c.name as country FROM Country c JOIN c.languages cl order by cl.language")
    List<LanguageInCountry> findByOrderByName();

}
