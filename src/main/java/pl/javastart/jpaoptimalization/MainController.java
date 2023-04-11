package pl.javastart.jpaoptimalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.jpaoptimalization.country.Country;
import pl.javastart.jpaoptimalization.country.CountryService;

import java.util.*;

@Controller
public class MainController {

    private final CountryService countryService;

    public MainController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/najwieksze-miasta")
    public String countryWithBiggestCity(Model model) {
        List<Country> countries = countryService.findSorted();
        model.addAttribute("countries", countries);

        return "countryWithBiggestCity";
    }

    @GetMapping("/kraje-i-jezyki")
    public String countryWithLanguages(Model model) {
        List<Country> countries = countryService.findCountryWithLanguage();

        model.addAttribute("countries", countries);

        return "countryWithLanguages";
    }

    @GetMapping("/jezyki-i-kraje")
    public String getLanguageWithCountry(Model model) {
        Map<String, List<String>> languageWithCountry = countryService.getLanguageWithCountry();

        model.addAttribute("country", languageWithCountry);

        return "languagesWithCountries";
    }

}
