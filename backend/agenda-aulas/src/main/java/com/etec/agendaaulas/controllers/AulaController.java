package com.etec.agendaaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> getOneAula(@PathVariable(value ="id") String id) {
	Optional<Aula> aula0 = aulaService.findById(id);
		if(!aula0.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Aula>(aula0.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Aula> saveAula(@RequestBody @Valid Aula aula) {
		return new ResponseEntity<Aula>(aulaService.add(aula), HttpStatus.CREATED);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLive(@PathVariable(value="id") String id) {
        Optional<Aula> aulaO = aulaService.findById(id);
        if(!aulaO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	aulaService.delete(aulaO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateLive(@PathVariable(value="id") String id,
                                            @RequestBody @Valid Aula aula) {
        Optional<Aula> aulaO = aulaService.findById(id);
        if(!aulaO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            aula.setId(aulaO.get().getId());
            return new ResponseEntity<Aula>(aulaService.add(aula), HttpStatus.OK);
        }
    }
}
