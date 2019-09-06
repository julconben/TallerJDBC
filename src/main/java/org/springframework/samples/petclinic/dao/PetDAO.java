package org.springframework.samples.petclinic.dao;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Repository;

@Repository
public class PetDAO extends AbstractJpaDAO<Pet, Integer> implements IPetDAO {

    public PetDAO() {
        super();

        setClazz(Pet.class);
    }

}
