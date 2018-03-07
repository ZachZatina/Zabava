package com.gc.utils;

import java.util.List;

import com.gc.model.TaskDTO;

public interface TaskDAO {

	   public List<TaskDTO> getAllTasks();
	   public TaskDTO getTask(int taskID);
	   public void saveTask(TaskDTO task);
	   public void updateTask(TaskDTO task);
	   public void deleteTask(TaskDTO task);
}
