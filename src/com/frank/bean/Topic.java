package com.frank.bean;

import java.util.Date;
import java.util.Set;

public class Topic {
	private int topicID;
	private String topic;
	private String content;
	private User user;
	private int hasread;
	private Date date;
	private int subItemID;
	private Set<Reply> replies;


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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getHasread() {
		return hasread;
	}

	public void setHasread(int hasread) {
		this.hasread = hasread;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




	public int getSubItemID() {
		return subItemID;
	}

	public void setSubItemID(int subItemID) {
		this.subItemID = subItemID;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}
