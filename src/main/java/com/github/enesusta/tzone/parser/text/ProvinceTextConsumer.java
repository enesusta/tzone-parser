package com.github.enesusta.tzone.parser.text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProvinceTextConsumer implements TextConsumer {

    @Override
    public List<String[]> consumeText(String filename) {

        List<String[]> list = new LinkedList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter(System.lineSeparator());

            while (scanner.hasNext()) {
                String[] arr = scanner.next().split("-");
                list.add(arr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
