package com.ftj.repository;

import com.ftj.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fengtj on 2021/8/21 15:39
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
