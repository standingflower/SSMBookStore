package com.booksystem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.booksystem.mybatis.entities.Book;
import com.booksystem.mybatis.entities.User;
import com.booksystem.service.UserService;


@SessionAttributes(value={"user"})
@Controller
public class UserAction {

	
	@Autowired
	private UserService userService;
		
	
	@ModelAttribute
	public User getUser(User user){
		if(user==null){
			System.out.println("creatUser");
			user=new User();
		}
		return user;
	}
	
	
	private String res;
	
	@RequestMapping("/user_login")
	public String login(User user,
			Map<String,Object> map){
		System.out.println("slogin");
		System.out.println("login"+user);
		User newUser = userService.login(user);
		System.out.println(newUser);
		if(newUser!=null){
			if(user.getPassword().equals(newUser.getPassword())&&newUser.getUserRole()==user.getUserRole()){
				//登录成功
				map.put("user", newUser);
				//根据用户的不同，返回不同的页面
				if(user.getUserRole()==0){
					//管理员
					System.out.println("elogin");
					map.put("book", new Book());
					return "forward:/toAdmin";
				}
				if(user.getUserRole()==1){
					System.out.println("elogin");
					return "forward:/bookuser_selectRecordByUserId";
				}
			}
		}else{
			res="借阅号或密码错误！";
			map.put("res", res);
			System.out.println("出错退出");
			//登录失败，返回错误信息
			System.out.println("elogin");
			return "/login";
		}
		System.out.println("正常退出");
		System.out.println("elogin");
		return "/login";
	}
	
	
	//解挂操作
	@RequestMapping("/user_unlose")
	@ResponseBody
	public String unlose(@RequestParam(value="userId") String userId,
			HttpServletRequest request){
		System.out.println("sunlose");
		//判断当前操作用户
		User user=(User) request.getSession().getAttribute("user");
		if(user.getUserRole()==0){
			System.out.println(user);
			if(userService.ifLend(userId)>0){
				res="1";
			}else{
				res="0";
			}
		}else{
			res="0";
		}
		System.out.println("eunlose");
		return res;
	}
	
	
	//挂失
	@RequestMapping("/user_lose")
	public String lose(HttpServletRequest request){
		System.out.println("slose");
		//从session中获取user
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("user:"+user);
		//判断用状态
		//当前状态为可借，准备挂失操作
		if(user.getIflend()==0){
			userService.ifLend(user.getUserId());
			user.setIflend(1);
			request.getSession().setAttribute("user", user);
		}
		System.out.println("elose");
		return "forward:/bookuser_selectRecordByUserId";
	}
	
	
}
