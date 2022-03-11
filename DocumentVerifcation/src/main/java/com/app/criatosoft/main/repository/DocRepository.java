package com.app.criatosoft.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.criatosoft.main.model.Document;
@Repository
public interface DocRepository extends JpaRepository<Document, Integer>{

}
