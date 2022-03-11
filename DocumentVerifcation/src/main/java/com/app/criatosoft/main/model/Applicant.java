package com.app.criatosoft.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Applicant {
	@Id
	private long applicantId; 
	private String applicantFname;
	private String applicantLname;
	private String applicantMobileno;
	private String applicantEmailId;
	private String applicantDob;
	private String applicantOccupation;
	private String applicantAadharno;
	private int cibilScore;
	private String applicantPanno;
	private long applicantLoanamt;
	private double applicantSallary;
	private String comments;
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	private String status;// (STATUS CODES SPECIFIED ON LAST PAGE FOR REFERENCE)
	@OneToOne(cascade = CascadeType.ALL)
	
	private Address address;//(OTO HAS-A RELATION OF APPLICANT POJO WITH ADDRESS POJO)
	
	@OneToOne(cascade = CascadeType.ALL)
	private Document document;//(OTO HAS-A RELATION OF APPLICANT POJO WITH DOCUMENTPOJO)
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankdetails;//(OTO HAS-A RELATION OF APPLICANT POJO WITH BANKDETAILS POJO)
	
	@OneToOne(cascade = CascadeType.ALL)
	private Nominee nominee;//(OTO HAS-A RELATION OF APPLICANT POJO WITH NOMINEE POJO)
	
	@OneToOne(cascade = CascadeType.ALL)
	private Guarantor guarantor;//(OTO HAS-A RELATION OF APPLICANT POJO WITH GUARANTOR POJO

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantFname() {
		return applicantFname;
	}

	public void setApplicantFname(String applicantFname) {
		this.applicantFname = applicantFname;
	}

	public String getApplicantLname() {
		return applicantLname;
	}

	public void setApplicantLname(String applicantLname) {
		this.applicantLname = applicantLname;
	}

	public String getApplicantMobileno() {
		return applicantMobileno;
	}

	public void setApplicantMobileno(String applicantMobileno) {
		this.applicantMobileno = applicantMobileno;
	}

	public String getApplicantEmailId() {
		return applicantEmailId;
	}

	public void setApplicantEmailId(String applicantEmailId) {
		this.applicantEmailId = applicantEmailId;
	}

	public String getApplicantDob() {
		return applicantDob;
	}

	public void setApplicantDob(String applicantDob) {
		this.applicantDob = applicantDob;
	}

	public String getApplicantOccupation() {
		return applicantOccupation;
	}

	public void setApplicantOccupation(String applicantOccupation) {
		this.applicantOccupation = applicantOccupation;
	}

	public String getApplicantAadharno() {
		return applicantAadharno;
	}

	public void setApplicantAadharno(String applicantAadharno) {
		this.applicantAadharno = applicantAadharno;
	}

	public String getApplicantPanno() {
		return applicantPanno;
	}

	public void setApplicantPanno(String applicantPanno) {
		this.applicantPanno = applicantPanno;
	}

	public long getApplicantLoanamt() {
		return applicantLoanamt;
	}

	public void setApplicantLoanamt(long applicantLoanamt) {
		this.applicantLoanamt = applicantLoanamt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public BankDetails getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(BankDetails bankdetails) {
		this.bankdetails = bankdetails;
	}

	public Nominee getNominee() {
		return nominee;
	}

	public void setNominee(Nominee nominee) {
		this.nominee = nominee;
	}

	public Guarantor getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(Guarantor guarantor) {
		this.guarantor = guarantor;
	}
	
	public double getApplicantSallary() {
		return applicantSallary;
	}

	public void setApplicantSallary(double applicantSallary) {
		this.applicantSallary = applicantSallary;
	}
	
}
