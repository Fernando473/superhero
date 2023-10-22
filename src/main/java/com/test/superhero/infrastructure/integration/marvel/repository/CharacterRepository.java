package com.test.superhero.infrastructure.integration.marvel.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.infrastructure.integration.marvel.MarvelAPIConfig;
import com.test.superhero.infrastructure.integration.marvel.dto.CharacterDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CharacterRepository {

    @Autowired
    private MarvelAPIConfig marvelAPIConfig;

    @Value("${integration.marvel.base-path}")
    private String basePath;
    private String characterPath;

    @PostConstruct
    private void setPath(){
        characterPath = basePath.concat("/").concat("characters");
    }
    public List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series) {
        Map<String, String> marvelQueryParams = getQueryParamsForFindAll(pageable, name, comics, series);

        JsonNode response = hhtpClientService.doGet(characterPath, marvelQueryParams, JsonNode.class);

        return CharacterMapper.toDtoList(response);
    }

    private Map<String, String> getQueryParamsForFindAll(MyPageable pageable, String name, int[] comics, int[] series) {
        Map<String, String> marvelQueryParams = marvelAPIConfig.getAuthenticationQueryParams();

        marvelQueryParams.put("offset", Long.toString(pageable.offset()));
        marvelQueryParams.put("limit", Long.toString(pageable.limit()));
        if (StringUtils.hasText(name)) {
            marvelQueryParams.put("name", name);
        }

        if (comics != null) {
            String comicsAsString = this.joinIntArray(comics);
            marvelQueryParams.put("comics", comicsAsString);
        }
        if (series != null) {
            String seriesAsString = this.joinIntArray(series);
            marvelQueryParams.put("series", seriesAsString);
        }
        return marvelQueryParams;
    }

    private String joinIntArray(int[] series) {
        List<String> stringArray = IntStream.of(series).boxed().map(Object::toString).toList();
        return String.join(",", stringArray);
    }

    public CharacterDto.CharacterInfoDto findById(long characterId) {
        Map<String, String> marvelQueryParams = marvelAPIConfig.getAuthenticationQueryParams();

        String finalUrl = characterPath.concat("/").concat(Long.toString(characterId));

        JsonNode response = HttpClientService.doGet(finalUrl,marvelQueryParams);

        return CharacterMapper.toDtoList(response).get(0);
    }
}
