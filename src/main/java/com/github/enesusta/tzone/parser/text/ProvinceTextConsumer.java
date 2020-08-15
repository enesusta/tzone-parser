package com.github.enesusta.tzone.parser.text;

import com.github.enesusta.tzone.parser.modal.pojo.ProvincePOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProvinceTextConsumer implements TextConsumer<ProvincePOJO> {

    @Override
    public List<ProvincePOJO> consumeText(String filename) {

        List<ProvincePOJO> list = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                ProvincePOJO provincePOJO = new ProvincePOJO();
                provincePOJO.setProvinceName(scanner.next());
                list.add(provincePOJO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
