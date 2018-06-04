package com.booksystem.action;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booksystem.mybatis.entities.Book;
import com.booksystem.mybatis.entities.User;
import com.booksystem.service.BookService;
import com.booksystem.tool.PageInfo;
import com.booksystem.tool.SelectExcel;

@Controller
public class BookAction{
	
	//对书籍进行排序，默认是根据借阅次数
	private String order="book_lendtimes";
	
	//分页显示的集合
	PageInfo<Book> pageInfo=null;
	
	private Book book;
	
	@Autowired
	private SelectExcel selectExcel;
	
	@Autowired
	private BookService bookService;
	
	//根据指定条件查询书籍，并且响应指定页面
	@RequestMapping("/book_findbook")
	public String findbook(@RequestParam(value="pageNo",required=false,defaultValue="1") int pageNo,
			Map<String,Object> map){
		System.out.println("sfindbook");
		System.out.println(bookService);
		System.out.println(pageNo);
		System.out.println(order);
		pageInfo = bookService.getBookByOrder(pageNo,order);
		map.put("pageInfo", pageInfo);
		System.out.println("efindbook");
		return "student/showbook";
	}
	
	//根据书籍类型，降序显示，分页显示
	@RequestMapping("/book_selectByBookTypes")
	public String selectByBookTypes(@RequestParam(value="pageNo",required=false,defaultValue="1") int pageNo,
			@RequestParam(value="type") String type,
			@RequestParam(value="value") String value,
			Map<String,Object> map) throws IOException{
		System.out.println("sselectByBookTypes");
		//解决中文乱码
		value=new String(value.getBytes("ISO-8859-1"), "UTF-8"); 
		pageInfo = bookService.selectByBookTypes(pageNo, type, value);
		map.put("pageInfo", pageInfo);
		map.put("type", type);
		map.put("value", value);		
		System.out.println("eselectByBookTypes");
		return "student/showbook";
	}

	//根据书籍id号获取指定书籍
	@RequestMapping("/book_findBookByPrimaryKey")
	public String findBookByPrimaryKey(@RequestParam(value="bookId") String bookId,
			Map<String,Object> map){
		System.out.println("sfindBookByPrimaryKey");
		book = bookService.getBookByPrimaryKey(bookId);
		map.put("book", book);
		System.out.println("efindBookByPrimaryKey");
		return "student/bookdetails";
	}
	
	//模糊查询
	@RequestMapping("/book_selectBookBySearch")
	public String selectBookBySearch(@RequestParam(value="pageNo",required=false,defaultValue="1") int pageNo,
			@RequestParam(value="value")String value,
			@RequestParam(value="type") String type,
			Map<String,Object> map){
		System.out.println("sselectBookBySearch");
		pageInfo = bookService.selectBookBySearch(pageNo, type, value);
		map.put("pageInfo", pageInfo);
		map.put("type", type);
		map.put("value", value);	
		System.out.println("eselectBookBySearch");
		return "student/showbook";
	}
	
	
	
	
	@RequestMapping("book_findbookByAjax")
	@ResponseBody
	public PageInfo<Book> findbookByAjax(
			@RequestParam(value="pageNoStr",required=false,defaultValue="1") int pageNoStr
			){
		System.out.println("sfindbookByAjax");
		//默认使用借阅次数排序
		order="book_lendtimes";
		pageInfo = bookService.getBookByOrder(pageNoStr,order);
		System.out.println(pageInfo);
		System.out.println("efindbookByAjax");
		return pageInfo;
	}	
	
	@RequestMapping("/{path}")
	public String doAction(@PathVariable("path") String path,Map<String,Object> map){
		System.out.println("sdoAction");
		if("book_search".equals(path)){
			return "student/searchBook";
		}else if("login".equals(path)){
			map.put("user", new User());
			return "login";
		}else if("toAdmin".equals(path)){
			System.out.println("stoAdmin");
			List<String> bookPublihList=new ArrayList<String>();
			bookPublihList.add("人民出版社");
			bookPublihList.add("译林出版社");
			bookPublihList.add("中华书局");
			bookPublihList.add("社科文献出版社");
			map.put("bookPublihList", bookPublihList);
			List<String> bookStyleList=new ArrayList<String>();
			bookStyleList.add("文学");
			bookStyleList.add("军事");
			bookStyleList.add("科技");
			bookStyleList.add("医学");
			bookStyleList.add("法律");
			map.put("bookStyleList", bookStyleList);
			map.put("book", new Book());
			return "admin/manages";
		}
		return null;
	}
	
	
	//下载Excel
	@RequestMapping("book_downLoadToExcele")
	public ResponseEntity<byte[]> downLoadToExcele(
			HttpServletRequest request) throws IOException{
		System.out.println("sdownLoadToExcele");
		String path = request.getSession().getServletContext().getRealPath("/file");
		String fileName="/allBook.xls";
		String realPath=path+fileName;
		selectExcel.createExcel(realPath);
		HttpHeaders headers = new HttpHeaders();  
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		headers.setContentDispositionFormData("attachment", "allBook.xls");
		byte[] fileData = FileCopyUtils.copyToByteArray(new FileInputStream(realPath));
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(fileData,headers,HttpStatus.CREATED);
		System.out.println("edownLoadToExcele");
		return responseEntity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
