package com.app.criatosoft.main.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;
import com.app.criatosoft.main.model.Document;
import com.app.criatosoft.main.model.EmailSender;
import com.app.criatosoft.main.repository.VerificationRepository;
import com.app.criatosoft.main.service.VerificationService;

@Service
public class VerifictionServiceImpl implements VerificationService {
	@Autowired
	VerificationRepository vr;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(long id,EmailSender e) {

			Optional<Applicant> app = vr.findById(id);
			Applicant applicant = app.get();
			applicant.setStatus("DOCUMENTS_REJECTED");
			applicant.setComments(e.getTextmsg());
			vr.save(applicant);
			
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom(e.getFromEmail());
		mailMessage.setTo(e.getToEmail());
		mailMessage.setSubject(e.getSubject());
		mailMessage.setText(e.getTextmsg());
		
		javaMailSender.send(mailMessage);
		System.out.println("Email Send successfully");

	}

	

	@Override
	public List<Applicant> getPendingApplicant(String status) {

		return vr.findByStatus(status);
	}

	@Override
	public Applicant getApplicantById(long id) {

		Optional<Applicant> findById = vr.findById(id);
		return findById.get();
	}

	@Override
	public Applicant setCibilScore(String applicantPanno) {
		int min = 650;
		int max = 950;

		int score = (int) (Math.random() * (max - min + 1) + min);
		Applicant applicant = vr.findByApplicantPanno(applicantPanno);
		applicant.setCibilScore(score);
		if (score >= 750) {
			applicant.setStatus("GOOD_CIBIL_SCORE");

		} else

		{
			applicant.setStatus("BAD_CIBIL_SCORE");

		}
		vr.save(applicant);
		return applicant;

	}

	@Override
	public void addDocuments(long id, MultipartFile aadharCard) {

		Optional<Applicant> findById = vr.findById(id);
		Applicant applicant = findById.get();

		try {
			Document document = new Document();
			document.setAadharCard(aadharCard.getBytes());
			applicant.setDocument(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
		vr.save(applicant);

	}

	@Override
	public String updateApplicant(String status, long applicantId) {

		Optional<Applicant> applicant = vr.findById(applicantId);
		Applicant ap = applicant.get();
		ap.setStatus(status);
		vr.save(ap);
		return "Successfully Updated";

	}

}
