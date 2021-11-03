package com.jjh.bookstore.mongo;

import com.jjh.bookstore.domain.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoRepository extends MongoRepository<Book, String> {
    @DeleteQuery
    void deleteByIsbn(String isbn);
}
