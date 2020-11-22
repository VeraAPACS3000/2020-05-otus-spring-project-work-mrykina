package ru.otus.spring.FinancialDistribution.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Convertor {
    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
