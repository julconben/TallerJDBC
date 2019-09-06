package org.springframework.samples.petclinic.owner;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facturas")
public class Bill extends BaseEntity {
	
	@Digits(integer=10, fraction=0)
	private long idNumber;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date paymentDate;
	
	@Digits(integer=5, fraction=2)
	@DecimalMin("0.0")
	private double money;
	
	
	
	/*
	@ManyToOne
	@JoinColumn(name="owner")
	private Owner owner;
	*/
	
	
//////////////////
	
//	@PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;
//
//    public void addMovie(Bill o) throws Exception {
//        entityManager.persist(o);
//    }
//
//    public void deleteMovie(Bill o) throws Exception {
//        entityManager.remove(o);
//    }
//
//    public List<Bill> getMovies() throws Exception {
//        Query query = entityManager.createQuery("SELECT m from Movie as m");
//        return query.getResultList();
//    }
	
/////////////
	

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	@JsonIgnore
	private Visit visit;
	
	public Bill () { }

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	@Override
	public String toString() {
		return "Bill [idNumber=" + idNumber + ", paymentDate=" + paymentDate + ", money=" + money + ", visit=" + visit
				+ "]";
	}
	
	
}
