package com.app.criatosoft.main.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;
import com.app.criatosoft.main.model.Document;
import com.app.criatosoft.main.model.Guarantor;
import com.app.criatosoft.main.model.Nominee;
import com.app.criatosoft.main.repository.VerificationRepository;
import com.app.criatosoft.main.service.AppGenService;

@Service
public class AppGenServiceImpl implements AppGenService {

	@Autowired
	VerificationRepository repo;

	@Override
	public void newApplicant(Applicant applicant) {
		
		repo.save(applicant);
	}

	@Override
	public void addDocuments(Long id, MultipartFile aadharCard) {
		Optional<Applicant> findById = repo.findById(id);
		Applicant applicant = findById.get();

		try {
			Document document = new Document();
			document.setAadharCard(aadharCard.getBytes());
			applicant.setDocument(document);
			applicant.setStatus("APPLICATION_GENERATED");
		} catch (IOException e) {
			e.printStackTrace();
		}
		repo.save(applicant);
	}

	@Override
	public List<Applicant> getAll() {
		return repo.findAll();
	}

	@Override
	public void updateDoc(Long id, String docName, MultipartFile docFile) {

		try {
			
			Optional<Applicant> applicantpOpt = repo.findById(id);
			Applicant applicant = applicantpOpt.get();
			
			if (docName.contains("pan")) {
				applicant.getDocument().setPanCard(docFile.getBytes());
			} else if (docName.contains("photo")) {
				applicant.getDocument().setPhoto(docFile.getBytes());

			} else if (docName.contains("pass")) {
				applicant.getDocument().setPassbook(docFile.getBytes());
			
			} else if (docName.contains("nomAdhar")) {
				Nominee nominee = new Nominee();
				nominee.setAdharCardFile(docFile.getBytes());
				applicant.setNominee(nominee);;
			}
			
			
			else if (docName.contains("grAdhar")) {
				Guarantor gr=new Guarantor();
				gr.setAdharCardFile(docFile.getBytes());
				applicant.setGuarantor(gr);
			}
			repo.save(applicant);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
