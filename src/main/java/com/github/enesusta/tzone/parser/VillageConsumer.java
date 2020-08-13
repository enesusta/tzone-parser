package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.bean.AllBean;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
        }

        multiMap.forEach((k, v) -> {

            AllBean allBean = new AllBean();
            allBean.setProvinceName(k);

            //           System.out.println("allBean = " + allBean);

            Collection<VillagePOJO> collection = (Collection<VillagePOJO>) v;
            MultiMap<String, String> map1 = new MultiValueMap<>();

            for (VillagePOJO villagePOJO : collection) {
                map1.put(villagePOJO.getDistrictName(), villagePOJO.getTownName());
            }

            map1.forEach((a,b) -> {
                System.out.printf("%s - \n%s\n", a,b);
            });

        });

    }
}
