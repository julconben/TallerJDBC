package org.springframework.samples.petclinic.owner;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facturas")
public class Bill extends BaseEntity {
	
	/*@ManyToOne
	@JoinColumn(name="owner")
	private Owner owner;*/
	
	@Id
	@Digits(integer=10, fraction=0)
	private long idNumber;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date paymentDate;
	
	@Column(name = "money")
	@Digits(integer=5, fraction=2)
	@DecimalMin("0.0")
	private double money;
	
	//Cada visita esta associada a uma bill
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	@JsonIgnore
	private Visit visit;
	//Ao apagar Bill apagam-se as linhas de linhasBill
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
	@JsonIgnore
	private List<linhasBill> detalhesbill;
	
	
	public Bill () { 
		
	}

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

	/*public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Owner getOwner() {
		return owner;
	}*/

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
}
