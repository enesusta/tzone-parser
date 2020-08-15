package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.pojo.CountyPOJO;
import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComplexTownConsumer implements Consumer {

    private TextConsumer<TownPOJO> townPOJOTextConsumer;

    public ComplexTownConsumer(final TextConsumer<TownPOJO> townPOJOTextConsumer) {
        this.townPOJOTextConsumer = townPOJOTextConsumer;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class AllBean implements Comparable<AllBean> {
        private String provinceName;
        private Set<CountyBean> provinceCounties;

        public void setProvinceCounties(Set<CountyBean> provinceCounties) {
            this.provinceCounties = provinceCounties;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        @Override
        public int compareTo(AllBean o) {
            return provinceName.compareTo(o.provinceName);
        }

        @Override
        public String toString() {
            return "AllBean{" +
                "provinceName='" + provinceName + '\'' +
                ", provinceCounties=" + provinceCounties +
                '}';
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class CountyBean implements Comparable<CountyBean> {
        private String countyName;
        private Set<TownBean> countyTowns;

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        public void setCountyTowns(Set<TownBean> countyTowns) {
            this.countyTowns = countyTowns;
        }

        @Override
        public int compareTo(CountyBean o) {
            return countyName.compareTo(o.countyName);
        }

        @Override
        public String toString() {
            return "CountyBean{" +
                "countyName='" + countyName + '\'' +
                ", countyTowns=" + countyTowns +
                '}';
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class TownBean implements Comparable<TownBean> {
        private String townName;

        public void setTownName(String townName) {
            this.townName = townName;
        }

        @Override
        public int compareTo(TownBean o) {
            return townName.compareTo(o.townName);
        }

        @Override
        public String toString() {
            return "TownBean{" +
                "townName='" + townName + '\'' +
                '}';
        }
    }

    @Override
    public void consume() {

        List<TownPOJO> list = townPOJOTextConsumer.consumeText("towns.txt");

        /** Section 1 Start */

        MultiMap<String, TownPOJO> mapSectionOne = new MultiValueMap<>();

        for (TownPOJO townPOJO : list) mapSectionOne.put(townPOJO.getProvinceName(), townPOJO);

        Set<AllBean> allBeans = new TreeSet<>();

        mapSectionOne.forEach((k1, v1) -> {

            /** Section 2 Start */

            Collection<TownPOJO> c1 = (Collection<TownPOJO>) v1;
            Set<TownPOJO> s1 = new HashSet<>(c1);
            MultiMap<String, CountyPOJO> mapSectionTwo = new MultiValueMap<>();

            for (TownPOJO townPOJO : s1) mapSectionTwo.put(townPOJO.getCountyName(), townPOJO);

            Set<CountyBean> countyBeans = new TreeSet<>();

            mapSectionTwo.forEach((k2, v2) -> {

                /** Section 3 Start */

                Collection<TownPOJO> c2 = (Collection<TownPOJO>) v2;
                Set<TownPOJO> s2 = new HashSet<>(c2);
                MultiMap<String, TownPOJO> mapSectionThree = new MultiValueMap<>();

                for (TownPOJO townPOJO : s2) mapSectionThree.put(townPOJO.getTownName(), townPOJO);

                Set<TownBean> townBeans = new TreeSet<>();

                mapSectionThree.forEach((k3, v3) -> {

                    TownBean townBean = new TownBean();
                    townBean.setTownName(k3);
                    townBeans.add(townBean);

                });

                CountyBean countyBean = new CountyBean();
                countyBean.setCountyName(k2);
                countyBean.setCountyTowns(townBeans);

                countyBeans.add(countyBean);

                /** Section 3 End */

            });

            AllBean allBean = new AllBean();
            allBean.setProvinceName(k1);
            allBean.setProvinceCounties(countyBeans);

            allBeans.add(allBean);

            /** Section 2 End */
            System.out.println("allBean = " + allBean);

        });

        /** Section 1 End */

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("towns.json"), allBeans);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
