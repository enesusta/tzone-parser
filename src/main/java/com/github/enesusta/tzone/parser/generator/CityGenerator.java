package com.github.enesusta.tzone.parser.generator;

import com.github.enesusta.tzone.parser.modal.pojo.ProvincePOJO;
import com.github.enesusta.tzone.parser.util.CellUtilityFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CityGenerator extends Generator {

    @Override
    public void generate() throws IOException {

        Set<ProvincePOJO> cities = new TreeSet<>();

        for (Row row : parser.parse()) {
            List<Cell> cells = StreamSupport
                .stream(row.spliterator(), false)
                .collect(Collectors.toList());
            ProvincePOJO provincePOJO = new ProvincePOJO();
            provincePOJO.setCityName(CellUtilityFactory.cellToString(cells.get(0)));
            cities.add(provincePOJO);
        }

        objectMapper.writeValue(new File("city.json"), cities);
    }
}
