package br.com.pedrobruno.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
        @JsonAlias("name") String titulo,
        @JsonAlias("episode_number") Integer numero,
        @JsonAlias("vote_average") String avaliacao,
        @JsonAlias("air_date") String dataLancamento
) {
}
