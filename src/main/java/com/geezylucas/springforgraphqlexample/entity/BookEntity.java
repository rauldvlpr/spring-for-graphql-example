package com.geezylucas.springforgraphqlexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table("book")
public class BookEntity {

    @Id
    private Integer id;
    private String name;
    @Column("page_count")
    private int pageCount;
    @Column("author_id")
    private int authorId;
}
