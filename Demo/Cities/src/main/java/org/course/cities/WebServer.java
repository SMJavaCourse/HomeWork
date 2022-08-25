package org.course.cities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;
import org.course.cities.service.CitiesService;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.concurrent.Executors;

public class WebServer {
    private HttpServer server;
    private CitiesService citiesService;
    private ObjectMapper objectMapper;

    public WebServer(Integer port) {
        server = createServer(port);
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        citiesService = new CitiesService();
    }

    public void start() {
        server.start();
    }

    @SneakyThrows
    private HttpServer createServer(int port) {
        var httpServer = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        httpServer.createContext("/cities", this::handleGetCity);
        httpServer.setExecutor(Executors.newFixedThreadPool(10));
        return httpServer;
    }

    @SneakyThrows
    private void handleGetCity(HttpExchange exchange) {
        var id = getIdFromUri(exchange.getRequestURI());
        try {
            var city = citiesService.getCity(id);
            if (city != null) {
                var json = objectMapper.writeValueAsString(city);
                sendResponse(200, json, exchange);
            } else {
                sendResponse(404, "Not found", exchange);
            }
        } catch (
                Exception ex) {
            sendResponse(500, "Internal server error", exchange);
        }
    }

    @SneakyThrows
    private void sendResponse(int code, String body, HttpExchange exchange) {
        OutputStream outputStream = exchange.getResponseBody();
        exchange.sendResponseHeaders(code, body.getBytes().length);
        outputStream.write(body.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String getIdFromUri(URI uri) {
        var splitUrl = uri.toString().split("/");
        return splitUrl[splitUrl.length - 1];
    }
}
