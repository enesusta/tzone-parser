package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Collection;
import java.util.List;

public class TownConsumer implements Consumer {

    private final TextConsumer<TownPOJO> textConsumer;

    public TownConsumer(final TextConsumer<TownPOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<TownPOJO> list = textConsumer.consumeText("town.txt");

        MultiMap<String, TownPOJO> multiMap = new MultiValueMap<>();

        for (TownPOJO townPOJO : list) {
            multiMap.put(townPOJO.getProvinceName(), townPOJO);
        }

        multiMap.forEach((k, v) -> {
//            System.out.printf("Key is %s , value is %s\n", k, v);

            MultiMap<String, String> map = new MultiValueMap<>();
            Collection<TownPOJO> collection = (Collection<TownPOJO>) v;

            for (TownPOJO townPOJO : collection) {
                map.put(townPOJO.getDistrictName(), townPOJO.getTownName());
            }

            map.forEach((a,b) -> {
                System.out.printf("District %s, town %s\n", a,b);
            });

        });

    }
}
