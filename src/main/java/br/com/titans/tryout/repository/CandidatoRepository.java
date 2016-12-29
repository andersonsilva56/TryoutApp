package br.com.titans.tryout.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.com.titans.tryout.domain.Candidato;

public interface CandidatoRepository extends CrudRepository<Candidato, Long>{
	
	public Collection<Candidato> findByEmail(String email);

}
