package com.gc.utils;

import java.util.List;

import com.gc.model.QuestDTO;

public interface QuestDao {
	
	/*
	 * 
	 * Handles all CRUD operations
	 */

	   public List<QuestDTO> getAllQuests();
	   public QuestDTO getQuest(int questId);
	   public void saveQuest(QuestDTO quest);
	   public void updateQuest(QuestDTO quest);
	   public void deleteQuest(QuestDTO quest);
}
