package com.github.enesusta.tzone.parser.modal.bean;

import java.util.Set;

public class AllBean implements Comparable<AllBean> {
    private String provinceName;
    private Set<CountyBean> provinceCounties;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Set<CountyBean> getProvinceCounties() {
        return provinceCounties;
    }

    public void setProvinceCounties(Set<CountyBean> provinceCounties) {
        this.provinceCounties = provinceCounties;
    }

    @Override
    public String toString() {
        return "AllBean{" +
            "provinceName='" + provinceName + '\'' +
            ", provinceCounties=" + provinceCounties +
            '}';
    }

    @Override
    public int compareTo(AllBean o) {
        return provinceName.compareTo(o.provinceName);
    }
}
