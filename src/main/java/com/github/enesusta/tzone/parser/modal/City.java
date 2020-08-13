package com.github.enesusta.tzone.parser.modal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class City implements Comparable<City> {
    private String cityName;
    private String districtName;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    @Override
    public String toString() {
        return "City{" +
            "cityName='" + cityName + '\'' +
            ", districtName='" + districtName + '\'' +
            '}';
    }

    @Override
    public int compareTo(City o) {
        return cityName.compareTo(o.cityName);
    }
}
