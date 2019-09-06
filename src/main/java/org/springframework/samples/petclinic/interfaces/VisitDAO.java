package org.springframework.samples.petclinic.interfaces;

import org.springframework.samples.petclinic.owner.Bill;

public class VisitDAO extends AbstractJpaDAO<Bill, Integer> implements IVisitDAO{

	@Override
	public void deletebyId(Integer entityId) {
		// TODO Auto-generated method stub
		
	}

}
