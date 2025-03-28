package com.geezylucas.springforgraphqlexample.repository;

import com.geezylucas.springforgraphqlexample.entity.BookEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends R2dbcRepository<BookEntity, Integer> {
}
