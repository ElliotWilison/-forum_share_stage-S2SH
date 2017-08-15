package com.frank.DAO;

import java.util.List;

import com.frank.bean.Topic;

public interface TopicDAO {
	public List<Topic> findTopicsBySubItemID(int subItemID);

	public void addTopic(Topic topic);

	public void deleteTopic(int topicID);

	public void updateTopic(Topic topic);

	public Topic findTopicById(int topicID);
	
	public List<Topic> findAllTopics();
	
	public List<Topic> findTopicsbByKetWords(String keyWords);
}
