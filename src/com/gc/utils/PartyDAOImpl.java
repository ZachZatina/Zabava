package com.gc.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.gc.model.Party;


@Repository  
public class PartyDAOImpl implements PartyDAO {

	// List operates as a local DB
	List<Party> parties;
	
	
	
	public PartyDAOImpl(List<Party> parties) {
		parties = new ArrayList<Party>();
		
		}

	@Override
	public List<Party> getAllParties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Party getParty(int partyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParty(Party party) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteParty(Party party) {
		// TODO Auto-generated method stub

	}

}
