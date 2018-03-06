package com.gc.utils;

import java.util.List;

import com.gc.model.Party;

public interface PartyDAO {
	
	public List<Party> getAllParties();
	   public Party getParty(int partyID);
	   public void updateParty(Party party);
	   public void deleteParty(Party party);

}
