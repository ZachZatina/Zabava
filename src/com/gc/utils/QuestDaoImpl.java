package com.gc.utils;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.Quest;

public class QuestDaoImpl implements QuestDao {

	List<Quest> quests;
	
	public QuestDaoImpl() {
		quests = new ArrayList<Quest>();
	// FIXME: 	
	}
	
	@Override
	public List<Quest> getAllQuests() {
		return null;
	}

	@Override
	public Quest getQuest(int questId) {
		return null;
	}

	@Override
	public void updateQuest(Quest quest) {
	// FIXME: 
		quests.get(quest.getQuestId()).setLocation(quest.getLocation());
		
		System.out.println("Quest: QuestID " + quest.getQuestId() + ", updated in the database");
	}

	@Override
	public void deleteQuest(Quest quest) {
		quests.remove(quest.getQuestId());
		System.out.println("Quest: QuestID " + quest.getQuestId() + ", deleted from database");

	}

}
