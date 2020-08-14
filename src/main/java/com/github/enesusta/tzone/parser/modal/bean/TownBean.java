package com.github.enesusta.tzone.parser.modal.bean;

import java.util.Set;

public class TownBean implements Comparable<TownBean> {
    private String townName;
    private Set<VillageBean> townVillages;

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Set<VillageBean> getTownVillages() {
        return townVillages;
    }

    public void setTownVillages(Set<VillageBean> townVillages) {
        this.townVillages = townVillages;
    }

    @Override
    public String toString() {
        return "TownBean{" +
            "townName='" + townName + '\'' +
            ", villageBeans=" + townVillages +
            '}';
    }

    @Override
    public int compareTo(TownBean o) {
        return townName.compareTo(o.townName);
    }
}
