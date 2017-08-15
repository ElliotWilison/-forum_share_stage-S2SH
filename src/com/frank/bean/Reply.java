package com.frank.bean;

import java.util.Date;

public class Reply {
	private int Id;
	private int topicID;
	private String content;
	private Date date;
	private User user;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
