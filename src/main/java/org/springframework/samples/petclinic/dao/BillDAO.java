package org.springframework.samples.petclinic.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAO extends AbstractJpaDAO<Bill, Integer> implements IBillDAO {

    public BillDAO() {
        super();

        setClazz(Bill.class);
    }

    public List<Bill> getBIllsByIdNumber(long idNumber) {
        return getEntityManager().createQuery("select b from Bill b where b.idNumber= " + idNumber).getResultList();

    }
    // API

    public List<Bill> getBIllsByIdNumberNamedQuery(long idNumber) {
        return getEntityManager().createQuery("Select f from Bill f where id_number = " + idNumber).getResultList();
    }

}
