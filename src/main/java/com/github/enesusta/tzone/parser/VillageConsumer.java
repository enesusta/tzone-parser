package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.bean.AllBean;
import com.github.enesusta.tzone.parser.modal.bean.CountyBean;
import com.github.enesusta.tzone.parser.modal.bean.TownBean;
import com.github.enesusta.tzone.parser.modal.bean.VillageBean;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VillageConsumer implements Consumer {

    private final TextConsumer<VillagePOJO> textConsumer;

    public VillageConsumer(final TextConsumer<VillagePOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<VillagePOJO> list = textConsumer.consumeText("village.txt");
        List<AllBean> allBeans = new LinkedList<>();

        MultiMap<String, VillagePOJO> multiMap = new MultiValueMap<>();

        for (VillagePOJO villagePOJO : list) {
            multiMap.put(villagePOJO.getProvinceName(), villagePOJO);
            //           System.out.printf("Il, %s = ilce %s\n", villagePOJO.getProvinceName(), villagePOJO.getDistrictName());
        }

        Set<CountyBean> countyBeans = new HashSet<>();

        multiMap.forEach((k, v) -> {
            //           System.out.println("v = " + v);

            MultiMap<String, String> map = new MultiValueMap<>();
            Collection<VillagePOJO> collection = (Collection<VillagePOJO>) v;

            for (VillagePOJO villagePOJO : collection) {
                map.put(villagePOJO.getDistrictName(), villagePOJO);
            }

            CountyBean countyBean = new CountyBean();

            Set<TownBean> townBeans = new HashSet<>();

            for (Map.Entry<String, Object> entry : map.entrySet()) {

                Collection<VillagePOJO> collSet = (Collection<VillagePOJO>) entry.getValue();
                Set<VillagePOJO> set1 = new HashSet<>(collSet);

                MultiMap<String, VillagePOJO> map1 = new MultiValueMap<>();

                for (VillagePOJO villagePOJO : set1) {
                    map1.put(villagePOJO.getTownName(), villagePOJO);
                }

                TownBean townBean = new TownBean();
                townBean.setTownName(entry.getKey());

                map1.forEach((c, d) -> {

                    System.out.printf("Il %s, ilce %s, belde %s\n", k, entry.getKey(), c);
                    Collection<VillagePOJO> collSet1 = (Collection<VillagePOJO>) d;
                    Set<VillagePOJO> set2 = new HashSet<>(collSet1);

                    Set<VillageBean> villageBeans = new HashSet<>();

                    for (VillagePOJO villagePOJO : set2) {
                        VillageBean villageBean = new VillageBean();
                        villageBean.setVillageName(villageBean.getVillageName());
                        villageBean.setZipCode(villagePOJO.getZipCode());
                        villageBeans.add(villageBean);
                    }

                    townBean.setTownVillages(villageBeans);
                });

                townBeans.add(townBean);
            }

            countyBean.setCountyTowns(townBeans);
            countyBeans.add(countyBean);

        });
    }
}

