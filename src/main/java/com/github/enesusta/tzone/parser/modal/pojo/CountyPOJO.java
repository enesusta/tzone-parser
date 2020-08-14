package com.github.enesusta.tzone.parser.modal.pojo;

public class CountyPOJO {
    private String provinceName;
    private String countyName;

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

    @Override
    public String toString() {
        return "CountyPOJO{" +
            "provinceName='" + provinceName + '\'' +
            ", countyName='" + countyName + '\'' +
            '}';
    }
}
