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
import java.util.Scanner;

public class OMDBClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme pra busca: ");
        var busca = scanner.nextLine();
        System.out.println("Digite o ano do filme (caso saiba, ou pressione Enter para pular): ");
        var anoInput = scanner.nextLine();

        String apiKey = System.getenv("OMDB_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("API key not found in environment variables");
        }

        try {

            String encodedBusca = URLEncoder.encode(busca, StandardCharsets.UTF_8);
            String endereco = "https://omdbapi.com/?t=" + encodedBusca;
            if (!anoInput.isEmpty()) {
                endereco += "&y=" + anoInput;
            }
            endereco += "&apikey=" + apiKey;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb titulo = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(titulo);
            System.out.println(meuTitulo);

        } catch (IllegalArgumentException e) {
            System.out.println("Aconteceu um erro de argumento: ");
            System.out.println(e.getMessage());
        }
    }
}