package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import org.springframework.samples.petclinic.interfaces.BillDAO;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.owner.linhasBill;
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
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());
		/*for(Visit v : visits) {
			System.out.println(v.toString());
		}*/
		
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
		visits = visitRepository.findByPetId(p.getId());
		//Imprime visitas 3.2
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
		
		//QUEBRAR a relaçao de fatura e owners
		
		linhasBill linha = new linhasBill();
		linha.setDetails("caixa grande");
		
		Bill d = new Bill();
		d.setIdNumber(123423);
		d.setMoney(5.0);
		d.setPaymentDate(new Date());
		billDAO.create(d);
		
		//EX3.1
		List<Visit> visitas = visitRepository.findByPetId(8);
		System.out.println("VISITAS: "+visitas.toString());
		//EX3.2
		
		for (Visit v : visitas) {
			String fatura = v.getBill().toString();
			System.out.println("BILLS: "+fatura);
		}
		//EX3.3
		Bill visitBill = new Bill();
		visitBill.setId(2);
		
		
		
		
	}
}
