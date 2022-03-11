package com.app.criatosoft.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docId;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] cancelledCheque;
	@Lob
	private byte[] passbook;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] quotation;
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public byte[] getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(byte[] aadharCard) {
		this.aadharCard = aadharCard;
	}
	public byte[] getPanCard() {
		return panCard;
	}
	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}
	public byte[] getCancelledCheque() {
		return cancelledCheque;
	}
	public void setCancelledCheque(byte[] cancelledCheque) {
		this.cancelledCheque = cancelledCheque;
	}
	public byte[] getPassbook() {
		return passbook;
	}
	public void setPassbook(byte[] passbook) {
		this.passbook = passbook;
	}
	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getQuotation() {
		return quotation;
	}
	public void setQuotation(byte[] quotation) {
		this.quotation = quotation;
	}


}
