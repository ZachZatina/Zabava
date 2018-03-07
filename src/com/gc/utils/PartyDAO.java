package com.gc.utils;

import java.util.List;

import com.gc.model.PartyDTO;

public interface PartyDAO {
	
	public List<PartyDTO> getAllParties();
	   public PartyDTO getParty(int partyID);
	   public void updateParty(PartyDTO party);
	   public void deleteParty(PartyDTO party);

}
