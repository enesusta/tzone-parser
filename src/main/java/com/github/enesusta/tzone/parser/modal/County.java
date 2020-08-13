package com.github.enesusta.tzone.parser.modal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class County implements Comparable<County> {
    private String countyName;

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Override
    public String toString() {
        return "County{" +
            "countyName='" + countyName + '\'' +
            '}';
    }

    @Override
    public int compareTo(County o) {
        return countyName.compareTo(o.countyName);
    }
}
