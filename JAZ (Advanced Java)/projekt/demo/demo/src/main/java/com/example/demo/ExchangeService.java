package com.example.demo;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNullElse;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final RestTemplate restTemplate;

    public ExchangeService(ExchangeRepository exchangeRepository, RestTemplate restTemplate) {
        this.exchangeRepository = exchangeRepository;
        this.restTemplate = restTemplate;
    }

    public Currency getAverageLastDaysRate(String currencyCode, @Nullable Integer amountOfDays) {
        Integer days = requireNonNullElse(amountOfDays, 1);
        CurrencyNBP lastDaysRates = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode + "/last/" + days + "?format=json", CurrencyNBP.class);
        Double averageRate = lastDaysRates.getRates().stream().map(Rate::getMid).reduce(0D, Double::sum) / days;

        return new Currency(null, currencyCode, averageRate, days, Instant.now());
    }

    public Currency getCurrencyWithNumberOfDays(String currencyCode, @Nullable Integer amountOfDay) {
        Currency currency = getAverageLastDaysRate(currencyCode, amountOfDay);
        exchangeRepository.save(currency);
        return currency;
    }

    public Currency getCurrency(String currencyCode, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        String url = "http://api.nbp.pl/api/exchangerates/tables/A/" + startDate + "/" + endDate + "/?format=json";
        CurrencyNBP[] lastDaysRates = restTemplate.getForObject(url, CurrencyNBP[].class);

        Double averageRate = lastDaysRates[0].getRates().stream()
                .map(Rate::getMid)
                .reduce(0D, Double::sum) / lastDaysRates[0].getRates().size();

        Currency answer = new Currency(null, currencyCode, averageRate, null, Instant.now());
        exchangeRepository.save(answer);
        return answer;
    }
}
