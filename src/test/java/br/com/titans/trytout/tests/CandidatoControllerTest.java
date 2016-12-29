package br.com.titans.trytout.tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.titans.tryout.TryoutApplication;
import br.com.titans.tryout.constantes.TamanhoCamisaEnum;
import br.com.titans.tryout.domain.Candidato;
import br.com.titans.tryout.exception.RespostaErro;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TryoutApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidatoControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void candidatoDeveTerNome(){
		Candidato candidato = new Candidato();
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Nome"));
	}
	
	@Test
	public void candidatoDeveTerIdade(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Idade"));
	}
	
	@Test
	public void candidatoDeveTerPeso(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Peso"));
	}
	
	@Test
	public void candidatoDeveTerAltura(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Altura"));
	}
	
	@Test
	public void candidatoDeveTerTamanhoCamisa(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: TamanhoCamisa"));
	}
	
	@Test
	public void candidatoDeveTerContatoEmergencia(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: ContatoEmergencia"));
	}
	
	@Test
	public void candidatoDeveTerEmail(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Email"));
	}
	
	@Test
	public void candidatoDeveTerTelefone(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Telefone"));
	}
	
	@Test
	public void candidatoDeveTerTelefoneContatoEmergencia(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		candidato.setTelefone(999999999);
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: TelefoneContatoEmergencia"));
	}
	
	@Test
	public void candidatoDeveTerFotografia(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		candidato.setTelefone(999999999);
		candidato.setTelefoneContatoEmergencia(999999999);
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("Campo Obrigatório!: Fotografia"));
	}
	
	@Test
	public void candidatoDeveSerPersistido(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		candidato.setTelefone(999999999);
		candidato.setTelefoneContatoEmergencia(999999999);
		candidato.setFotografia("alguma fotografia em base 64");
		ResponseEntity<Candidato> response = testRestTemplate.postForEntity("/candidato", candidato, Candidato.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
		assertTrue(response.getBody().getId() != null);
	}
	
	@Test
	public void candidatoNaoDevePersistidoCasoJaExistaAlguemComMesmoEmail(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		candidato.setTelefone(999999999);
		candidato.setTelefoneContatoEmergencia(999999999);
		candidato.setFotografia("alguma fotografia em base 64");
		testRestTemplate.postForEntity("/candidato", candidato, Candidato.class);
		
		candidato = new Candidato();
		candidato.setNome("Adalberto Júnior");
		candidato.setIdade(30);
		candidato.setPeso(new BigDecimal(110));
		candidato.setAltura(new BigDecimal(1.93));
		candidato.setTamanhoCamisa(TamanhoCamisaEnum.GG);
		candidato.setContatoEmergencia("Virgínia Cruz");
		candidato.setEmail("adalberto@silva.org");
		candidato.setTelefone(999999999);
		candidato.setTelefoneContatoEmergencia(999999999);
		candidato.setFotografia("alguma fotografia em base 64");
		
		ResponseEntity<RespostaErro> response = testRestTemplate.postForEntity("/candidato", candidato, RespostaErro.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
		assertTrue(response.getBody().getMensagem() != null);
		assertTrue(response.getBody().getMensagem().equalsIgnoreCase("email já cadastrado!"));
	}
	
}
