package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.Province;
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

public class ProvinceConsumer extends Consumer {

    @Override
    protected void consume() throws IOException {

        Set<Province> provinces = new TreeSet<>();

        for (Row row : parser.parse()) {
            List<Cell> cells = StreamSupport
                .stream(row.spliterator(), false)
                .collect(Collectors.toList());
            Province province = new Province();
            province.setCounties(null);
            province.setProvinceName(CellUtilityFactory.cellToString(cells.get(0)));
            provinces.add(province);
        }

        System.out.println(provinces);
        objectMapper.writeValue(new File("province.json"), provinces);
    }
}
