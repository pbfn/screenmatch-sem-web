package br.com.pedrobruno.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(
        @JsonAlias("season_number") Integer numero,
        @JsonAlias("episodes")  List<DadosEpisodio> episodios
) {
}
