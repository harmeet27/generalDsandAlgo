package com.preparation;

public enum TestEnum {

    A(10), B(20);
    private int coders;

    TestEnum(int p) {
        coders = p;
    }

    public int getCoders() {
        return coders;
    }
}
