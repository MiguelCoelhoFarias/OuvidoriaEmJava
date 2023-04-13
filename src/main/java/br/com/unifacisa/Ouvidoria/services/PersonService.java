package br.com.unifacisa.Ouvidoria.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.Ouvidoria.entities.Person;
import br.com.unifacisa.Ouvidoria.repositorys.PersonRepositorys;

@Service
public class PersonService {

	@Autowired
	PersonRepositorys personRepositorys;

	public String AddPerson( String name, String email, String numeroDeTelefone, String senha,
			Integer tipoDeRegistro) {
		
		try {
			Person p = new Person(name, email,numeroDeTelefone,senha, tipoDeRegistro);
			
			personRepositorys.save(p);
			return "Pessoa Salva";

		} catch (Exception e) {
			System.out.println("Algo deu errado");

		}
		return "Error";
	
	}

	public void listarTodos() {
		for (Person p : personRepositorys.findAll()) {
			if (p != null) {

				System.out.println(p.toString());
			} else {
				System.out.println("Não existe pessoas cadastradas.");
			}
		}
	}
	public void ApagarPessoa(Integer id ) { // deletar usuario a partir do Id
		personRepositorys.deleteById(id);
		
	}
	
}