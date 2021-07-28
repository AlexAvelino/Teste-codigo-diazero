package br.com.diazero.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diazero.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByUser(String user);
}
