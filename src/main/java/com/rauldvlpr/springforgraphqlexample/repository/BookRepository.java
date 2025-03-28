package com.rauldvlpr.springforgraphqlexample.repository;

import com.rauldvlpr.springforgraphqlexample.entity.BookEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends R2dbcRepository<BookEntity, Integer> {
}
