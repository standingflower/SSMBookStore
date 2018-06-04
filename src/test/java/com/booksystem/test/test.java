package com.booksystem.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

import com.booksystem.mybatis.entities.Book;
import com.booksystem.service.BookService;
import com.booksystem.tool.PageInfo;


public class test {

	@Test
	public void testBookMapperSelectAllByOrder() throws IOException {
		String realPath="1111.xml";
//		String realPath="G:/123.png";applicationContext.xml
		Resource resource = new ClassPathResource(realPath);
		InputStream inputStream = resource.getInputStream();
		
		byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
		System.out.println(fileData);
	
	}

}
