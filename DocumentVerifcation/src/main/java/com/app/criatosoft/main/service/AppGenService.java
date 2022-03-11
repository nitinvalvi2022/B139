package com.app.criatosoft.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;

public interface AppGenService {

	void newApplicant(Applicant applicant);

	void addDocuments(Long id, MultipartFile aadharCard);

	List<Applicant> getAll();

	void updateDoc(Long id, String docName, MultipartFile docFile);

}
