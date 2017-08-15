package com.frank.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;
import com.frank.service.UserService;
import com.frank.sessionfcty.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.Application;

public class UserInputAction extends ActionSupport {
	private UserService userService;
private String username;
private String pwd;
private String re_pwd;
	
	
	public String getRe_pwd() {
	return re_pwd;
}

public void setRe_pwd(String re_pwd) {
	this.re_pwd = re_pwd;
}

	public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	List<Topic> topics=(List<Topic>) ServletActionContext.getRequest().getSession().getAttribute("AllTopics");
//	List<item> items=userService.
	if(re_pwd==null)
	{
		User user=userService.getUser(username, pwd);
		List<Item> items=userService.getUserItemsByUserId(user.getUserID());
		List<SubItem> subItems=userService.getSubItemsByUserId(user.getUserID());
		if(user!=null)
		{
		System.out.println("success");
		ServletActionContext.getRequest().getSession().setAttribute("User", user);
		ServletActionContext.getRequest().getSession().setAttribute("Items", items);
		ServletActionContext.getRequest().getSession().setAttribute("SubItems", subItems);
		ServletActionContext.getRequest().getSession().setAttribute("AllTopics", topics);
		return "success";
		}
		else
		{
			System.out.println("erro");
			return "erro";
		}
		
	}
	else
	{
		System.out.println("erro");
		User newUser=new User();
		 newUser.setAge(20);
		 newUser.setIntegral(1);
		 newUser.setSex("ÄÐ");
		 newUser.setPopedom(1);
		 newUser.setUsername(username);
		 newUser.setPassword(re_pwd);
		userService.saveUser(newUser);
		return "erro";
		
	}
	
	
}
}
