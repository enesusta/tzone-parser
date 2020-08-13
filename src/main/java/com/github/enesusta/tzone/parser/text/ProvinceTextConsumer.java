package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.pojo.CityPOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProvinceTextConsumer implements TextConsumer<CityPOJO> {

    @Override
    public List<CityPOJO> consumeText(String filename) {

        List<CityPOJO> list = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("#");
                System.out.println(Arrays.toString(arr));
                CityPOJO cityPOJO = new CityPOJO();
                cityPOJO.setCityName(arr[0]);
                cityPOJO.setDistrictName(arr[1]);
                list.add(cityPOJO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
