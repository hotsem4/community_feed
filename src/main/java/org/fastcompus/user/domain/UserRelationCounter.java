package org.fastcompus.user.domain;

public class UserRelationCounter {
    private int count;

    public UserRelationCounter(int count) {
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
