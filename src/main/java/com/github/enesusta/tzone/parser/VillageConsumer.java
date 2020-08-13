package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.bean.AllBean;
import com.github.enesusta.tzone.parser.modal.pojo.TownPOJO;
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

        multiMap.forEach((k, v) -> {
            //           System.out.println("v = " + v);

            MultiMap<String, String> map = new MultiValueMap<>();
            Collection<VillagePOJO> collection = (Collection<VillagePOJO>) v;

            for (VillagePOJO villagePOJO : collection) {
                map.put(villagePOJO.getDistrictName(), villagePOJO);
            }

            for (Map.Entry<String, Object> entry : map.entrySet()) {

                Collection<VillagePOJO> collSet = (Collection<VillagePOJO>) entry.getValue();
                Set<VillagePOJO> set1 = new HashSet<>(collSet);

                MultiMap<String, VillagePOJO> map1 = new MultiValueMap<>();

                for (VillagePOJO villagePOJO : set1) {
                    map1.put(villagePOJO.getTownName(), villagePOJO);
                }

                map1.forEach((c,d) -> {

                    System.out.printf("Il %s, ilce %s, belde %s\n", k, entry.getKey(), c);
                    Collection<VillagePOJO> collSet1 = (Collection<VillagePOJO>) d;
                    Set<VillagePOJO> set2 = new HashSet<>(collSet1);
                    System.out.println(set2);

                });
            }

        });
    }
}

