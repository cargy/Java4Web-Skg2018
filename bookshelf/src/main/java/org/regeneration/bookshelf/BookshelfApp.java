package org.regeneration.bookshelf;

import org.regeneration.bookshelf.model.Book;
import org.regeneration.bookshelf.model.BookDetail;
import org.regeneration.bookshelf.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookshelfApp implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(BookshelfApp.class);

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args )
    {
        SpringApplication.run(BookshelfApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // save a couple of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book A", new BookDetail(49)));
        books.add(new Book("Book B", new BookDetail(59)));
        books.add(new Book("Book C", new BookDetail(69)));
        bookRepository.saveAll(books);

        // fetch all books
        for (Book book : bookRepository.findAll()) {
            logger.info(book.toString());
        }

    }
}
