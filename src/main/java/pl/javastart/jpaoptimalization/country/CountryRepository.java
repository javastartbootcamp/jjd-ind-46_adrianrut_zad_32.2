package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javastart.jpaoptimalization.countrylanguage.LanguageInCountry;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT DISTINCT c From Country c LEFT JOIN FETCH c.cities order by c.name")
    List<Country> findByOrderByName();

    @Query("SELECT DISTINCT c from Country c LEFT join FETCH c.languages order by c.name")
    List<Country> findAll();

    @Query(value = "select cl.language as language from CountryLanguage cl where exists (select c.name as country from Country c where cl.countryCode=c.code)")
    List<LanguageInCountry> findCountryByLanguages();



}
