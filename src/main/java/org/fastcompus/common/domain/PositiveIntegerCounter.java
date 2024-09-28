package org.fastcompus.common.domain;

public class PositiveIntegerCounter {
    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    public void increase() {
        this.count++;
    }
    public void decrease() {
        if(this.count > 0) {
            this.count--;
        }
    }
}
