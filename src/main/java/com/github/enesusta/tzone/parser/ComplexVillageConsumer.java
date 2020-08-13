package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.bean.AllBean;
import com.github.enesusta.tzone.parser.modal.pojo.VillagePOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class ComplexVillageConsumer implements Consumer {

    private final TextConsumer<VillagePOJO> textConsumer;

    public ComplexVillageConsumer(final TextConsumer<VillagePOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void consume() {

        List<VillagePOJO> list = textConsumer.consumeText("village.txt");
        List<AllBean> allBeans = new LinkedList<>();

        /** Section 1 */

        MultiMap<String, VillagePOJO> mapSectionOne = new MultiValueMap<>();

        for (VillagePOJO villagePOJO : list) {
            mapSectionOne.put(villagePOJO.getProvinceName(), villagePOJO);
        }


    }
}
