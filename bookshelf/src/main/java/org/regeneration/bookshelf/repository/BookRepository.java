package org.regeneration.bookshelf.repository;

import org.regeneration.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
