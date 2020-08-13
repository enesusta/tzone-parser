package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.City;
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

public class CityConsumer extends Consumer {

    @Override
    protected void consume() throws IOException {

        Set<City> cities = new TreeSet<>();

        for (Row row : parser.parse()) {
            List<Cell> cells = StreamSupport
                .stream(row.spliterator(), false)
                .collect(Collectors.toList());
            City city = new City();
            city.setCityName(CellUtilityFactory.cellToString(cells.get(0)));
            cities.add(city);
        }

        objectMapper.writeValue(new File("city.json"), cities);
    }
}
