package org.springframework.samples.petclinic.interfaces;

import org.springframework.samples.petclinic.owner.Bill;

public class OwnerDAO extends AbstractJpaDAO<Bill, Integer> implements IOwnerDAO{

	@Override
	public void deletebyId(Integer entityId) {
		// TODO Auto-generated method stub
		
	}

}
