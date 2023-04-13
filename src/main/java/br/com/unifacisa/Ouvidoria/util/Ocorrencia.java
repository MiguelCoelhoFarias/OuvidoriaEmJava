package br.com.unifacisa.Ouvidoria.util;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String seuNome;
	private String tipoDeOcorencia;
	private String ocorrencia;
	
	public Ocorrencia() {
		
	}
	
	public Ocorrencia(String seuNome, String tipoDeOcorencia, String ocorrencia) {
		super();
		this.seuNome = seuNome;
		this.tipoDeOcorencia = tipoDeOcorencia;
		this.ocorrencia = ocorrencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeuNome() {
		return seuNome;
	}

	public void setSeuNome(String seuNome) {
		this.seuNome = seuNome;
	}

	public String getTipoDeOcorencia() {
		return tipoDeOcorencia;
	}

	public void setTipoDeOcorencia(String tipoDeOcorencia) {
		this.tipoDeOcorencia = tipoDeOcorencia;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	@Override
	public String toString() {
		return "Ocorrencias: id: " + id + "| seuNome: " + seuNome + "| Tipo de ocorencia: " + tipoDeOcorencia + "| Ocorrencia: " + ocorrencia + "\n";
	}
	
	
	
	
}
