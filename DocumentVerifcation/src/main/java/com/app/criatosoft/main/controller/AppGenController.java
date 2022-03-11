package com.app.criatosoft.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.criatosoft.main.model.Applicant;
import com.app.criatosoft.main.service.AppGenService;

@RestController
public class AppGenController {
	@Autowired
	AppGenService service;
	
	@PostMapping("/new")
	public String newApplicant(@RequestBody Applicant applicant) {
		service.newApplicant(applicant);
		return "New Application created Successfully...";
	}
	@GetMapping("all")
	public List<Applicant> getAll()
	{
		return service.getAll();
	}
	@PutMapping(value = "/addDocs/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addDocs(@PathVariable("id") Long id,
			@RequestPart(required = true, value = "aadharCard") MultipartFile aadharCard)
	{
		service.addDocuments(id,aadharCard);
		return "Documents Added Successfully....!!";
	}
	@PutMapping(value = "/updateDoc/{id}/{docName}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public String updateDoc(@PathVariable("docName")String docName,@PathVariable("id")Long id,@RequestPart(required = true,value = "doc") MultipartFile docFile) {
		service.updateDoc(id,docName,docFile);
		
		return docName+" Updated Successfully...!!";
	}
}