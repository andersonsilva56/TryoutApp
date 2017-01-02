package br.com.titans.tryout.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Alexsander Melo
 * @since 31/12/2016
 *
 */
public class EmailUtils {

	private String from;
	private String to;
	private String subject;
	private String message;
	private Session session;
	private Message emailMessage;
	private Properties props;
	private SimpleAuth auth;

	private static final String TYPE_TRANSPORT = "smtp";
	private static final String mailSMTPServer = "smtp.gmail.com";

	EmailUtils() {
	}

	public EmailUtils(String from, String to, String subject, String message) {

		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	public void sendMail() {

		loadProperties();
		createSimpleAuth();
		createSession();
		createMessage();
		send();
	}

	private void send() {

		Transport tr;
		try {
			tr = session.getTransport(TYPE_TRANSPORT); 
			tr.connect(mailSMTPServer, "recrutamento.belemtitans@gmail.com", "titansTop");
			this.emailMessage.saveChanges();
			tr.sendMessage(this.emailMessage, this.emailMessage.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}
	}

	private void createSimpleAuth() {

		this.auth = new SimpleAuth("recrutamento.belemtitans@gmail.com", "titansTop");
	}

	private void createSession() {

		this.session = Session.getDefaultInstance(props, auth);
		this.session.setDebug(true);
	}

	private void createMessage() {

		this.emailMessage = new MimeMessage(this.session);
		try {
			// Setando o destinatário
			this.emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			// Setando a origem do email
			this.emailMessage.setFrom(new InternetAddress(this.from));
			// Setando o assunto
			this.emailMessage.setSubject(this.subject);
			// Setando o conteúdo/corpo do email
			this.emailMessage.setContent(this.message, "text/plain");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
	}

	private void loadProperties() {

		this.props = new Properties();
		InputStream input = null;
		input = this.getClass().getResourceAsStream("/config_email.properties");
		try {
			this.props.load(input);
		} catch (IOException e1) {

			System.out.println("Erro ao Carregar config_email.properties");
		}
	}

}

class SimpleAuth extends Authenticator {
	public String username = null;
	public String password = null;

	public SimpleAuth(String user, String pwd) {
		username = user;
		password = pwd;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
