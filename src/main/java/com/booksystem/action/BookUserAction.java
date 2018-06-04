package com.booksystem.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.booksystem.mybatis.entities.Book;
import com.booksystem.mybatis.entities.BookUser;
import com.booksystem.mybatis.entities.User;
import com.booksystem.mybatis.entities.UserAndRecord;
import com.booksystem.service.BookService;
import com.booksystem.service.BookUserService;
import com.booksystem.service.UserService;
import com.booksystem.tool.PageInfo;


@SessionAttributes(value={"user"})
@Controller
public class BookUserAction {

	
	@Autowired
	private BookUserService bookUserService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	private UserAndRecord userAndRecord;
	
	private int resjson;
	
	//根据学生id获取记录
	@RequestMapping("/bookuser_selectRecordByUserId")
	public String selectRecordByUserId(User user,
			@RequestParam(value="pageNo",required=false,defaultValue="1") int pageNo,
			Map<String,Object> map){
		System.out.println("sselectRecordByUserId");
		System.out.println("qwee:"+user);
		PageInfo<BookUser> info = bookUserService.getRecordByUserId(user.getUserId(),pageNo);
		map.put("info", info);
		System.out.println("eselectRecordByUserId");
		return "/student/userdetails";
	}
	
	
	//续借操作(通过json操作),学生操作
	@RequestMapping("bookuser_renew")
	@ResponseBody
	public int renew(@RequestParam(value="userId") String userId,
			@RequestParam(value="bookId") String bookId,
			HttpServletRequest request){
		System.out.println("srenew");
		System.out.println("qwer");
		System.out.println(userId);
		System.out.println(bookId);
		//判断用户是否可借
		User tmpUser = userService.getUser(userId);
		if(tmpUser==null){
			resjson=-2;//未找到指定用户
		}else{
			if(tmpUser.getIflend()==0){
				//获取对象角色
				User tmp=(User)request.getSession().getAttribute("user");
				int res = bookUserService.renew(tmp.getUserRole(), userId, bookId);
				System.out.println(res);
				//续借失败
				if(res==0){
					//当前用户已续借(用户自己续借)
					resjson=0;
				}
				if(res>0){
					//续借成功
					resjson=1;
				}
				if(res<0){
					resjson=-1;//续借失败
				}
				
			}else{
				resjson=2;//当前用户不能续借
			}
		}
		System.out.println("erenew");
		return resjson;
	}
	
	private User user;
	
	//管理员通过输入学生id查询借阅记录，并且获取用户基本信息
	@RequestMapping("bookuser_selectRecordByUserIdByAjax")
	@ResponseBody
	public UserAndRecord selectRecordByUserIdByAjax(@RequestParam(value="userId")String userId,
			@RequestParam(value="pageNoStr",required=false,defaultValue="1") int pageNoStr){
		System.out.println("sselectRecordByUserIdByAjax");
		System.out.println(userId);
		System.out.println(pageNoStr);
		//获取学生
		user = userService.getUser(userId);
		if(user==null){
			resjson=-1;
			return null;
		}else{
			System.out.println(user);
			//获取借阅记录
			PageInfo<BookUser> info = bookUserService.getRecordByUserId(user.getUserId(), pageNoStr);
			//返回需要的数据
			userAndRecord = new UserAndRecord();
			userAndRecord.setUserId(user.getUserId());
			userAndRecord.setUserName(user.getUserName());
			userAndRecord.setIflend(user.getIflend());
			userAndRecord.setBuList(info.getList());
			userAndRecord.setPageNum(info.getPageNum());
			userAndRecord.setPages(info.getPages());
			userAndRecord.setSize(info.getSize());
			userAndRecord.setNextPage(info.getNextPage());
			userAndRecord.setPrePage(info.getPrePage());
			System.out.println("eselectRecordByUserIdByAjax");
		}
		return userAndRecord;
	}	
	
	//借书
	@RequestMapping("bookuser_lendBook")
	@ResponseBody
	public int lendBook(@RequestParam(value="userId") String userId,
			@RequestParam(value="bookId")String bookId
			){
		System.out.println("slendBook");
		System.out.println(user);
		System.out.println(bookId);
		//书籍Id，用户id，结束时间，是否可借
		//根据用户id获取USer，判断是否可借
		User tmpUser = userService.getUser(userId);
		System.out.println(tmpUser);
		if(tmpUser==null){
			//不存在
			resjson=2;
		}else{
			if(tmpUser.getIflend()==0){
				//可借
				//根据书籍id获取图书，判断是否可借
				Book tmpBook = bookService.getBookByPrimaryKey(bookId);
				if(tmpBook.getBookStore()>tmpBook.getBookLend()){
					//库存大于借出数(可借)
					int i = bookUserService.lendBook(userId, bookId);
					if(i==0){
						resjson=1;//借阅成功
					}else{
						resjson=-2;//借阅失败
					}
				}else{
					//所有书籍都被借出
					resjson=0;
				}
			}else{
				//不可借
				resjson=-1;
			}
		}
		System.out.println("elendBook");
		return resjson;
	}
	
	
	//还书
	@RequestMapping("bookuser_returnBook")
	@ResponseBody
	public int returnBook(
			@RequestParam(value="userId") String userId,
			@RequestParam(value="bookId")String bookId){
		System.out.println("sreturnBook");
		User tmpUser = userService.getUser(userId);
		if(tmpUser==null){
			resjson=1;
		}else{
			int res=bookUserService.returnBook(userId, bookId);
			if(res>0){
				resjson=0;//还书成功
			}
			if(res==0){
				resjson=-1;//还书失败
			}
		}
		System.out.println("ereturnBook");
		return resjson;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
