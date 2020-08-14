package com.github.enesusta.tzone.parser.modal.bean;

public class VillageBean implements Comparable<VillageBean> {
    private String villageName;
    private int zipCode;

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "VillageBean{" +
            "villageName='" + villageName + '\'' +
            ", zipCode=" + zipCode +
            '}';
    }

    @Override
    public int compareTo(VillageBean o) {
        return villageName.compareTo(o.villageName);
    }
}
