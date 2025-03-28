package com.geezylucas.springforgraphqlexample.dto;

import lombok.Builder;

@Builder
public record BookDTO(Integer id, String name, int pageCount, int authorId) {
}