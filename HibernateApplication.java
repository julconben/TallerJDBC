package org.springframework.samples.petclinic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
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
import org.springframework.samples.petclinic.dao.BillDAO;
import org.springframework.samples.petclinic.dao.OwnerDAO;
import org.springframework.samples.petclinic.dao.PetDAO;
import org.springframework.samples.petclinic.dao.VisitDAO;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Linhas;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillDAO billDAO;

	@Autowired
	private VisitDAO visitDAO;

	@Autowired
	private PetDAO petDAO;

	@Autowired
	private OwnerDAO ownerDAO;

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
		for (Visit v : visits) {
			System.out.println(v.toString());
		}
		Visit visitaNova = new Visit();
//		visitaNova.setId(2);
		Bill b = new Bill();
		b.setIdNumber(1236666);
		b.setMoney(10.5);
		b.setPaymentDate(new Date());
		b.setVisit(visitaNova);
		billDAO.create(b);

		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas
		 * visitas
		 */
		/*
		 * System.out.println("-----------VISITAS---------------"); visits =
		 * visitRepository.findByPetId(p.getId()); for (Visit v : visits) {
		 * System.out.println(v.toString()); }
		 */
		/*
		 * Bill b = new Bill(); b.setIdNumber(1234567890); b.setMoney(1.0);
		 * b.setPaymentDate(new Date()); List<Bill> listaFacturas = new
		 * ArrayList<Bill>(); listaFacturas.add(b); listaFacturas =
		 * billRepository.save(listaFacturas); visits.get(0).setBill(b);
		 * visitRepository.save(visits.get(0));
		 * 
		 * p = petRepository.findById(8); visits =
		 * visitRepository.findByPetId(p.getId()); for (Visit v : visits) {
		 * System.out.println(v.toString()); }
		 * 
		 * Linhas l = new Linhas(); l.setDetails("Hola JOAO"); l.setBills(b);
		 * ArrayList<Linhas> linhasfactura = new ArrayList<Linhas>();
		 * linhasfactura.add(l); b.setLinhasfactura(linhasfactura);
		 * //billRepository.save(b);
		 * 
		 * ///buscar fatura con id 108 y eliminarla, mira si linha asociada se ha
		 * elminado
		 * 
		 * Bill eliminBD = new Bill(); eliminBD = billRepository.findOne(109);
		 * billRepository.delete(eliminBD);
		 * 
		 */

	}

}
