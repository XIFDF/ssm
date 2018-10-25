package com.xifdf.test;

import java.util.List;

import com.xifdf.mapper.CategoryMapper;
import com.xifdf.mapper.OrderMapper;
import com.xifdf.mapper.ProductMapper;
import com.xifdf.mapper.UserMapper;
import com.xifdf.pojo.Category;
import com.xifdf.pojo.Order;
import com.xifdf.pojo.Product;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private UserService userService;

	@Resource private ProductMapper productMapper;
    @Resource private CategoryMapper categoryMapper;
	@Resource private UserMapper userMapper;
	@Resource private OrderMapper orderMapper;

	@Test
	public void testAddTwo(){
		userService.addTwo();
	}

	@Test
	public void getProduct(){
		List<Product> products = productMapper.listProduct();
		System.out.println(products.get(0));
	}

	@Test
	public void getCategory(){
		List<Category> categories = categoryMapper.listCategory();
		System.out.println(categories.get(0));
	}

	@Test
	public void getUser(){
		List<User> users = userMapper.list();
		System.out.println(users.get(0));
	}
	@Test
	public void listOrder(){
		List<Order> orders = orderMapper.listOrder();
		System.out.println(orders);
	}
}
