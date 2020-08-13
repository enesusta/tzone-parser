package com.github.enesusta.tzone.parser.modal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Set;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Province implements Comparable<Province> {
    private String provinceName;
    private Set<County> provinceCounties;

    public void setProvinceCounties(Set<County> provinceCounties) {
        this.provinceCounties = provinceCounties;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
            "provinceName='" + provinceName + '\'' +
            ", counties=" + provinceCounties +
            '}';
    }


    @Override
    public int compareTo(Province o) {
        return this.provinceName.compareTo(o.provinceName);
    }
}
