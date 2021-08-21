package com.ftj.controller;

import com.ftj.pojo.Book;
import com.ftj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengtj on 2021/8/21 15:49
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.getBookList();
    }
}
