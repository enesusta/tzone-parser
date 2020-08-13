package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TownTextConsumer implements TextConsumer<TownPOJO> {

    @Override
    public List<TownPOJO> consumeText(String filename) {

        List<TownPOJO> list = new LinkedList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("#");

                TownPOJO townPOJO = new TownPOJO();
                townPOJO.setProvinceName(arr[0]);
                townPOJO.setDistrictName(arr[1]);
                townPOJO.setTownName(arr[2]);
                list.add(townPOJO);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
