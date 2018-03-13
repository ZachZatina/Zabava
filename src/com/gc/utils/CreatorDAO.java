package com.gc.utils;

import java.util.List;

import com.gc.model.CreatorDTO;

public interface CreatorDAO {
	
	public List<CreatorDTO> getAllCreators();
	   public CreatorDTO getCreator(int creatorID);
	   public void updateCreator(CreatorDTO creator);
	   public void deleteCreator(CreatorDTO creator);

}