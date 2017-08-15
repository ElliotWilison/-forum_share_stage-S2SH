package com.frank.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.frank.bean.Item;
import com.frank.bean.Reply;
import com.frank.bean.Topic;
import com.frank.bean.User;
import com.frank.page.Page;
import com.frank.page.PageUtil;
import com.frank.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyInputAction extends ActionSupport {

	public ReplyService ReplyService;
	private int topicID;
	private String content;
	private int userID;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public ReplyService getReplyService() {
		return ReplyService;
	}

	public void setReplyService(ReplyService replyService) {
		ReplyService = replyService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<Reply> replies;
		Topic topic;
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("User");
		List<Item> items = (List<Item>) ServletActionContext.getRequest().getSession().getAttribute("Items");
		
		if(topicID>0)
			{
			 replies = ReplyService.findRepliesByTopicID(topicID);
			 topic = ReplyService.findTopicByID(topicID);
			 System.out.println(topic.getContent());
			}
		else
		{
			replies=(List<Reply>)ServletActionContext.getRequest().getSession().getAttribute("AllReplies");
			topic=(Topic)ServletActionContext.getRequest().getSession().getAttribute("Topic");
		}
		if (userID > 0) {
			if(user!=null)
			{
			Date date=new Date();
			Reply reply = new Reply();
			reply.setContent(content);
			reply.setTopicID(topicID);
			reply.setDate(date);
			reply.setUser(user);
			replies.add(reply);
			ReplyService.saveReply(reply);
			}
		}
		if(user==null&&userID>0)
		{
			return "erro";
		}
		
		Page page=PageUtil.getPage(10, replies.size(), currentPage);
		int endIndex=page.getBeginIndex()+page.getEveryPage();
		if(page.getBeginIndex()+page.getEveryPage()>=page.getTotalCount())
		{
			endIndex=page.getTotalCount();
		}
		List<Reply> subReplies=replies.subList(page.getBeginIndex(),endIndex);
		
		ServletActionContext.getRequest().getSession().setAttribute("User", user);
		ServletActionContext.getRequest().getSession().setAttribute("Replies", subReplies);
		ServletActionContext.getRequest().getSession().setAttribute("Items", items);
		ServletActionContext.getRequest().getSession().setAttribute("Topic", topic);
		ServletActionContext.getRequest().getSession().setAttribute("Page", page);
		ServletActionContext.getRequest().getSession().setAttribute("AllReplies", replies);
		return "success";
	}
}
