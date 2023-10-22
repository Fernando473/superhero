package com.test.superhero.infrastructure.integration.marvel.repository;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.infrastructure.integration.marvel.MarvelAPIConfig;
import com.test.superhero.infrastructure.integration.marvel.dto.ComicDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicRepository {
    @Autowired
    private MarvelAPIConfig marvelAPIConfig;

    @Value("${integration.marvel.base-path}")
    private String basePath;
    private String comicPath;


    @PostConstruct
    private void setPath() {
        comicPath = basePath.concat("/").concat("characters");
    }

    public List<ComicDto> findAll(MyPageable pageable, long characterId) {
        return null;
    }

    public ComicDto findById(long characterId) {
        return null;
    }
}
