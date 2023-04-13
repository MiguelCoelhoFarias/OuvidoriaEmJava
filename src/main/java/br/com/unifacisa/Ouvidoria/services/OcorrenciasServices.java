package br.com.unifacisa.Ouvidoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.Ouvidoria.repositorys.OcorrencesRepositorys;
import br.com.unifacisa.Ouvidoria.util.Ocorrencia;

@Service
public class OcorrenciasServices {

	@Autowired
	OcorrencesRepositorys OcorrenceRepositorys;

	public String AddoOcorrencia(String seuNome, String tipoDeOcorrencia, String ocorrencia) {
		try {
			Ocorrencia o = new Ocorrencia(seuNome, tipoDeOcorrencia, ocorrencia);
			OcorrenceRepositorys.save(o);
			return "Pessoa salva";
		} catch (Exception erro1) {
			System.out.println("Algo deu errado. Tente novamente.");
		}
		return "Algo deu errado.";
	}
	
	public void listarOcorrencias() {
		
			for (Ocorrencia o : OcorrenceRepositorys.findAll()) {
				if (o != null) {

					System.out.println(o.toString());
				} else {
					System.out.println("Não há ocorrencias cadastradas.");
				}
			}
		
	}
	public void DeletarTudo() {
		OcorrenceRepositorys.deleteAll();
	}
	
	public void DeletarEspecifico(Integer id) {
		OcorrenceRepositorys.deleteById(id);
	}

}
