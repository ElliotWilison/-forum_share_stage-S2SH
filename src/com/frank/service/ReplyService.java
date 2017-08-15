package com.frank.service;

import java.util.List;

import com.frank.DAO.ReplyDAO;
import com.frank.bean.Reply;
import com.frank.bean.Topic;

public interface ReplyService {
	public ReplyDAO getReplyDAO();

	public void setReplyDAO(ReplyDAO replyDAO);

	public boolean saveReply(Reply reply);

	public boolean deleteReply(int Id);

	public Reply findReplyById(int Id);

	public List<Reply> findRepliesByTopicID(int topicID);
	
	public Topic findTopicByID(int topicID);
}
