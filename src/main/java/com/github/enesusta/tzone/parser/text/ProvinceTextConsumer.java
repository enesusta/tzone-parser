package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.City;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProvinceTextConsumer implements TextConsumer<City> {

    @Override
    public List<City> consumeText(String filename) {

        List<City> list = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("#");
                System.out.println(Arrays.toString(arr));
                City city = new City();
                city.setCityName(arr[0]);
                city.setDistrictName(arr[1]);
                list.add(city);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
