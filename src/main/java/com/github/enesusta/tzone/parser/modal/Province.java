package com.github.enesusta.tzone.parser.modal;

import java.util.Arrays;

public class Province {
    private String provinceName;
    private County[] counties;

    public void setCounties(County[] counties) {
        this.counties = counties;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
            "provinceName='" + provinceName + '\'' +
            ", counties=" + Arrays.toString(counties) +
            '}';
    }
}
