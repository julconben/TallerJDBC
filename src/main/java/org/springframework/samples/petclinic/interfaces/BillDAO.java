package org.springframework.samples.petclinic.interfaces;

import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.stereotype.Repository;



@Repository
public class BillDAO extends AbstractJpaDAO<Bill, Integer> implements IBillDAO {
	
	 public BillDAO() {
	        super();

	        setClazz(Bill.class);
	    }

	@Override
	public void deletebyId(Integer entityId) {
		// TODO Auto-generated method stub
		
	}


	

}
