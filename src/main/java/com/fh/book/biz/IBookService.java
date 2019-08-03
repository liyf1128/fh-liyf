package com.fh.book.biz;


import com.fh.book.po.Book;
import com.fh.book.po.BookPage;

import java.util.Map;

public interface IBookService {
    void addBook(Book book);

    void deleteBook(long id);

    void updateBook(Book book);

    Book toUpdateBook(long id);

    Map queryBook(BookPage bookPage);

    void deleteAll(String id);
}
