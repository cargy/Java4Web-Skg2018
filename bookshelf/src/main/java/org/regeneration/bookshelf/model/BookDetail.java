package org.regeneration.bookshelf.model;

import javax.persistence.*;

@Entity
@Table(name = "book_detail")
public class BookDetail {
    private Long id;
    private Integer numberOfPages;
    private Book book;

    public BookDetail(){

    }

    public BookDetail(Integer numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number_of_pages")
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @OneToOne(mappedBy = "bookDetail")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
