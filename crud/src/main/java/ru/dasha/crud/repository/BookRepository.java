package ru.dasha.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dasha.crud.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}