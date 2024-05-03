package dev.r4g309.sweetbook.schemas;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookSchema(
        Long id,
        String title,
        List<PersonSchema> authors,
        List<String> languages,
        @JsonAlias("download_count") Integer downloadCount
) {


}

