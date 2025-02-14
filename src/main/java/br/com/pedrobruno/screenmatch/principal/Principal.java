package br.com.pedrobruno.screenmatch.principal;

import br.com.pedrobruno.screenmatch.model.DadosSerie;
import br.com.pedrobruno.screenmatch.model.DadosTemporada;
import br.com.pedrobruno.screenmatch.service.ConsumoApi;
import br.com.pedrobruno.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://api.themoviedb.org/3/tv/";
    private final String API_KEY = "?api_key=cc5c5278ac43f1d3575b64b9cb61e7b4";


    public void exibeMenu() {
        System.out.println("1 - Round 6");
        System.out.println("2 - Invencible");
        System.out.println("3 - Os Simpsons");
        System.out.println("4 - Supernatural");
        System.out.println("Digite o código da série para buscar");
        var codigoSerie = leitura.nextLine();
        var idSerie = switch (codigoSerie) {
            case "1" -> "93405";
            case "2" -> "95557";
            case "3" -> "456";
            case "4" -> "1622";
            default -> "";
        };

        var json = consumoApi.obterDados("https://api.themoviedb.org/3/tv/" + idSerie + "?api_key=cc5c5278ac43f1d3575b64b9cb61e7b4");
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://api.themoviedb.org/3/tv/" + idSerie + "/season/" + i + "?api_key=cc5c5278ac43f1d3575b64b9cb61e7b4");
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(t ->
                t.episodios().forEach(e ->
                        System.out.println(e.titulo())
                ));
    }
}
