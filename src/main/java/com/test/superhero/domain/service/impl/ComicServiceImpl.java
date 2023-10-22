package com.test.superhero.domain.service.impl;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.domain.service.ComicService;
import com.test.superhero.infrastructure.integration.marvel.dto.ComicDto;
import com.test.superhero.infrastructure.integration.marvel.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl  implements ComicService {
    @Autowired
    private ComicRepository comicRepository;
    @Override
    public List<ComicDto> findAll(MyPageable pageable, long characterId) {
        return comicRepository.findAll(pageable,characterId);
    }

    @Override
    public ComicDto findById(long characterId) {
        return comicRepository.findById(characterId);
    }
}
