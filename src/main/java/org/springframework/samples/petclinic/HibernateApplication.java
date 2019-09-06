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
	private BillDAO billDao;
	@Autowired
	private PetDAO PetDao;
	@Autowired
	private OwnerDAO OwnerDao;
	@Autowired
	private VisitDAO VisitDao;
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
		System.out.println("\n\nTESTING\n_________________________________________________________\n\n");
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());
		
//		for(Visit v : visits) {
//			System.out.println(v.toString());
//		}

		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas visitas
		 */
		
		List<Visit> vList = VisitDao.findAll();
		System.out.println("Visitas do pet com id 8");
		for( Visit v : vList) {
			if( v.getPetId()==8)
			System.out.println(v.toString());
		}
		
		// TODO
		

		
		Bill b = new Bill();
		b.setIdNumber(234567890);
		b.setMoney(20.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		listaFacturas = billRepository.save(listaFacturas);
		
		List<BillLine> bLineList = new ArrayList<>();
		BillLine bl1 = new BillLine();
		BillLine bl2 = new BillLine();
		
//		bl1.setIdBill(b);
//		bl2.setIdBill(b);
//		bl1.setDetails("This line tests the");
//		bl2.setDetails("BillLine implementation");
//		
//		bLineList.add(bl1);
//		bLineList.add(bl2);
//		
//		b.setBillLines(bLineList);
//		
//		billDao.create(b);
//		
//		System.out.println("Test a BillLine:***************************************");
//		b.printAllDetails();
//
//		//billRepository.delete(b); TODO
//		
//		
//		for(Bill bi : listaFacturas ) {
//			System.out.println(bi.toString());
//		}
//		visits.get(0).setBill(b);
//		visitRepository.save(visits.get(0));
//		
//
//		p = petRepository.findById(8);
//		visits = visitRepository.findByPetId(p.getId());
//		for(Visit v : visits) {
//			System.out.println(v.toString());
//		}
	}
}
