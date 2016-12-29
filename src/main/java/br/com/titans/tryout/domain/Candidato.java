package br.com.titans.tryout.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.titans.tryout.constantes.TamanhoCamisaEnum;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer idade;
	private BigDecimal peso;
	private BigDecimal altura;
	private TamanhoCamisaEnum tamanhoCamisa;
	private String contatoEmergencia;
	private String email;
	private Integer telefone;
	private Integer telefoneContatoEmergencia;
	private String fotografia;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public TamanhoCamisaEnum getTamanhoCamisa() {
		return tamanhoCamisa;
	}
	public void setTamanhoCamisa(TamanhoCamisaEnum tamanhoCamisa) {
		this.tamanhoCamisa = tamanhoCamisa;
	}
	public String getContatoEmergencia() {
		return contatoEmergencia;
	}
	public void setContatoEmergencia(String contatoEmergencia) {
		this.contatoEmergencia = contatoEmergencia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Integer getTelefoneContatoEmergencia() {
		return telefoneContatoEmergencia;
	}
	public void setTelefoneContatoEmergencia(Integer telefoneContatoEmergencia) {
		this.telefoneContatoEmergencia = telefoneContatoEmergencia;
	}
	public String getFotografia() {
		return fotografia;
	}
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

}
