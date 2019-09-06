package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDAO extends AbstractJpaDAO<Owner, Person> implements IOwnerDAO {
////Should the stuff above be type Person or int as it was before? and if neither where do you even check for the right type
    public OwnerDAO() {
        super();

        setClazz(Owner.class);
    }

}
