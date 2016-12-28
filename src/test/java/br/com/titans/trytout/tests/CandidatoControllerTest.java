package br.com.titans.trytout.tests;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.titans.tryout.TryoutApplication;
import br.com.titans.tryout.domain.Candidato;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TryoutApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidatoControllerTest {

	private TestRestTemplate testRestTemplate;
	
	public void candidatoDeveTerNome(){
		Candidato candidato = new Candidato();
		candidato.setNome("Adalberto dos Remédios Silva Júnior");
		ResponseEntity<Candidato> response = testRestTemplate.postForEntity("/candidato", candidato, Candidato.class);
	}
	
}
