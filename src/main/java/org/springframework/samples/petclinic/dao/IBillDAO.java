package org.springframework.samples.petclinic.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Bill;

public interface IBillDAO extends IBaseDAO<Bill, Integer> {

    List<Bill> getBIllsByIdNumber(long idNumber);

    List<Bill> getBIllsByIdNumberNamedQuery(long idNumber);

}
