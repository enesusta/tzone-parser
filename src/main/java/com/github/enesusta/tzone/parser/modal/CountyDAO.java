package com.github.enesusta.tzone.parser.modal;

import java.util.Set;

public class CountyDAO {
    private String provinceName;
    private String countyName;
    private Set<Town> countyTowns;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Set<Town> getCountyTowns() {
        return countyTowns;
    }

    public void setCountyTowns(Set<Town> countyTowns) {
        this.countyTowns = countyTowns;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }
}
