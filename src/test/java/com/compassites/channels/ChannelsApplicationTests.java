package com.compassites.channels;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.compassites.channels.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelsApplicationTests {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void contextLoads() {
	}

}
