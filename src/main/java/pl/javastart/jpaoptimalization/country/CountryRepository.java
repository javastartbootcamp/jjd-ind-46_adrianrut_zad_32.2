package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT DISTINCT c From Country c LEFT JOIN FETCH c.cities cc order by c.name, cc.population desc ")
    List<Country> findByOrderByName();

    @Query("SELECT DISTINCT c from Country c LEFT join FETCH c.languages cl order by c.name, cl.percentage desc")
    List<Country> findByCountryWithLanguage();

}
