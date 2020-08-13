package com.github.enesusta.tzone.parser.modal.bean;

import java.util.Set;

public class CountyBean {
    private String countyName;
    private Set<TownBean> countyTowns;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Set<TownBean> getCountyTowns() {
        return countyTowns;
    }

    public void setCountyTowns(Set<TownBean> countyTowns) {
        this.countyTowns = countyTowns;
    }

    @Override
    public String toString() {
        return "CountyBean{" +
            "countyName='" + countyName + '\'' +
            ", countyTowns=" + countyTowns +
            '}';
    }
}
