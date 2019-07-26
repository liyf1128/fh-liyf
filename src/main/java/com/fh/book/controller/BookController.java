package com.fh.book.controller;

import com.fh.shop.api.book.biz.IBookService;
import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.po.BookPage;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Resource(name = "bookService")
    private IBookService bookService;

    //新增
    @RequestMapping(method = RequestMethod.POST)
    public ServerResponse addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ServerResponse.success();
    }

    //删除
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ServerResponse deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return ServerResponse.success();
    }

    //修改
    @RequestMapping(method = RequestMethod.PUT)
    public ServerResponse updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return ServerResponse.success();
    }

    //回显
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ServerResponse toUpdateBook(@PathVariable long id){
        Book book = bookService.toUpdateBook(id);
        return ServerResponse.success(book);
    }

    //分页
    @RequestMapping(method = RequestMethod.GET)
    public ServerResponse queryBook(BookPage bookPage){
        Map bookPages = bookService.queryBook(bookPage);
        return ServerResponse.success(bookPages);
    }

    //批量删除
    @RequestMapping(value = "/batch/{id}",method = RequestMethod.DELETE)
    public ServerResponse deleteAll(@PathVariable String id){
        bookService.deleteAll(id);
        return ServerResponse.success();
    }
}
