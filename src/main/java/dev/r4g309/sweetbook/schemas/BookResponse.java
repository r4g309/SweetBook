package dev.r4g309.sweetbook.schemas;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record BookResponse(
        Integer count,
        String next,
        String previous,
        @JsonAlias("results") List<BookSchema> books
) {
}

