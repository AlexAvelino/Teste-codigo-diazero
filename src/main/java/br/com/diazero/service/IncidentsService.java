package br.com.diazero.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.diazero.model.Incidents;
import br.com.diazero.repository.IncidentsRepository;

@Service
public class IncidentsService {

	boolean closed = false;

	@Autowired
	public IncidentsRepository repository;

	public Optional<Incidents> update(Incidents incident) {
		if (!closed) {
			Date updateDate = new Date(System.currentTimeMillis());
			incident.setUpdatedAt(updateDate);
			return Optional.of(repository.save(incident));
		} else {
			return null;
		}
	}

	public Optional<Incidents> close(Long id) {
		Incidents incident = closedId(id);
		Date closeDate = new Date(System.currentTimeMillis());
		incident.setClosedAt(closeDate);
		closed = true;
		return Optional.of(repository.save(incident));
	}
	
	private Incidents closedId(Long id) {
		Incidents incidentSave = repository.findById(id).orElse(null);
		
		if(incidentSave == null) {
			throw new EmptyResultDataAccessException(1);
		}else {
			return incidentSave;
		}
	}
}
