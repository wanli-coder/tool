package com.helper.tool.common.constants;

public enum CodeEnum {
    SUCCESS("处理成功", 10010), FAIL("处理成功", 10090);;
    private String name;
    private Integer value;

    private CodeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
