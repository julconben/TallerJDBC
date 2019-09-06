package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillDAO;
import org.springframework.samples.petclinic.owner.BillLine;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	
	@Autowired 
	private BillRepository billRepository;
	@Autowired
	private BillDAO billDao;
	@Autowired
	private VisitRepository visitRepository;
	@Autowired
	private PetRepository petRepository;
	
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
		
		List<BillLine> bLineList = new ArrayList<>();
		BillLine bl1 = new BillLine();
		BillLine bl2 = new BillLine();
		
		bl1.setIdBill(b);
		bl2.setIdBill(b);
		bl1.setDetails("This line tests the");
		bl2.setDetails("BillLine implementation");
		
		bLineList.add(bl1);
		bLineList.add(bl2);
		
		b.setBillLines(bLineList);
		
		System.out.println("Test a BillLine:***************************************");
		b.printAllDetails();
		

		
		//billRepository.delete(b); TODO
		
		
		for(Bill bi : listaFacturas ) {
			System.out.println(bi.toString());
		}
		visits.get(0).setBill(b);
		visitRepository.save(visits.get(0));
		

		p = petRepository.findById(8);
		visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
	}
}
