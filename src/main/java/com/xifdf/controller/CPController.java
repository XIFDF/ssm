package com.xifdf.controller;

import com.alibaba.fastjson.JSONObject;
import com.xifdf.pojo.Category;
import com.xifdf.pojo.Product;
import com.xifdf.service.CategoryService;
import com.xifdf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CPController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;

    @ResponseBody
    @RequestMapping("/listCategory")
    public String listCategory(){
        List<Category> categorys = categoryService.list();
        return JSONObject.toJSON(categorys).toString();
    }

    @ResponseBody
    @RequestMapping("/listProduct")
    public String listProduct(){
        List<Product> products = productService.list();
        return JSONObject.toJSON(products).toString();
    }

}
