package com.example.retailers.common.consts;

public enum Keep {

    ORDER("ORDER-NUM:"),
    COMMODITY("REDIS_COMMODITY:"),
    ORDER_LIST("ORDER_LIST:"),
    COMMODITY_NUMBER("COMMODITY_NUMBER:"),
    INDEX("INDEX-NUM:");

    private String key;

    Keep(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    /**
     * 根据枚举名称得到key
     * 比如根据"WED"得到"星期三"
     * @param name
     * @return
     */
    public static String getKeyByName(String name) {
        Keep[] values = Keep.values();
        for (Keep value : values) {
            if (value.name().equals(name)) {
                return value.getKey();
            }
        }
        return null;
    }
}
