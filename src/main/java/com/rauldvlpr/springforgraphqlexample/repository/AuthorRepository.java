package com.rauldvlpr.springforgraphqlexample.repository;

import com.rauldvlpr.springforgraphqlexample.entity.AuthorEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends R2dbcRepository<AuthorEntity, Integer> {
}
