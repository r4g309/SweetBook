package dev.r4g309.sweetbook.schemas;

import com.fasterxml.jackson.annotation.JsonAlias;


public record PersonSchema(
        Long Id,
        String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear
) {
}
