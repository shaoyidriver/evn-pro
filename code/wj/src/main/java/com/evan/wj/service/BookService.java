package com.evan.wj.service;

import com.evan.wj.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> list();
    void addOrUpdate(Book book);
    void deleteById(int id);
    List<Book> listByCategory(int cid);
}
