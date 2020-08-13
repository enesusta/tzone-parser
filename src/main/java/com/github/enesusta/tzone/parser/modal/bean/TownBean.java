package com.github.enesusta.tzone.parser.modal.bean;

import java.util.Set;

public class TownBean {
    private String townName;
    private Set<VillageBean> villageBeans;

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Set<VillageBean> getVillageBeans() {
        return villageBeans;
    }

    public void setVillageBeans(Set<VillageBean> villageBeans) {
        this.villageBeans = villageBeans;
    }

    @Override
    public String toString() {
        return "TownBean{" +
            "townName='" + townName + '\'' +
            ", villageBeans=" + villageBeans +
            '}';
    }
}
