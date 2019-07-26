package com.fh.book.biz;

import com.fh.shop.api.book.mapper.IBookMapper;
import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.po.BookPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bookService")
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(long id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public Book toUpdateBook(long id) {
        return bookMapper.toUpdateBook(id);
    }

    @Override
    public Map queryBook(BookPage bookPage) {
        long count = bookMapper.bookPageCount(bookPage);
        List<Book> bookList = bookMapper.queryBook(bookPage);
        Map map = new HashMap();
        map.put("draw",bookPage.getDraw());
        map.put("totalCount",count);
        map.put("dataList",bookList);
        return map;
    }

    @Override
    public void deleteAll(String id) {
        String[] split = id.split(",");
        bookMapper.deleteAll(split);
    }
}
