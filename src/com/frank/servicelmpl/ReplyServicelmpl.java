package com.frank.servicelmpl;

import java.util.List;

import com.frank.DAO.ReplyDAO;
import com.frank.bean.Reply;
import com.frank.bean.Topic;
import com.frank.service.ReplyService;

public class ReplyServicelmpl implements ReplyService {

	private ReplyDAO replyDAO;

	@Override
	public ReplyDAO getReplyDAO() {
		// TODO Auto-generated method stub
		return replyDAO;
	}

	@Override
	public void setReplyDAO(ReplyDAO replyDAO) {
		// TODO Auto-generated method stub
		this.replyDAO = replyDAO;

	}

	@Override
	public boolean saveReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDAO.addReply(reply);
		return true;
	}

	@Override
	public boolean deleteReply(int Id) {
		// TODO Auto-generated method stub
		replyDAO.deleteReply(Id);
		return true;
	}

	@Override
	public Reply findReplyById(int Id) {
		// TODO Auto-generated method stub
		Reply reply = replyDAO.findReplyById(Id);
		return reply;
	}

	@Override
	public List<Reply> findRepliesByTopicID(int topicID) {
		// TODO Auto-generated method stub
		List<Reply> list = replyDAO.findReplyByTopicID(topicID);
		return list;
	}

	@Override
	public Topic findTopicByID(int topicID) {
		// TODO Auto-generated method stub
		Topic topic=replyDAO.findTopicById(topicID);
		return topic;
	}

}
