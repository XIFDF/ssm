package com.xifdf.service.impl;

import com.xifdf.mapper.ProductMapper;
import com.xifdf.pojo.Product;
import com.xifdf.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.listProduct();
    }
}
