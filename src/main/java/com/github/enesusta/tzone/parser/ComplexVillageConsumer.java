package com.github.enesusta.tzone.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tzone.parser.modal.bean.AllBean;
import com.github.enesusta.tzone.parser.modal.bean.CountyBean;
import com.github.enesusta.tzone.parser.modal.bean.TownBean;
import com.github.enesusta.tzone.parser.modal.bean.VillageBean;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
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

@SuppressWarnings("Duplicates")
public class ComplexVillageConsumer implements Consumer {

    private final TextConsumer<VillagePOJO> textConsumer;

    public ComplexVillageConsumer(final TextConsumer<VillagePOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<VillagePOJO> list = textConsumer.consumeText("village.txt");

        /** Section 1 Start */

        MultiMap<String, VillagePOJO> mapSectionOne = new MultiValueMap<>();

        for (VillagePOJO villagePOJO : list) mapSectionOne.put(villagePOJO.getProvinceName(), villagePOJO);

        Set<AllBean> allBeans = new TreeSet<>();

        mapSectionOne.forEach((k1, v1) -> {


            /** Section 2 Start */

            Collection<VillagePOJO> c1 = (Collection<VillagePOJO>) v1;
            Set<VillagePOJO> s1 = new HashSet<>(c1);
            MultiMap<String, VillagePOJO> mapSectionTwo = new MultiValueMap<>();

            for (VillagePOJO villagePOJO : s1) mapSectionTwo.put(villagePOJO.getDistrictName(), villagePOJO);

            Set<CountyBean> countyBeans = new TreeSet<>();

            mapSectionTwo.forEach((k2, v2) -> {

                /** Section 3 Start */

                Collection<VillagePOJO> c2 = (Collection<VillagePOJO>) v2;
                Set<VillagePOJO> s2 = new HashSet<>(c2);
                MultiMap<String, VillagePOJO> mapSectionThree = new MultiValueMap<>();

                for (VillagePOJO villagePOJO : s2) mapSectionThree.put(villagePOJO.getTownName(), villagePOJO);

                Set<TownBean> townBeans = new TreeSet<>();

                mapSectionThree.forEach((k3, v3) -> {

                    /** Section 4 Start */

                    Collection<VillagePOJO> c3 = (Collection<VillagePOJO>) v3;
                    Set<VillagePOJO> s3 = new HashSet<>(c3);

                    Set<VillageBean> villageBeans = new TreeSet<>();

                    for (VillagePOJO villagePOJO : s3) {
                        VillageBean villageBean = new VillageBean();
                        villageBean.setVillageName(villagePOJO.getVillageName());
                        villageBean.setZipCode(villagePOJO.getZipCode());
                        villageBeans.add(villageBean);
                    }

                    TownBean townBean = new TownBean();
                    townBean.setTownName(k3);
                    townBean.setTownVillages(villageBeans);
                    townBeans.add(townBean);

                    /** Section 4 End */

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

        });

        /** Section 1 End */

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("village.json"), allBeans);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
