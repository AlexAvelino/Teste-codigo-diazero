package br.com.diazero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import br.com.diazero.model.Incidents;

@Repository
public interface IncidentsRepository extends JpaRepository<Incidents, Long>{
	public List<Incidents> findAllByNameContainingIgnoreCase(String name);
	public List<Incidents> findAllByDescriptionContainingIgnoreCase(String description);
}
