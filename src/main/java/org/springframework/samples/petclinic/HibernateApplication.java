package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillDAO;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetDAO;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.owner.VisitDAO;
import org.springframework.samples.petclinic.visit.Visit;
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
	private VisitDAO visitDAO;
	
	@Autowired
	private PetDAO petDAO;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
		
		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas visitas
		 */
		Bill b = new Bill();
		b.setIdNumber(43434343);
		b.setMoney(1.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		listaFacturas = billRepository.save(listaFacturas);
		visits.get(0).setBill(b);
		visitRepository.save(visits.get(0));

		p = petRepository.findById(8);
		visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
		
		////
		System.out.println("////////////////////////////////////");
		//billDAO.create(b);
		
		//visitDAO.findOne(8).getBill();
		 Pet findOne = petDAO.findOne(8);
		List<Visit> visits2 = findOne.getVisits();
		
		for (Visit visit : visits2) {
			
			System.out.println(visit);
			System.out.println(visit.getBill());
		}
		
		
	}
}
