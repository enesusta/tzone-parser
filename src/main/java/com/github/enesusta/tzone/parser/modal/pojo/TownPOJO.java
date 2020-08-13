package com.github.enesusta.tzone.parser.modal.pojo;

public class TownPOJO {
    private String provinceName;
    private String districtName;
    private String townName;

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

    @Override
    public String toString() {
        return "TownPOJO{" +
            "provinceName='" + provinceName + '\'' +
            ", districtName='" + districtName + '\'' +
            ", townName='" + townName + '\'' +
            '}';
    }
}
