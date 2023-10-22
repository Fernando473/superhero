package com.test.superhero.domain.dto;

public record MyPageable(
        long offset,
        long limit
) {
}
