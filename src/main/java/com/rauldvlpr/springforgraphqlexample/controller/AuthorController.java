package com.rauldvlpr.springforgraphqlexample.controller;

import com.rauldvlpr.springforgraphqlexample.dto.AuthorDTO;
import com.rauldvlpr.springforgraphqlexample.dto.BookDTO;
import com.rauldvlpr.springforgraphqlexample.service.AuthorService;
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
