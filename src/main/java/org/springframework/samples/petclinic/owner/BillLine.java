package org.springframework.samples.petclinic.owner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "bill_lines")
public class BillLine extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill idBill;
    
	@Column(name = "Details")
	private String details;

	public Bill getIdBill() {
		return idBill;
	}

	public void setIdBill(Bill idBill) {
		this.idBill = idBill;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
