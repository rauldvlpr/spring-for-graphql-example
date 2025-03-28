package com.geezylucas.springforgraphqlexample.dto;

import lombok.Builder;

@Builder
public record AuthorDTO(Integer id, String firstName, String lastName) {
}
