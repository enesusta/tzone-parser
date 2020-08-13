package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.City;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceConsumer implements Consumer {

    private final TextConsumer<City> textConsumer;

    public ProvinceConsumer(final TextConsumer<City> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<City> list = textConsumer.consumeText("city.txt");
        MultiMap<String, String> multiMap = new MultiValueMap<>();

        for (City c : list) {
            System.out.println(c);
            multiMap.put(c.getCityName(), c.getDistrictName());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("test.json"), multiMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        multiMap.forEach((k, v) -> {
            System.out.printf("Key is %s, value is %s\n", k, v);
        });

    }
}
