package com.geezylucas.springforgraphqlexample.repository;

import com.geezylucas.springforgraphqlexample.entity.AuthorEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends R2dbcRepository<AuthorEntity, Integer> {
}
