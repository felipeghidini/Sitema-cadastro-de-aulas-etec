package com.etec.agendaaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etec.agendaaulas.entities.Aula;
import com.etec.agendaaulas.services.AulaService;

@RestController
@RequestMapping(value = "/aulas")
public class AulaController {
	
	@Autowired
	private AulaService aulaService;
	
	@GetMapping
	public ResponseEntity<List<Aula>> findAll() {
		List<Aula> list = aulaService.findAll();
		return ResponseEntity.ok(list);
	}
}
