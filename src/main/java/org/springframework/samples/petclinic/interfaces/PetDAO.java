package org.springframework.samples.petclinic.interfaces;

import org.springframework.samples.petclinic.owner.Bill;

public class PetDAO extends AbstractJpaDAO<Bill, Integer> implements IPetDAO{

	@Override
	public void deletebyId(Integer entityId) {
		// TODO Auto-generated method stub
		
	}

}
