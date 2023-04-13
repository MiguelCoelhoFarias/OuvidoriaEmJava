package br.com.unifacisa.Ouvidoria.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.unifacisa.Ouvidoria.entities.Person;

public interface PersonRepositorys extends CrudRepository<Person, Integer>{
	
	
}
