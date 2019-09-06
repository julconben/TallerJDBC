package org.springframework.samples.petclinic.owner;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.BaseEntity;

@Table(name = "linhas")
@Entity
public class Linhas extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "bill")
	private Bill bill;

	private String details1;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getDetails1() {
		return details1;
	}

	public void setDetails1(String details1) {
		this.details1 = details1;
	}

}
