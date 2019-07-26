package com.fh.book.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 941095945312820110L;
    private long id;
    private String bookName;
    private Float price;
}
