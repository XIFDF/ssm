package com.xifdf.mapper;
 
import java.util.List;

import com.xifdf.pojo.Category;

public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category get(int id);  
     
      
    public int update(Category category);   
       
      
    public List<Category> list();
      
}