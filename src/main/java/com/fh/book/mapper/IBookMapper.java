package com.fh.book.mapper;

import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.po.BookPage;

import java.util.List;

public interface IBookMapper {
    void addBook(Book book);

    void deleteBook(long id);

    void updateBook(Book book);

    Book toUpdateBook(long id);

    long bookPageCount(BookPage bookPage);

    List<Book> queryBook(BookPage bookPage);

    void deleteAll(String[] split);
}
