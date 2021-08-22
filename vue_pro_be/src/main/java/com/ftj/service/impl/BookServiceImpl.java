package com.ftj.service.impl;

import com.ftj.pojo.Book;
import com.ftj.repository.BookRepository;
import com.ftj.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by fengtj on 2021/8/21 16:01
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getBookList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book update(Integer id, Book book) {
        Book b = findBookById(id);
        BeanUtils.copyProperties(book,b);
        return bookRepository.save(b);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
