package br.com.titans.tryout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.titans.tryout.domain.Candidato;
import br.com.titans.tryout.exception.CampoObrigatorioException;
import br.com.titans.tryout.exception.EmailDuplicadoException;
import br.com.titans.tryout.exception.RespostaErro;
import br.com.titans.tryout.service.CandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	private CandidatoService candidatoService;

	@PostMapping
	public ResponseEntity<Candidato> inserirCandidato(@RequestBody Candidato requestCandidato) throws Exception{
		return new ResponseEntity<Candidato>(candidatoService.salvar(requestCandidato), HttpStatus.OK);
	}
	
	@ExceptionHandler(CampoObrigatorioException.class)
	public ResponseEntity<RespostaErro> campoObrigatorioExceptionHandler(CampoObrigatorioException ex){
		return new ResponseEntity<RespostaErro>(new RespostaErro(ex.getMessage()), ex.getHttpStatus());
	}
	
	@ExceptionHandler(EmailDuplicadoException.class)
	public ResponseEntity<RespostaErro> emailDuplicadoExceptionHandler(EmailDuplicadoException ex){
		return new ResponseEntity<RespostaErro>(new RespostaErro(ex.getMessage()), ex.getHttpStatus());
	}
}
