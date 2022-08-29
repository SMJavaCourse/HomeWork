package org.course.cities;

import lombok.SneakyThrows;

public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        var globalStorage = new GlobalStorage();
        var webServer = new WebServer(globalStorage);
        webServer.start();
    }
}
