package com.ftj.service;

import com.ftj.pojo.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by fengtj on 2021/8/21 15:55
 */
public interface BookService {

    Page<Book> getBookList(Integer page, Integer size);

    Book save(Book book);

    Book findBookById(Integer id);

    Book update(Integer id, Book book);

    void deleteBookById(Integer id);
}