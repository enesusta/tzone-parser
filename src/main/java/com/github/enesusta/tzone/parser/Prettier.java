package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Prettier {

    public static void print(String filename) {

        try (InputStream inputStream = new FileInputStream(filename)) {

            ObjectMapper objectMapper =
                new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

            String json = Files.readString(Path.of(filename));
            System.out.println(objectMapper.writeValueAsString(json));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
