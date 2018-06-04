package com.booksystem.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.booksystem.mybatis.entities.Book;
import com.booksystem.service.BookService;

@Controller
public class BookCrudAction {
	
	@Autowired
	private BookService bookService;
	
	private String res;
	
	private Book tmp;
	
	private static final String PATH="forward:/toAdmin";
	
	
	
	@RequestMapping("crud_Cbook")
	public String Cbook(Book book,
			@RequestParam("picture") MultipartFile file,
			HttpServletRequest request,
			Map map) throws IllegalStateException, IOException{
		System.out.println("sCbook");
		System.out.println(book);
		//先判断id是否被占用
		tmp = bookService.getBookByPrimaryKey(book.getBookId());
		System.out.println(tmp);
		
		
		if(tmp==null){
			UUID uuid=UUID.randomUUID();
			String pictureFileName = file.getName();
			
			String path=request.getSession().getServletContext().getRealPath("/file");
			//保存到硬盘的路径
			String realPath=path+"/img/bookimg/"+uuid+"-"+pictureFileName;;
			//保存到数据库路径
			String databasePath="file/img/bookimg/"+uuid+"-"+pictureFileName;
			int i = bookService.CBook(book,databasePath);
			if(i>0){
				//保存操作成功
				file.transferTo(new File(realPath));
				res="添加成功！";
			}else{
				res="添加失败！";
			}
		}else{
			res="id以存在!";
		}
		
		map.put("res", res);
		System.out.println("eCbook");
		return PATH;
	}
	
	//查询图书
	@RequestMapping("crud_Rbook")
	public String Rbook(Book book,
			Map map,
			HttpServletRequest request) {
		System.out.println("Rbook");
		System.out.println(book);
		tmp=bookService.getBookByPrimaryKey(book.getBookId());
		System.out.println(tmp);
		System.out.println("111111111111111"+request.getParameter("bookId"));
		if(tmp==null){
			res="未找到指定书籍";
			System.out.println("未找到指定书籍");
			map.put("res", res);
			return PATH;
		}else{
			book = bookService.RBook(book.getBookId());
			map.put("book", book);
			System.out.println("找到了");
			return PATH;
		}
	}
	
	
	//更新图书
	@RequestMapping("crud_Ubook")
	public String Ubook(Book book,
			Map map) {
		System.out.println("Ubook");
		System.out.println(book);
		//判断是有指定的书
		tmp=bookService.getBookByPrimaryKey(book.getBookId());
		
		if(tmp==null){
			res="未找到指定书籍";
			map.put("res", res);
			return PATH;
		}else{
			int i = bookService.Ubook(book);
			if(i>0){
				res="更新成功";
				map.put("res", res);
				return PATH;
			}else{
				res="更新失败";
				map.put("res", res);
				return PATH;
			}
		}
	}
	
	//删除图书
	@RequestMapping("crud_Dbook")
	public String Dbook(Book book,
			Map map) {
		System.out.println("Dbook");
		System.out.println(book);
		tmp=bookService.getBookByPrimaryKey(book.getBookId());
		if(tmp==null){
			res="此书籍不存在";
			map.put("res", res);
			return PATH;
		}else{
			int i = bookService.DBook(book.getBookId());
			if(i>0){
				res="删除成功";
				map.put("res", res);
				return PATH;
			}else{
				res="删除失败！";
				map.put("res", res);
				return PATH;
			}
		}
		
	}






}
