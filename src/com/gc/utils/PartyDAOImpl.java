package com.gc.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.gc.model.PartyDTO;


@Repository  
public class PartyDAOImpl implements PartyDAO {

	// List operates as a local DB
	List<PartyDTO> parties;
	
	
	
	public PartyDAOImpl(List<PartyDTO> parties) {		
		}

	@Override
	public List<PartyDTO> getAllParties() {
		
		return null;
	}

	@Override
	public PartyDTO getParty(int partyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParty(PartyDTO party) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteParty(PartyDTO party) {
		// TODO Auto-generated method stub

	}

}
