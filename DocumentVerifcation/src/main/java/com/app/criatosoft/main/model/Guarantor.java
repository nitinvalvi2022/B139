package com.app.criatosoft.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Guarantor {
	@Id
	private int guarantorId;
	public int getGuarantorId() {
		return guarantorId;
	}
	public void setGuarantorId(int guarantorId) {
		this.guarantorId = guarantorId;
	}
	public String getGuarantorName() {
		return guarantorName;
	}
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}
	public String getGuarantorMobileno() {
		return guarantorMobileno;
	}
	public void setGuarantorMobileno(String guarantorMobileno) {
		this.guarantorMobileno = guarantorMobileno;
	}
	public String getGuarantorOccupation() {
		return guarantorOccupation;
	}
	public void setGuarantorOccupation(String guarantorOccupation) {
		this.guarantorOccupation = guarantorOccupation;
	}
	private String guarantorName;
	private String guarantorMobileno;
	private String guarantorOccupation;
	
	@Lob
	private byte [] adharCardFile;
	
	@Lob
	private byte [] panCardFile;
	
	public byte[] getAdharCardFile() {
		return adharCardFile;
	}
	public void setAdharCardFile(byte[] adharCardFile) {
		this.adharCardFile = adharCardFile;
	}
	public byte[] getPanCardFile() {
		return panCardFile;
	}
	public void setPanCardFile(byte[] panCardFile) {
		this.panCardFile = panCardFile;
	}
	
	
}
