package dev.r4g309.sweetbook.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import dev.r4g309.sweetbook.schemas.BookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class GutenService {
    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

    public BookResponse getBooksByTitle(String title) {
        return getDataFromUrl("/?search=" + URLEncoder.encode(title, StandardCharsets.UTF_8));
    }


    private BookResponse getDataFromUrl(String url) {
        String MAIN_URL = "https://gutendex.com/books";
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(MAIN_URL + url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), BookResponse.class);
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            System.out.println("Error al obtener los datos de la URL");
        }
        return null;
    }
}
