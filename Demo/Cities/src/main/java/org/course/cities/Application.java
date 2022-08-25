package org.course.cities;

public class Application {
    private static final int serverPort = 8080;

    public static void main(String[] args) {
        var webServer = new WebServer(serverPort);
        webServer.start();
    }
}
