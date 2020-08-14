package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.pojo.CountyPOJO;
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


public class CountyConsumer implements Consumer {

    private final TextConsumer<CountyPOJO> textConsumer;

    public CountyConsumer(final TextConsumer<CountyPOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class AllBean implements Comparable<AllBean> {
        private String provinceName;
        private Set<CountyBean> provinceCounties;

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public void setProvinceCounties(Set<CountyBean> provinceCounties) {
            this.provinceCounties = provinceCounties;
        }

        @Override
        public int compareTo(AllBean o) {
            return provinceName.compareTo(o.provinceName);
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class CountyBean implements Comparable<CountyBean> {
        private String countyName;

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        @Override
        public int compareTo(CountyBean o) {
            return countyName.compareTo(o.countyName);
        }

        @Override
        public String toString() {
            return "CountyBean{" +
                "countyName='" + countyName + '\'' +
                '}';
        }
    }

    @Override
    public void consume() {

        List<CountyPOJO> list = textConsumer.consumeText("county.txt");

        /** Section 1 Start */

        MultiMap<String, CountyPOJO> mapSectionOne = new MultiValueMap<>();

        for (CountyPOJO countyPOJO : list) {
            mapSectionOne.put(countyPOJO.getProvinceName(), countyPOJO);
        }


        Set<AllBean> allBeans = new TreeSet<>();

        mapSectionOne.forEach((k1, v1) -> {

            /** Section 2 Start */

            Collection<CountyPOJO> c1 = (Collection<CountyPOJO>) v1;
            Set<CountyPOJO> s1 = new HashSet<>(c1);
            MultiMap<String, CountyPOJO> mapSectionTwo = new MultiValueMap<>();

            for (CountyPOJO countyPOJO : s1) {
                mapSectionTwo.put(countyPOJO.getCountyName(), countyPOJO);
            }
            Set<CountyBean> countyBeans = new TreeSet<>();

            mapSectionTwo.forEach((k2, v2) -> {
                CountyBean countyBean = new CountyBean();
                countyBean.setCountyName(k2);
                countyBeans.add(countyBean);
            });

            /** Section 2 End */

            AllBean allBean = new AllBean();
            allBean.setProvinceName(k1);
            allBean.setProvinceCounties(countyBeans);

            allBeans.add(allBean);
        });

        /** Section 1 End */

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("county.json"), allBeans);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
