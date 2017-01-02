package br.com.titans.tryout.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.titans.tryout.constantes.Inscricao;
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
	@JsonProperty("tamanho_camisa")
	private TamanhoCamisaEnum tamanhoCamisa;
	@JsonProperty("contato_emergencia")
	private String contatoEmergencia;
	private String email;
	private Integer telefone;
	@JsonProperty("telefone_contato_emergencia")
	private Integer telefoneContatoEmergencia;
	private String fotografia;
	@JsonProperty("inscricao_paga")
	private Inscricao inscricao;
	
	public Candidato() {
		
		this.inscricao = Inscricao.NAO_PAGA;
	}
	
	public Candidato(String nome, Integer idade, BigDecimal peso, BigDecimal altura, String tamanhoCamisa,
			String contatoEmergencia, String email, Integer telefone, Integer telefonecontatoEmergencia) {
		
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		this.tamanhoCamisa  = TamanhoCamisaEnum.get(tamanhoCamisa);
		this.contatoEmergencia = contatoEmergencia;
		this.email = email;
		this.telefone = telefone;
		this.telefoneContatoEmergencia = telefonecontatoEmergencia;
		this.inscricao = Inscricao.NAO_PAGA;
	}
	
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

	public boolean isInscricaoPaga() {
		
		return Inscricao.PAGA.equals(inscricao);
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((this.getNome() == null) ? 0 : this.getNome().hashCode());
		result = prime * result + ((this.getEmail() == null) ? 0 : this.getEmail().hashCode());
		result = prime * result + ((this.getIdade() == null) ? 0 : this.getIdade().hashCode());
		result = prime * result + ((this.getPeso() == null) ? 0 : this.getPeso().hashCode());
		result = prime * result + ((this.getAltura() == null) ? 0 : this.getAltura().hashCode());
		result = prime * result + ((this.getTelefone() == null) ? 0 : this.getTelefone().hashCode());
		result = prime * result + ((this.getContatoEmergencia() == null) ? 0 : this.getContatoEmergencia().hashCode());
		result = prime * result + ((this.getTelefoneContatoEmergencia() == null) ? 0 : this.getTelefoneContatoEmergencia().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Candidato)) {
			return false;
		}
		Candidato other = (Candidato) obj;

		return super.equals(obj) 
				&&  this.id.equals(other.id)
				&&  this.getNome().equals(other.getNome())
				&&  this.getEmail().equals(other.getEmail())
				&&  this.getIdade().equals(other.getIdade())
				&&  this.getPeso().equals(other.getPeso())
				&&  this.getAltura().equals(other.getAltura())
				&&  this.getTelefone().equals(other.getTelefone())
				&&  this.getContatoEmergencia().equals(other.getContatoEmergencia())
				&&  this.getTelefoneContatoEmergencia().equals(other.getTelefoneContatoEmergencia());
	}
}
