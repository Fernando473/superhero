package com.test.superhero.domain.service;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.infrastructure.integration.marvel.dto.CharacterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CharacterService {
    List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series);

    CharacterDto.CharacterInfoDto findInfoById(long characterId);
}
