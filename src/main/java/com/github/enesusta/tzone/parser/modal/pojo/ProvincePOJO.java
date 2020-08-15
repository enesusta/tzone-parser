package com.github.enesusta.tzone.parser.modal.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProvincePOJO implements Comparable<ProvincePOJO> {
    private String provinceName;

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    @Override
    public int compareTo(ProvincePOJO o) {
        return provinceName.compareTo(o.provinceName);
    }
}
