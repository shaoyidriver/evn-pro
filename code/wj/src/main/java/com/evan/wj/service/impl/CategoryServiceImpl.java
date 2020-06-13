package com.evan.wj.service.impl;

import com.evan.wj.dao.CategoryDao;
import com.evan.wj.pojo.Category;
import com.evan.wj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> list() {
        // springboot2.1版本以上 Sort已经不能用 new 实例化了,可以使用静态的by()方法
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    @Override
    public Category get(int id) {
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
