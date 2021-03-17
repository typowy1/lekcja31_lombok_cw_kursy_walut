package pl.javastart.lekcja31_lombok_cw_kursy_walut;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FixerService {


    private static final String URL = "http://data.fixer.io/api/latest?access_key=19ebbd308b5439fbc039470999b848df";

    public List<CurrencyValue> getCurrencyValues() {

        RestTemplate restTemplate = new RestTemplate(); // słuzy do pobrania obiektu

        try { // sprobuj to wykonac jak nie to lap wyjatek
            FixerResponseDto response = restTemplate.getForObject(URL, FixerResponseDto.class); //pobieramy odpowiedz i zapisujemy do pól obiektu FixerResponseDto,wymaga podania typu klasy
            BigDecimal plnToEuro = response.getRates().get("PLN"); //pobieramy wartosc zlotowki

            return response.getRates()
                    //zbiór którego elementami sa klucz i wartosc
                    .entrySet()
                    .stream()
                    .map(entry -> new CurrencyValue(entry.getKey(), plnToEuro.divide(entry.getValue(), 10, RoundingMode.HALF_UP)))//obliczam przelicznik zlotowki dziele pln przez dana walute przez, 10 miejsc po przecinku, zaokraglanie w gore
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new CurrencyDataNotAvailableException();
        }

    }
}
