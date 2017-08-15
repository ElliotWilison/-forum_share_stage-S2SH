package com.frank.DAO;

import java.util.List;

import com.frank.bean.Reply;
import com.frank.bean.Topic;

public interface ReplyDAO {
	public List<Reply> findReplyByTopicID(int topicID);

	public void addReply(Reply reply);

	public void deleteReply(int Id);

	public Reply findReplyById(int Id);
	
	public Topic findTopicById(int topicID);
}
