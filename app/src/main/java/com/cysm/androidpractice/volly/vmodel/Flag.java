package com.cysm.androidpractice.volly.vmodel;

import java.io.Serializable;

public class Flag implements Serializable {
    public String png;
    public String common;

    public Flag(String png, String common) {
        this.png = png;
        this.common = common;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
