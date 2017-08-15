package com.frank.service;

import java.util.List;

import com.frank.DAO.TopicDAO;
import com.frank.bean.Topic;

public interface TopicService {
	public TopicDAO getTopicDAO();

	public void setTopicDAO(TopicDAO topicDAO);

	public boolean saveTopic(Topic topic);

	public boolean deleteTopic(int topicID);

	public Topic findTopicById(int topicID);

	public boolean updateTopic(Topic topic);

	public List<Topic> findTopicsBySubItemID(int subItemID);
	
	public List<Topic> findAllTopics();
	
	public List<Topic> findTopicsByKeyWords(String keyWords);
}
