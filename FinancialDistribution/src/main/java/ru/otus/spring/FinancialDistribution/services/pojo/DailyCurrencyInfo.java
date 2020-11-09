package ru.otus.spring.FinancialDistribution.services.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyCurrencyInfo {

    @JsonProperty(value = "PreviousURL")
    private String PreviousURL;

    @JsonProperty(value = "Valute")
    private Map<String, Valute> valute;


    public String getName() {
        return PreviousURL;
    }

    public void setName(String PreviousURL) {
        this.PreviousURL = PreviousURL;
    }

    public Map<String, Valute> getValute() {
        return valute;
    }

    public void setValute(Map<String, Valute> valute) {
        this.valute = valute;
    }
}
