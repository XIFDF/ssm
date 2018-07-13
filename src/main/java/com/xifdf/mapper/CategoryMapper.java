package com.xifdf.mapper;
 
import java.util.List;

import com.xifdf.pojo.Category;

public interface CategoryMapper {
 
      
    int add(Category category);
       
      
    void delete(int id);
       
      
    Category get(int id);
     
      
    int update(Category category);
       
      
    List<Category> list();
      
}