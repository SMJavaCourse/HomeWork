package org.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;
import org.course.service.HotelService;

import javax.sql.DataSource;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.concurrent.Executors;

public class WebServer {
    private HttpServer httpServer;
    private HotelService hotelService;
    private ObjectMapper objectMapper;

    public WebServer(Integer port, DataSource dataSource) {
        httpServer = createServer(port);
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        hotelService = new HotelService(dataSource);
    }

    @SneakyThrows
    public HttpServer createServer(int port) {
        var httpServer = HttpServer.create(new InetSocketAddress("localhost", port), 1024);
        httpServer.createContext("/hotels", this::handleGetCity);
        httpServer.setExecutor(Executors.newFixedThreadPool(10));
        return httpServer;
    }

    @SneakyThrows
    private void handleGetCity(HttpExchange exchange) {
        var id = getIdFromUri(exchange.getRequestURI());
        try {
            var hotel = hotelService.getHotel(id);
            if (hotel != null) {
                var json = objectMapper.writeValueAsString(hotel);
                sendResponse(200, json, exchange);
            } else {
                sendResponse(404, "Not found", exchange);
            }
        } catch (Exception ex) {
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

    public void start() {
        httpServer.start();
    }

}
