package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.generator.Generator;
import com.github.enesusta.tzone.parser.generator.ProvinceGenerator;
import com.github.enesusta.tzone.parser.generator.TownGenerator;
import com.github.enesusta.tzone.parser.generator.VillageGenerator;
import com.github.enesusta.tzone.parser.modal.pojo.CityPOJO;
import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
import com.github.enesusta.tzone.parser.text.ProvinceTextConsumer;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import com.github.enesusta.tzone.parser.text.TownTextConsumer;
import com.github.enesusta.tzone.parser.text.VillageTextConsumer;

import java.io.IOException;


public final class App {

    public static void main(String[] args) throws IOException {

        Generator generator = new ProvinceGenerator();
        //generator.generate();

        TextConsumer<CityPOJO> textConsumer = new ProvinceTextConsumer();
        Consumer consumer = new ProvinceConsumer(textConsumer);
        //       consumer.consume();


        Generator townGenerator = new TownGenerator();
        //townGenerator.generate();

        TextConsumer<TownPOJO> townPOJOTextConsumer = new TownTextConsumer();
        Consumer townConsumer = new TownConsumer(townPOJOTextConsumer);
//        townConsumer.consume();

        Generator villageGenerator = new VillageGenerator();
//        villageGenerator.generate();

        TextConsumer<VillagePOJO> villagePOJOTextConsumer = new VillageTextConsumer();
        Consumer villageConsumer = new ComplexVillageConsumer(villagePOJOTextConsumer);
        villageConsumer.consume();

    }
}
