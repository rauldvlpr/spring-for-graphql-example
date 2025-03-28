package com.geezylucas.springforgraphqlexample.service;

import com.geezylucas.springforgraphqlexample.dto.BookDTO;
import com.geezylucas.springforgraphqlexample.dto.CreateBookDTO;
import com.geezylucas.springforgraphqlexample.entity.BookEntity;
import com.geezylucas.springforgraphqlexample.exception.NotFoundException;
import com.geezylucas.springforgraphqlexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Mono<BookDTO> findByBookId(Integer bookId) {
        return bookRepository.findById(bookId)
                .switchIfEmpty(Mono.error(new NotFoundException("Book not found!")))
                .map(bookEntity -> BookDTO.builder()
                        .id(bookEntity.getId())
                        .name(bookEntity.getName())
                        .pageCount(bookEntity.getPageCount())
                        .authorId(bookEntity.getAuthorId())
                        .build());
    }

    public Mono<BookDTO> createBook(CreateBookDTO createBook) {
        return bookRepository.save(BookEntity.builder()
                        .name(createBook.name())
                        .pageCount(createBook.pageCount())
                        .authorId(createBook.authorId())
                        .build())
                .map(bookEntity -> BookDTO.builder()
                        .id(bookEntity.getId())
                        .name(bookEntity.getName())
                        .pageCount(bookEntity.getPageCount())
                        .authorId(bookEntity.getAuthorId())
                        .build());
    }
}
