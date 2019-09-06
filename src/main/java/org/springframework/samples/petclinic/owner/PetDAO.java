package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Repository;

@Repository
public class PetDAO extends AbstractJpaDAO<Pet, Integer> implements IPetDAO{
	public PetDAO() {
		
        super();

        setClazz(Pet.class);
    }

}
