package com.evan.wj.service;

import com.evan.wj.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    Category get(int id);
}
