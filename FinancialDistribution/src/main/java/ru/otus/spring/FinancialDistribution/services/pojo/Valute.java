package ru.otus.spring.FinancialDistribution.services.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Valute {

    @JsonProperty(value = "ID")
    private String id;
    @JsonProperty(value = "NumCode")
    private Integer numCode;
    @JsonProperty(value = "CharCode")
    private String charCode;
    @JsonProperty(value = "Nominal")
    private Integer nominal;
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "Value")
    private Double value;
    @JsonProperty(value = "Previous")
    private Double previous;

    public void setId(String id) {
        this.id = id;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setPrevious(Double previous) {
        this.previous = previous;
    }

    public String getId() {
        return id;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Double getPrevious() {
        return previous;
    }

    public Integer getNominal() {
        return nominal;
    }

    public Integer getNumCode() {
        return numCode;
    }
}
