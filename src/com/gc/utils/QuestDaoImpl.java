package com.gc.utils;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.QuestDTO;

public class QuestDaoImpl implements QuestDao {

	List<QuestDTO> quests;
	
	public QuestDaoImpl() {
		quests = new ArrayList<QuestDTO>();
	// FIXME: 	
	}
	
	@Override
	public List<QuestDTO> getAllQuests() {
		return null;
	}

	@Override
	public QuestDTO getQuest(int questId) {
		return null;
	}

	@Override
	public void updateQuest(QuestDTO quest) {
	// FIXME: 
		quests.get(quest.getQuestId()).setLocation(quest.getLocation());
		
		System.out.println("Quest: QuestID " + quest.getQuestId() + ", updated in the database");
	}

	@Override
	public void deleteQuest(QuestDTO quest) {
		quests.remove(quest.getQuestId());
		System.out.println("Quest: QuestID " + quest.getQuestId() + ", deleted from database");

	}

	@Override
	public void saveQuest(QuestDTO quest) {
		// TODO Auto-generated method stub
		
	}

}
