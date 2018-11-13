package org.regeneration.controllers;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.regeneration.Application;
import org.regeneration.models.Book;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
    }

    @Test
    public void testGetAllBooks() throws JSONException {
        ResponseEntity<String> response =
                restTemplate.getForEntity(createURLWithPort("/books"), String.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        String expected = "[" +
                "{ 'id' : 1, 'title' : 'The Grapes of Wrath', 'isbn' : '0143125508' }," +
                "{ 'id' : 2, 'title' : 'Symposium', 'isbn' : '0872200760' }," +
                "{ 'id' : 3, 'title' : 'Pride and Prejudice', 'isbn' : '0486284735' }," +
                "{ 'id' : 4, 'title' : 'The Great Gatsby', 'isbn' : '9780141182636' }" +
                "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }


    @Test
    public void testGetAllBooksInArray() throws JSONException {
        ResponseEntity<Book[]> response = restTemplate.getForEntity(createURLWithPort("/books"), Book[].class);
        List<Book> books = Arrays.asList(response.getBody());

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(books.size()).isEqualTo(4);
    }

    @Test
    @Ignore("TODO")
    public void testGetBookById() {
        Long bookId = 3l;
        ResponseEntity<Book> response = null;

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().getTitle()).isEqualTo("Pride and Prejudice");
    }

    @Test
    @Ignore("TODO")
    public void testAddNewBook() {
        Book newBook = new Book();
        newBook.setTitle("The Lord of the Rings");
        newBook.setIsbn("9780544003415");

        ResponseEntity<Book> response = null;

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().getTitle()).isEqualTo("The Lord of the Rings");
        assertThat(response.getBody().getIsbn()).isEqualTo("9780544003415");
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(5l);
    }

    @Test
    public void deleteBook() {
        Long bookId = 5l;
        restTemplate.delete(createURLWithPort("/books/{bookId}"), bookId, Void.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}