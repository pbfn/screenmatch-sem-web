package br.com.pedrobruno.screenmatch;

import br.com.pedrobruno.screenmatch.model.DadosSerie;
import br.com.pedrobruno.screenmatch.service.ConsumoApi;
import br.com.pedrobruno.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://api.themoviedb.org/3/tv/95557?api_key=cc5c5278ac43f1d3575b64b9cb61e7b4");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
	}
}

