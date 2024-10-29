package org.mach.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mach.http.OMDBClient;
import org.mach.modelos.Titulo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonFileCreator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        String busca = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme pra busca: ");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite o ano do filme (caso saiba, ou pressione Enter para pular): ");
            var anoInput = scanner.nextLine();

            try {
                var filme = OMDBClient.searchMovie(busca, anoInput);

                titulos.add(filme);
                FileWriter writer = new FileWriter("filmes.json");
                writer.write(gson.toJson(titulos));
                writer.close();

            } catch (IOException | InterruptedException | NumberFormatException e) {
                System.out.println("Um erro aconteceu: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
