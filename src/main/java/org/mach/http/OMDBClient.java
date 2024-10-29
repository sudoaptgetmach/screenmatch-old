package org.mach.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mach.modelos.Titulo;
import org.mach.modelos.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OMDBClient {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static Titulo searchMovie(String busca, String anoInput) throws IOException, InterruptedException {
        String apiKey = System.getenv("OMDB_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("API key not found in environment variables");
        }

        String encodedBusca = URLEncoder.encode(busca, StandardCharsets.UTF_8);
        String endereco = "https://omdbapi.com/?t=" + encodedBusca;
        if (!anoInput.isEmpty()) {
            endereco += "&y=" + anoInput;
        }
        endereco += "&apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb titulo = gson.fromJson(json, TituloOmdb.class);

        return new Titulo(titulo);
    }
}