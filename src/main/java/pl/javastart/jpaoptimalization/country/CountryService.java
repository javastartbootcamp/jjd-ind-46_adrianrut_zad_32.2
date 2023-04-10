package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageRepository;
import pl.javastart.jpaoptimalization.countrylanguage.LanguageInCountry;

import java.util.*;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryLanguageRepository countryLanguageRepository;

    public CountryService(CountryRepository countryRepository, CountryLanguageRepository countryLanguageRepository) {
        this.countryRepository = countryRepository;
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<Country> findCountryWithLanguage() {
        return countryRepository.findByCountryWithLanguage();
    }

    public List<Country> findSorted() {
        return countryRepository.findByOrderByName();
    }

    public List<LanguageInCountry> findWithLanguage() {
        return countryRepository.findCountryByLanguages();
    }


    public List<LanguageInCountry> getLanguageWithCountry() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAll();
        List<LanguageInCountry> languageInCountryList = new ArrayList<>();
        List<Country> tempList = new ArrayList<>();
        List<Country> countryWithLanguage;
        for (CountryLanguage countryLanguage : countryLanguages) {
            for (Country country : countryList) {
                if (Objects.equals(country.getCode(), countryLanguage.getCountryCode())) {
                    tempList.add(new Country(country.getName()));
                }
            }
            countryWithLanguage = tempList;
            languageInCountryList.add(new LanguageInCountry(countryLanguage.getLanguage(), countryWithLanguage));
            tempList.clear();
        }
        return languageInCountryList;
    }

}
