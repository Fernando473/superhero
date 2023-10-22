package com.test.superhero.domain.service.impl;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.domain.service.CharacterService;
import com.test.superhero.infrastructure.integration.marvel.dto.CharacterDto;
import com.test.superhero.infrastructure.integration.marvel.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    @Override
    public List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series) {
        return characterRepository.findAll(pageable,name,comics,series);
    }

    @Override
    public CharacterDto.CharacterInfoDto findInfoById(long characterId) {
        return characterRepository.findById(characterId);
    }
}
