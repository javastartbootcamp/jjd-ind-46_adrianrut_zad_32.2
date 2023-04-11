package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageRepository;

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

    public Map<String, List<String>> getLanguageWithCountry() {
        Map<String, String> countryCodes = getCodeWithCountry();
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAll();
        Map<String, List<String>> languageWithCountry = new TreeMap<>();
        List<String> countries;
        for (CountryLanguage countryLanguage : countryLanguages) {
            String language = countryLanguage.getLanguage();
            if (languageWithCountry.containsKey(language)) {
                languageWithCountry.get(language).add(countryCodes.get(countryLanguage.getCountryCode()));
            } else {
                countries = new ArrayList<>();
                String countryCode = countryLanguage.getCountryCode();
                countries.add(countryCodes.get(countryCode));
                languageWithCountry.put(language, countries);
            }
        }
        return languageWithCountry;
    }

    Map<String, String> getCodeWithCountry() {
        Map<String, String> countryCodes = new HashMap<>();
        List<Country> countryList = countryRepository.findAll();
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAll();
        for (CountryLanguage countryLanguage : countryLanguages) {
            for (Country country : countryList) {
                if (Objects.equals(countryLanguage.getCountryCode(), country.getCode())) {
                    countryCodes.put(countryLanguage.getCountryCode(), country.getName());
                }
            }
        }
        return countryCodes;
    }

}
