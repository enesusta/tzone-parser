package com.github.enesusta.tzone.parser.modal.pojo;

public class VillagePOJO {
    private String provinceName;
    private String districtName;
    private String townName;
    private String villageName;
    private int zipCode;


    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

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
        return "VillagePOJO{" +
            "provinceName='" + provinceName + '\'' +
            ", districtName='" + districtName + '\'' +
            ", townName='" + townName + '\'' +
            ", villageName='" + villageName + '\'' +
            ", zipCode=" + zipCode +
            '}';
    }
}
