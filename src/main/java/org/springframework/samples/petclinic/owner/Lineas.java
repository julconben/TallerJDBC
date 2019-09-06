package org.springframework.samples.petclinic.owner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name="lineas")
public class Lineas extends BaseEntity{
	
	@Digits(integer=10, fraction=0)
	private long idNumber;
	
	
	@Column(name = "details")
    @NotEmpty
    private String details;
	
	@ManyToOne
	@JoinColumn(name = "bill")
	private Bill bill;

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
}
