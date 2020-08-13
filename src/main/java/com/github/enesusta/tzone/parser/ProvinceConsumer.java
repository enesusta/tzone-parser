package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.pojo.CityPOJO;
import com.github.enesusta.tzone.parser.modal.County;
import com.github.enesusta.tzone.parser.modal.Province;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ProvinceConsumer implements Consumer {

    private final TextConsumer<CityPOJO> textConsumer;

    public ProvinceConsumer(final TextConsumer<CityPOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<CityPOJO> list = textConsumer.consumeText("city.txt");
        List<Province> provinces = new LinkedList<>();
        MultiMap<String, String> multiMap = new MultiValueMap<>();

        for (CityPOJO c : list) {
            System.out.println(c);
            multiMap.put(c.getCityName(), c.getDistrictName());
        }

        multiMap.forEach((k, v) -> {
            System.out.printf("Key is %s, value is %s\n", k, v);

            Collection<String> collection = (Collection<String>) v;
            Set<County> set = new HashSet<>();

            for (String s : collection) {
                County county = new County(s);
                set.add(county);
            }

            Province province = new Province();
            province.setProvinceName(k);
            province.setProvinceCounties(set);

            provinces.add(province);
        });


        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("province.json"), provinces);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
