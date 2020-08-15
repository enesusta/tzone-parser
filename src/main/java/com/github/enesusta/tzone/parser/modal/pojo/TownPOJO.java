package com.github.enesusta.tzone.parser.modal.pojo;

public class TownPOJO {
    private String provinceName;
    private String countyName;
    private String townName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
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
            ", districtName='" + countyName + '\'' +
            ", townName='" + townName + '\'' +
            '}';
    }
}
