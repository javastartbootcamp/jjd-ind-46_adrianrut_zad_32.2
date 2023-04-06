package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

    @Query("SELECT DISTINCT cl.language as language, c.name as country FROM Country c JOIN c.languages cl order by cl.language")
    List<LanguageInCountry> findByOrderByName();

}
