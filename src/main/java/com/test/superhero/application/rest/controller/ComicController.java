package com.test.superhero.application.rest.controller;

import com.test.superhero.domain.dto.MyPageable;
import com.test.superhero.domain.service.ComicService;
import com.test.superhero.infrastructure.integration.marvel.dto.ComicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicController {
   @Autowired
   private ComicService comicService;

    @GetMapping
    public ResponseEntity<List<ComicDto>> findAll(
            @RequestParam(required = false) long characterId,
            @RequestParam(defaultValue = "0") long offset,
            @RequestParam(defaultValue = "10") long limit
    ){
        MyPageable pageable = new MyPageable(offset,limit);

        return ResponseEntity.ok(comicService.findAll(pageable,characterId));

    }


    @GetMapping("/{comicId}")
    public ResponseEntity<ComicDto> findById(
            @PathVariable long comicId
    ){
        return ResponseEntity.ok(comicService.findById(comicId));
    }
}
