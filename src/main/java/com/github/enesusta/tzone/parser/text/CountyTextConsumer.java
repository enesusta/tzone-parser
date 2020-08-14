package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.pojo.CountyPOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CountyTextConsumer implements TextConsumer<CountyPOJO> {

    @Override
    public List<CountyPOJO> consumeText(String filename) {

        List<CountyPOJO> list = new LinkedList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("#");

                CountyPOJO countyPOJO = new CountyPOJO();
                countyPOJO.setProvinceName(arr[0]);
                countyPOJO.setCountyName(arr[1]);

                list.add(countyPOJO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
