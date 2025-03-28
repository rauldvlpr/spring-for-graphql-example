package com.rauldvlpr.springforgraphqlexample.service;

import com.rauldvlpr.springforgraphqlexample.dto.BookDTO;
import com.rauldvlpr.springforgraphqlexample.dto.CreateBookDTO;
import com.rauldvlpr.springforgraphqlexample.entity.BookEntity;
import com.rauldvlpr.springforgraphqlexample.exception.NotFoundException;
import com.rauldvlpr.springforgraphqlexample.repository.BookRepository;
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
