package com.fh.book.po;

import com.fh.common.Page;
import lombok.Data;

@Data
public class BookPage extends Page {

    private String bookName;
    private Float maxprice;
    private Float minprice;
}
