package com.evan.wj.service.impl;

import com.evan.wj.dao.BookDao;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import com.evan.wj.service.BookService;
import com.evan.wj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Book> list() {
        return bookDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public List<Book> search(String keyWords) {
        return bookDao.findAllByTitleLikeOrAuthorLike("%"+keyWords+"%","%"+keyWords+"%");
    }

    @Override
    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
