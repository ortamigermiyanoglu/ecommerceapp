package com.sumutella.dolapcodecase.util;

public enum BusinesConstants {
    DRESS_SIZE("DRESS_SIZE"),
    SHOE_BRAND_TYPE("SHOE_BRAND"),
    DRESS_BRAND_TYPE("DRESS_BRAND"),
    SHOE_TYPE("SHOE_TYPE"),
    DRESS_TYPE("DRESS_TYPE"),
    MAN_CATEGORY_TYPE("MAN"),
    WOMAN_CATEGORY_TYPE("WOMAN"),
    USAGE_STATUS("USAGE_STATUS"),
    X_SMALL("XSMALL"),
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE"),
    X_LARGE("XLARGE"),
    XX_LARGE("XXLARGE");

    private final String code;

    private BusinesConstants(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
