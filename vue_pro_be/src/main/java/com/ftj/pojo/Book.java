package com.ftj.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by fengtj on 2021/8/21 15:37
 */
@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;
}
