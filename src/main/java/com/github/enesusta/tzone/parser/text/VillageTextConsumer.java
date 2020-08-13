package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VillageTextConsumer implements TextConsumer<VillagePOJO> {

    @Override
    public List<VillagePOJO> consumeText(String filename) {

        List<VillagePOJO> list = new LinkedList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("#");

                VillagePOJO villagePOJO = new VillagePOJO();
                villagePOJO.setProvinceName(arr[0]);
                villagePOJO.setDistrictName(arr[1]);
                villagePOJO.setTownName(arr[2]);
                villagePOJO.setVillageName(arr[3]);
                villagePOJO.setZipCode(Integer.parseInt(arr[4]));

                list.add(villagePOJO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
