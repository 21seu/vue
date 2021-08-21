package com.ftj.service.impl;

import com.ftj.pojo.Book;
import com.ftj.repository.BookRepository;
import com.ftj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengtj on 2021/8/21 16:01
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
