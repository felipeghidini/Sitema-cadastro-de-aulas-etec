package com.etec.agendaaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etec.agendaaulas.entities.Aula;
import com.etec.agendaaulas.repositories.AulaRepository;

@Service
public class AulaService {
	
	@Autowired
	private AulaRepository aulaRepository;
	
	public List<Aula> findAll() {
		return aulaRepository.findAll();
	}

}