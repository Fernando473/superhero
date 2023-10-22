package com.test.superhero.infrastructure.integration.marvel.dto;


public record CharacterDto(long id, String name, String description, String modified, String resourceURI) {
    public static record CharacterInfoDto(String imagePath, String description) {
    }
}