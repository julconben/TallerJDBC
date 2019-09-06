package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDAO extends AbstractJpaDAO<Visit, Integer> implements IVisitDAO {
	
	public VisitDAO() {
        super();

        setClazz(Visit.class);
	
	}
}
