package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerDAO;
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
	private OwnerDAO ownerDAO;
	@Autowired
	private PetDAO petDAO;
	@Autowired
	private VisitDAO visitDAO;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
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
		b.setIdNumber(1234567890);
		b.setMoney(1.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		listaFacturas = billRepository.save(listaFacturas);
		
		visits.get(0).setBill(b);
		visitRepository.save(visits.get(0));

		p = petRepository.findById(8);
		// Crear una factura, y asignársela a la visita 2 (que estará asociada a la mascota 8
		visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			// Imprimir sus "faturas" asociadas si las tuviese, si no, imprimir "No existe"
			System.out.println(v.toString());
		}
						
		// billRepository.delete(billRepository.findOne(75));
		
		// Imprimir todas las visitas de la mascota que tiene id=8
//		Pet pet = petDAO.findOne(8);
//		List<Visit> visitas = pet.getVisits();
		for (Visit visit : petDAO.findOne(8).getVisits()) {
			System.out.println(visit);
		}
		
		// Imprimir sus "faturas" asociadas si las tuviese, si no, imprimir "No existe"
		
		// Crear una factura, y asignársela a la visita 2 (que estará asociada a la mascota 8
		Bill b1 = new Bill();
		b1.setIdNumber(1234567891);
		b1.setMoney(2.0);
		b1.setPaymentDate(new Date());
		visitDAO.findOne(2).setBill(b1);
		
		// Persistir los datos en la BD
		billDAO.create(b1);
		
		
	}
}
