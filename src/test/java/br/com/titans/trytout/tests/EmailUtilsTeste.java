package br.com.titans.trytout.tests;

import org.junit.Test;

import br.com.titans.tryout.utils.EmailUtils;

public class EmailUtilsTeste {
	

	@Test
	public void deveEnviarEmail(){
		
		EmailUtils email = new EmailUtils("teste@gmail.com", "teste@teste.com.br", "Email da Classe de Teste", "Confirmado!");
		email.sendMail();
	}

}
