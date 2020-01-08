package com.boot.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum Sex implements IEnum<Integer> {
    Man(1, "男"),
    Woman(2, "女");

    private int value;
    private String desc;

    Sex(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
