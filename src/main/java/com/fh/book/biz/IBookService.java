package com.fh.book.biz;

import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.po.BookPage;

import java.util.Map;

public interface IBookService {
    void addBook(Book book);

    void deleteBook(long id);

    void updateBook(Book book);

    Book toUpdateBook(long id);

    Map queryBook(BookPage bookPage);

    void deleteAll(String id);
}
