package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageRepository;

import java.util.*;
import java.util.stream.Collectors;

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

    public Map<String, List<String>> getLanguageWithCountry() {
        Map<String, String> countryCodes = getCodeWithCountry();
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAll();
        Map<String, List<String>> languageWithCountry = new TreeMap<>();
        for (CountryLanguage countryLanguage : countryLanguages) {
            String language = countryLanguage.getLanguage();
            String country = countryCodes.get(countryLanguage.getCountryCode());
            languageWithCountry.merge(language, new ArrayList<>(){{add(country);}}, (l1,l2) -> {
                l1.addAll(l2);
                return l1;
            });
        }
        return languageWithCountry;
    }

    Map<String, String> getCodeWithCountry() {
        List<Country> countryList = countryRepository.findAll();
        return countryList.stream()
                .collect(Collectors.toMap(Country::getCode, Country::getName));
    }

}
