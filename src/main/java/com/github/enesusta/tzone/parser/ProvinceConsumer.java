package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.pojo.ProvincePOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProvinceConsumer implements Consumer {

    private final TextConsumer<ProvincePOJO> textConsumer;

    public ProvinceConsumer(final TextConsumer<ProvincePOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<ProvincePOJO> list = textConsumer.consumeText("province.txt");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("province.json"), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
