package com.app.criatosoft.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;
import com.app.criatosoft.main.model.EmailSender;

public interface VerificationService {
	

public	void sendEmail(long id, EmailSender eml);

public List<Applicant> getPendingApplicant(String status);

public String updateApplicant(String status, long applicantId);

public Applicant getApplicantById(long id);

public Applicant setCibilScore( String applicantPanno);

public void addDocuments(long id, MultipartFile aadharCard);

//









}
