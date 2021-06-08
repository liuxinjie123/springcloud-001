package com.cloud.api.common;

public enum CodeEnu {
    SUCCESS("000000", "成功"),
    ERROR("999999", "ERROR"),


    ;
    public String code;
    public String desc;
    CodeEnu() {}

    CodeEnu(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
