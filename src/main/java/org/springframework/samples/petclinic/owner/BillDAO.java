package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BillDAO extends AbstractJpaDAO<Bill, Integer> implements IBillDAO {

    public BillDAO() {
        super();

        setClazz(Bill.class);
    }

	@Override
	public Bill update() {
		// TODO Auto-generated method stub
		return null;
	}
}