package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.modal.pojo.CountyPOJO;
import com.github.enesusta.tzone.parser.text.TextConsumer;

import java.util.List;
import java.util.Set;


public class CountyConsumer implements Consumer {

    private final TextConsumer<CountyPOJO> textConsumer;

    public CountyConsumer(final TextConsumer<CountyPOJO> textConsumer) {
        this.textConsumer = textConsumer;
    }

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

    static class CountyBean implements Comparable<CountyBean> {
        private String countyName;

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        @Override
        public int compareTo(CountyBean o) {
            return countyName.compareTo(o.countyName);
        }
    }

    @Override
    public void consume() {

        List<CountyPOJO> list = textConsumer.consumeText("county.txt");


    }
}
