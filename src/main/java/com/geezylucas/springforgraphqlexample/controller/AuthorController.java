package com.geezylucas.springforgraphqlexample.controller;

import com.geezylucas.springforgraphqlexample.dto.AuthorDTO;
import com.geezylucas.springforgraphqlexample.dto.BookDTO;
import com.geezylucas.springforgraphqlexample.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @SchemaMapping(typeName = "Book")
    public Mono<AuthorDTO> author(BookDTO bookDTO) {
        return authorService.findByAuthorId(bookDTO.authorId());
    }
}
