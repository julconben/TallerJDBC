package org.springframework.samples.petclinic;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.dao.BillDAO;
import org.springframework.samples.petclinic.dao.PetDAO;
import org.springframework.samples.petclinic.dao.VisitDAO;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.VisitRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BillDAO billDAO;
    @Autowired
    private PetDAO petDAO;
    @Autowired
    private VisitDAO visitDAO;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) {

        System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");

        Bill b = new Bill();
        b.setIdNumber(954);
        b.setMoney(4.0);
        b.setPaymentDate(new Date());

        billDAO.create(b);

        Bill b2 = new Bill();
        b2.setIdNumber(955);
        b2.setMoney(5.0);
        b2.setPaymentDate(new Date());

        billDAO.create(b2);

        Bill b3 = new Bill();
        b3.setIdNumber(956);
        b3.setMoney(6.0);
        b3.setPaymentDate(new Date());

        billDAO.create(b3);

        Bill b4 = new Bill();
        b4.setIdNumber(954);
        b4.setMoney(7.0);
        b4.setPaymentDate(new Date());

        billDAO.create(b4);

        List<Bill> bills = billDAO.getBIllsByIdNumber(954);

        for (Bill bill : bills) {
            System.out.println("Consulta con Id 954 . Bill recuperada con ID  " + bill.getId() + " y money " + bill.getMoney());
        }

        List<Bill> billsNamedQuery = billDAO.getBIllsByIdNumberNamedQuery(954);
        for (Bill billNamed : billsNamedQuery) {
            System.out.println(
                    "Consulta namedQuery con Id 954 . Bill recuperada con ID " + billNamed.getId() + " y money " + billNamed.getMoney());
        }

        List<Bill> Allbills = billDAO.findAll();
        System.out.println("Bills totales recuperadas");
        for (Bill billAux : Allbills) {
            System.out.println(
                    "Bill recuperada con PK " + billAux.getId() + " IdNumber " + billAux.getIdNumber() + " y money " + billAux.getMoney());
        }
    }

}
