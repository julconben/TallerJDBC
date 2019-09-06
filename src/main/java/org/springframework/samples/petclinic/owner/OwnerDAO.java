package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Repository;

@Repository
public class OwnerDAO extends AbstractJpaDAO<Owner, Integer> implements IOwnerDAO{
	public OwnerDAO() {
        super();

        setClazz(Owner.class);
    }
}
