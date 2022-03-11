package com.app.criatosoft.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Nominee {
	
	@Id
	private int nomid;
	public int getNomid() {
		return nomid;
	}
	public void setNomid(int nomid) {
		this.nomid = nomid;
	}
	public String getNomName() {
		return nomName;
	}
	public void setNomName(String nomName) {
		this.nomName = nomName;
	}
	public String getNomRelation() {
		return nomRelation;
	}
	public void setNomRelation(String nomRelation) {
		this.nomRelation = nomRelation;
	}
	public String getNomDob() {
		return nomDob;
	}
	public void setNomDob(String nomDob) {
		this.nomDob = nomDob;
	}
	public int getNomAge() {
		return nomAge;
	}
	public void setNomAge(int nomAge) {
		this.nomAge = nomAge;
	}
	private String nomName;
	private String nomRelation;
	private String nomDob;
	private int nomAge;
	
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
