package ru.otus.spring.FinancialDistribution.services;


import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RestTemplateConverter {

    RestTemplate getRestTemplate() {
        RestTemplate restTemplateConverter = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        converter.setPrefixJson(true);
        messageConverters.add(converter);
        restTemplateConverter.setMessageConverters(messageConverters);
        return restTemplateConverter;
    }
}
