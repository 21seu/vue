package com.ftj.controller;

import com.ftj.pojo.Book;
import com.ftj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fengtj on 2021/8/21 15:49
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        return bookService.getBookList(page, size);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        Book b = bookService.save(book);
        if (b != null) return "success";
        else return "fail";
    }

    @GetMapping("/find/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findBookById(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book) {
        Book b = bookService.update(book.getId(), book);
        if (b != null) return "success";
        else return "fail";
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        bookService.deleteBookById(id);
    }
}
