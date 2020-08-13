package com.github.enesusta.tzone.parser.modal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class City implements Comparable<City> {
    private String cityName;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public int compareTo(City o) {
        return cityName.compareTo(o.cityName);
    }
}
