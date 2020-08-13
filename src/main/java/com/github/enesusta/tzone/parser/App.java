package com.github.enesusta.tzone.parser;

import java.io.IOException;


public final class App {

    public static void main(String[] args) throws IOException {

        Consumer consumer = new ProvinceConsumer();
        consumer.consume();

        Consumer city = new CityConsumer();
        city.consume();

    }
}

    /**public static void main(String[] args) {

        Consumer provinceConsumer = new ProvinceConsumer();

        try (InputStream inputStream =
                 new FileInputStream("a.xlsx")) {

            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            Cell temp = TemporaryCell.of();
            Cell provinceNameTemp = TemporaryCell.of();

            itr.next();

            List<Province> provinces = new LinkedList<>();
            Province province = new Province();
            province.setProvinceName("ADANA");
            Set<County> counties = new HashSet<>();

            while (itr.hasNext()) {

                Row row = itr.next();

                List<Cell> cells = StreamSupport
                    .stream(row.spliterator(), false)
                    .collect(Collectors.toList());


                if (!temp.getStringCellValue().equalsIgnoreCase(cells.get(1).getStringCellValue())) {
                    //System.out.printf("Il %s : Ilce %s\n", cells.get(0), cells.get(1));
                    counties.add(new County(cells.get(1).getStringCellValue().trim()));

                    if (!provinceNameTemp.getStringCellValue().equalsIgnoreCase(cells.get(0).getStringCellValue())) {
                        provinces.add(province);
                        System.out.println(province);
                        province.setProvinceName(cells.get(0).getStringCellValue().trim());
                        province.setCounties(counties);
                        counties.clear();
                    }
                }

                temp = cells.get(1);
                provinceNameTemp = cells.get(0);

                /**
                 if (!temp.getStringCellValue().equalsIgnoreCase(cells.get(2).getStringCellValue())) {
                 temp = cells.get(2);
                 System.out.printf("Il %s : Ilce %s : Belde %s\n", cells.get(0), cells.get(1), cells.get(2));
                 }*/


                /**               Iterator<Cell> cellIterator = row.cellIterator();
                 while (cellIterator.hasNext()) {

                 Cell cell = cellIterator.next();
                 System.out.println(cell.getStringCellValue());
                 }
                 */


            /**
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("province.json"), provinces);
            System.out.println(provinces);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
             */
