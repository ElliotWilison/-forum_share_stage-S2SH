package com.frank.servicelmpl;

import java.util.List;

import com.frank.DAO.TopicDAO;
import com.frank.bean.Topic;
import com.frank.service.TopicService;

public class TopicServicelmpl implements TopicService {

	private TopicDAO topicDAO;

	@Override
	public TopicDAO getTopicDAO() {
		// TODO Auto-generated method stub
		return topicDAO;
	}

	@Override
	public void setTopicDAO(TopicDAO topicDAO) {
		// TODO Auto-generated method stub
		this.topicDAO = topicDAO;
	}

	@Override
	public boolean saveTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDAO.addTopic(topic);
		return true;
	}

	@Override
	public boolean deleteTopic(int topicID) {
		// TODO Auto-generated method stub
		topicDAO.deleteTopic(topicID);
		return true;
	}

	@Override
	public Topic findTopicById(int topicID) {
		// TODO Auto-generated method stub
		Topic topic = topicDAO.findTopicById(topicID);
		return topic;
	}

	@Override
	public List<Topic> findTopicsBySubItemID(int subItemID) {
		// TODO Auto-generated method stub
		List<Topic> list = topicDAO.findTopicsBySubItemID(subItemID);
		return list;
	}

	@Override
	public boolean updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDAO.updateTopic(topic);
		return true;
	}

	@Override
	public List<Topic> findAllTopics() {
		// TODO Auto-generated method stub
		List<Topic> list=topicDAO.findAllTopics();
		return list;
	}

	@Override
	public List<Topic> findTopicsByKeyWords(String keyWords) {
		// TODO Auto-generated method stub
		List<Topic> list=topicDAO.findTopicsbByKetWords(keyWords);
		return list;
	}

}
