package com.app.criatosoft.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;
import com.app.criatosoft.main.model.EmailSender;
import com.app.criatosoft.main.service.VerificationService;


@CrossOrigin("*")
@RestController
@RequestMapping("app/verification")
public class VerificationController {
	@Autowired
VerificationService vs;
	
	//INITIALIZED AND APLLICATION GENERATED
	@GetMapping("/getapplicant/{status}")
	public List<Applicant> getPendingApplicant(@PathVariable String status)
	{
		System.out.println("aaaaaaa");
		return vs.getPendingApplicant(status);
	}
	
	
	//VERIFIED
	@PutMapping("/updateApllicant/{status}/{applicantId}")
	public String updateApplicant(@RequestBody Applicant applicant,
			@PathVariable String status, @PathVariable long applicantId  )
	{
		System.out.println(status);
		System.out.println(applicantId);
		return vs.updateApplicant(status,applicantId);
	}
	
	//REJECT DOCUMENTS
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PutMapping(value = "/rejectApp/{id}")// http://localhost:2233/sendemail
	public String EmailSend(@PathVariable long id ,@RequestBody EmailSender eml) {
		eml.setFromEmail(fromEmail);
		
	
		try {
			vs.sendEmail(id,eml);
			return "Emailsend";
			}
		catch (Exception e) {
			e.printStackTrace();
			return "Email can not sent";
		}
	}
	
	  
	  //SHOW DETAILS
	  @GetMapping("/get/{id}")
	  public Applicant getApplicantById(@PathVariable("id") long id) {
		  return vs.getApplicantById(id);
	  } 
	  
	  
	 // CIBILSCORE SET
	  @GetMapping("/getcibil/{applicantPanno}")
	  public Applicant getCibilScore(@PathVariable String applicantPanno)
	  {
		  return vs.setCibilScore(applicantPanno);
	  }
	  
	  
	  //DOC UPLOAD
	  @PutMapping(value = "/addDocs/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	  public String addDocs(@PathVariable("id") long id,
	  		@RequestPart(required = true, value = "aadharCard") MultipartFile aadharCard)
	  {
	  	vs.addDocuments(id,aadharCard);
	  	return "Documents Added Successfully....!!";
	  }
	  
}
