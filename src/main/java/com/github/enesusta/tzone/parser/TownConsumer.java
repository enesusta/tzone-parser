package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.CountyDAO;
import com.github.enesusta.tzone.parser.modal.Town;
import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TownConsumer implements Consumer {

    private final TextConsumer<TownPOJO> textConsumer;

    public TownConsumer(final TextConsumer<TownPOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<TownPOJO> list = textConsumer.consumeText("town.txt");
        List<CountyDAO> countyDAOS = new ArrayList<>();

        MultiMap<String, TownPOJO> multiMap = new MultiValueMap<>();

        for (TownPOJO townPOJO : list) {
            multiMap.put(townPOJO.getProvinceName(), townPOJO);
        }

        try (PrintStream printStream = new PrintStream(new FileOutputStream("towns.txt"))) {


            multiMap.forEach((k, v) -> {
//            System.out.printf("Key is %s , value is %s\n", k, v);

                MultiMap<String, String> map = new MultiValueMap<>();
                Collection<TownPOJO> collection = (Collection<TownPOJO>) v;


                for (TownPOJO townPOJO : collection) {
                    map.put(townPOJO.getDistrictName(), townPOJO.getTownName());
                }

                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    printStream.printf("Il: %s, District %s = ", k, entry.getKey());

                    CountyDAO countyDAO = new CountyDAO();
                    countyDAO.setProvinceName(k);
                    countyDAO.setCountyName(entry.getKey());

                    Collection<String> towns = (Collection<String>) entry.getValue();
                    Set<Town> townSet = new HashSet<>();

                    for (String town : towns) {
                        printStream.printf("|%s|", town);
                        Town townDAO = new Town();
                        townDAO.setTownName(town);
                        townSet.add(townDAO);
                    }

                    countyDAO.setCountyTowns(townSet);
                    printStream.println();
                    countyDAOS.add(countyDAO);

                }


            });

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("towns.json"), countyDAOS);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
