package com.test.superhero.infrastructure.integration.marvel.dto;

public record ComicDto(
        long id,
        String title,
        String description,
        String modified,
        String resourceURI,
        ThumbnailDto thumbnail

) {
}
