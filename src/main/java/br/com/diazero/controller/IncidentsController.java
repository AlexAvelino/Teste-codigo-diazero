package br.com.diazero.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diazero.model.Incidents;
import br.com.diazero.repository.IncidentsRepository;
import br.com.diazero.service.IncidentsService;

@RestController
@RequestMapping("/incidents")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncidentsController {
	
	@Autowired
	public IncidentsRepository repository;
	
	@Autowired
	public IncidentsService service;
	
	@GetMapping
	public ResponseEntity<List<Incidents>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Incidents> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Incidents>> GetByName (@PathVariable String name){
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	@GetMapping("description/{description}")
	public ResponseEntity<List<Incidents>> GetByDescription(@PathVariable String description){
		return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(description));
	}
	
	@PostMapping
	public ResponseEntity<Incidents> post(@RequestBody Incidents incident){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(incident));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Optional<Incidents>> put(@RequestBody Incidents incident){
		return ResponseEntity.status(HttpStatus.OK).body(service.update(incident));
	}
	
	@PutMapping("/close/{id}")
	public ResponseEntity<Optional<Incidents>> close(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.close(id));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
