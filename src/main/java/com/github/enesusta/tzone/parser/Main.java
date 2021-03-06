package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.capitalizer.Capitalizer;
import com.github.enesusta.tzone.parser.capitalizer.DefaultCapitalizer;
import com.github.enesusta.tzone.parser.generator.CountyGenerator;
import com.github.enesusta.tzone.parser.generator.Generator;
import com.github.enesusta.tzone.parser.generator.ProvinceGenerator;
import com.github.enesusta.tzone.parser.generator.TownGenerator;
import com.github.enesusta.tzone.parser.generator.VillageGenerator;
import com.github.enesusta.tzone.parser.modal.pojo.CountyPOJO;
import com.github.enesusta.tzone.parser.modal.pojo.ProvincePOJO;
import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
import com.github.enesusta.tzone.parser.text.CountyTextConsumer;
import com.github.enesusta.tzone.parser.text.ProvinceTextConsumer;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import com.github.enesusta.tzone.parser.text.TownTextConsumer;
import com.github.enesusta.tzone.parser.text.VillageTextConsumer;

import java.io.IOException;


public final class Main {

    public static void main(String[] args) throws IOException {

        /** Province Start */

        Generator generator = new ProvinceGenerator();
        //       generator.generate();

        TextConsumer<ProvincePOJO> textConsumer = new ProvinceTextConsumer();
        Consumer consumer = new ProvinceConsumer(textConsumer);
        //consumer.consume();

        /** Province End */

        /** County Start */

        Generator countyGenerator = new CountyGenerator();
        //      countyGenerator.generate();

        TextConsumer<CountyPOJO> countyPOJOTextConsumer = new CountyTextConsumer();
        Consumer countyConsumer = new CountyConsumer(countyPOJOTextConsumer);
//        countyConsumer.consume();

        /** County End */


        /** Town Start */

        Generator townGenerator = new TownGenerator();
        //  townGenerator.generate();

        TextConsumer<TownPOJO> townPOJOTextConsumer = new TownTextConsumer();
        Consumer townConsumer = new ComplexTownConsumer(townPOJOTextConsumer);
        //townConsumer.consume();

        /** Town End */

        /** Village Start */

        Capitalizer capitalizer = new DefaultCapitalizer();

        Generator villageGenerator = new VillageGenerator(capitalizer);
        villageGenerator.generate();

        TextConsumer<VillagePOJO> villagePOJOTextConsumer = new VillageTextConsumer();
        Consumer villageConsumer = new ComplexVillageConsumer(villagePOJOTextConsumer);
         villageConsumer.consume();

        /** Village End */

    }
}
