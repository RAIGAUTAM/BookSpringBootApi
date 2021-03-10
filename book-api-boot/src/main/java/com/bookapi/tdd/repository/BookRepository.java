package com.bookapi.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapi.tdd.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
