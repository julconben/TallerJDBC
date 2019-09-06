package org.springframework.samples.petclinic.owner;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.data.annotation.Id;
import org.springframework.samples.petclinic.model.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "billdetails")
public class linhasBill extends BaseEntity{
	
	//Foreign key
	@ManyToOne
	@JoinColumn(name="id_bill")
	private Bill bill;
	
	//Pri key
	@Id
	@Digits(integer=10, fraction=0)
	private long id_linha;
	
	@Column(name = "detalhe")
	private String detalhe;
	
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public void setDetails(String detalhe) {
		this.detalhe = detalhe;
	}
	
	public Bill getBill() {
		return bill;
	}
	public String getDetails() {
		return detalhe;
	}
	

}
