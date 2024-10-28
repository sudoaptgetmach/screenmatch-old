package org.mach.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

        String endereco = "https://omdbapi.com/?t=" + busca;
        if (!anoInput.isEmpty()) {
            endereco += "&y=" + anoInput;
        }
        endereco += "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}