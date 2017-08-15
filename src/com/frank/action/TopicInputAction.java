package com.frank.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;
import com.frank.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

public class TopicInputAction extends ActionSupport {

	private TopicService topicService;
	private int subItemID;
	private int topicID;
	private String topic;
	private String content;
	private int update;
	private int delete;
	private String searchKey;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int update) {
		this.update = update;
	}

	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSubItemID() {
		return subItemID;
	}

	public void setSubItemID(int subItemID) {
		this.subItemID = subItemID;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String flag="success";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("User");
		List<SubItem> subItems = (List<SubItem>) ServletActionContext.getRequest().getSession()
				.getAttribute("SubItems");
		List<Topic> allTopics = topicService.findAllTopics();
		if (searchKey != null) {
			ServletActionContext.getRequest().getSession().setAttribute("User", user);
			List<Topic> searchedTopics=topicService.findTopicsByKeyWords(searchKey);
			ServletActionContext.getRequest().getSession().setAttribute("STopics", searchedTopics);
			return "search";
		}

		if (user != null) {

			if (update == 1) {
				Topic utopic = topicService.findTopicById(topicID);
				ServletActionContext.getRequest().getSession().setAttribute("UTopic", utopic);
				return "edit";

			}
			if (update == 2) {
				Topic t = new Topic();
				t.setTopicID(topicID);
				t.setSubItemID(subItemID);
				t.setTopic(topic);
				t.setContent(content);
				topicService.updateTopic(t);
			}

			if (delete == 1) {
				topicService.deleteTopic(topicID);

				flag = "edit";
			}

			if (topic != null & update == 0) {
				// final Format format = new SimpleDateFormat("yyyy-MM-dd
				// hh:mm:ss");
				Date date = new Date();
				// String d=format.format(date);
				// System.out.println(format.format(date));
				Topic newtopic = new Topic();
				newtopic.setTopic(topic);
				newtopic.setContent(content);
				newtopic.setHasread(0);
				newtopic.setDate(date);
				newtopic.setSubItemID(subItemID);
				newtopic.setUser(user);
				topicService.saveTopic(newtopic);
				System.out.println(newtopic.getDate());
			}
			List<Topic> topics = topicService.findTopicsBySubItemID(subItemID);
			ServletActionContext.getRequest().getSession().setAttribute("SubItems", subItems);
			ServletActionContext.getRequest().getSession().setAttribute("User", user);
			ServletActionContext.getRequest().getSession().setAttribute("Topics", topics);
			ServletActionContext.getRequest().getSession().setAttribute("AllTopics", allTopics);
			
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("AllTopics", allTopics);
			System.out.println("login out");
			flag = "all";
		}

		return flag;
	}

}
