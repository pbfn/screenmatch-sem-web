package br.com.pedrobruno.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(
        @JsonAlias("original_name") String titulo,
        @JsonAlias("number_of_seasons") Integer totalTemporadas,
        @JsonAlias("vote_average") String avaliacao
) {
}
