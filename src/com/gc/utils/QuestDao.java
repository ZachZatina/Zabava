package com.gc.utils;

import java.util.List;

import com.gc.model.Quest;

public interface QuestDao {

	   public List<Quest> getAllQuests();
	   public Quest getQuest(int questId);
	   public void updateQuest(Quest quest);
	   public void deleteQuest(Quest quest);
}
