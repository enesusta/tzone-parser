package com.github.enesusta.tzone.parser.modal.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProvincePOJO implements Comparable<ProvincePOJO> {
    private String cityName;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public int compareTo(ProvincePOJO o) {
        return cityName.compareTo(o.cityName);
    }
}
