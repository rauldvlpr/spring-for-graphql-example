package com.geezylucas.springforgraphqlexample.service;

import com.geezylucas.springforgraphqlexample.dto.AuthorDTO;
import com.geezylucas.springforgraphqlexample.exception.NotFoundException;
import com.geezylucas.springforgraphqlexample.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Mono<AuthorDTO> findByAuthorId(Integer authorId) {
        return authorRepository.findById(authorId)
                .switchIfEmpty(Mono.error(new NotFoundException("Author not found!")))
                .map(authorEntity -> AuthorDTO.builder()
                        .id(authorEntity.getId())
                        .firstName(authorEntity.getFirstName())
                        .lastName(authorEntity.getLastName())
                        .build());
    }
}
