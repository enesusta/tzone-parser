package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.generator.CityGenerator;
import com.github.enesusta.tzone.parser.generator.Generator;
import com.github.enesusta.tzone.parser.generator.ProvinceGenerator;
import com.github.enesusta.tzone.parser.modal.City;
import com.github.enesusta.tzone.parser.text.ProvinceTextConsumer;
import com.github.enesusta.tzone.parser.text.TextConsumer;

import java.io.IOException;
import java.util.List;


public final class App {

    public static void main(String[] args) throws IOException {


        Generator generator = new ProvinceGenerator();
        generator.generate();

        Generator city = new CityGenerator();
        //     city.generate();

        TextConsumer<City> textConsumer = new ProvinceTextConsumer();
        Consumer consumer = new ProvinceConsumer(textConsumer);
        consumer.consume();

    }
}
