package com.hillel.lesson2;

public abstract class Operation {
    protected int a;
    protected int b;

    public int execute() {
        return -1;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
