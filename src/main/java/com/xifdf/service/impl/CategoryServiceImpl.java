package com.xifdf.service.impl;

import com.xifdf.mapper.CategoryMapper;
import com.xifdf.pojo.Category;
import com.xifdf.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.listCategory();
    }
}
