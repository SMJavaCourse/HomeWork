package org.course;

public class SearchTimeDemo {
    private Long startTime;

    public SearchTimeDemo() {
        this.startTime = System.currentTimeMillis();
    }

    public void getMethodDuration() {
        var endTime = System.currentTimeMillis();
        System.out.println("время выполнения метода = " + (endTime - this.startTime)  + " миллисекунд");
    }
}
