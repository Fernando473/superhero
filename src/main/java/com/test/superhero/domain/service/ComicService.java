package com.test.superhero.domain.service;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.infrastructure.integration.marvel.dto.ComicDto;

import java.util.List;

public interface ComicService {
    List<ComicDto> findAll(MyPageable pageable, long characterId);

    ComicDto findById(long characterId);


}
