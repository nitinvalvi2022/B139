package com.app.criatosoft.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.criatosoft.main.model.Applicant;

@Repository
public interface VerificationRepository extends JpaRepository<Applicant, Long>{

	public List<Applicant> findByStatus(String status);

	public Applicant findByApplicantPanno(String applicantPanno);

}
