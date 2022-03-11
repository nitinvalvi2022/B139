package com.app.criatosoft.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankDetails {
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranchname() {
		return bankBranchname;
	}
	public void setBankBranchname(String bankBranchname) {
		this.bankBranchname = bankBranchname;
	}
	public String getBankAccountno() {
		return bankAccountno;
	}
	public void setBankAccountno(String bankAccountno) {
		this.bankAccountno = bankAccountno;
	}
	public String getBankIfsccode() {
		return bankIfsccode;
	}
	public void setBankIfsccode(String bankIfsccode) {
		this.bankIfsccode = bankIfsccode;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	@Id
	private int bankId;
	private String bankName;
	private String bankBranchname;
	private String bankAccountno;
	private String bankIfsccode;
	private String bankAddress;


}
