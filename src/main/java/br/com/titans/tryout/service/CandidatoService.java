package br.com.titans.tryout.service;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.titans.tryout.domain.Candidato;
import br.com.titans.tryout.exception.CampoObrigatorioException;
import br.com.titans.tryout.exception.EmailDuplicadoException;
import br.com.titans.tryout.repository.CandidatoRepository;
import br.com.titans.tryout.utils.Utils;

@Component
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	public Candidato salvar(Candidato requestCandidato) throws CampoObrigatorioException, IllegalArgumentException, IllegalAccessException, EmailDuplicadoException {
		validarCampos(requestCandidato);
		validarEmailDuplicado(requestCandidato);
		return candidatoRepository.save(requestCandidato);
	}


	private void validarCampos(Candidato requestCandidato) throws CampoObrigatorioException, IllegalArgumentException, IllegalAccessException{
		for(Field campo : requestCandidato.getClass().getDeclaredFields()){
			if(!campo.getName().equalsIgnoreCase("id")){
				validarCampo(requestCandidato, campo);
			}
		}
	}
	
	private void validarCampo(Candidato requestCandidato, Field campo) throws CampoObrigatorioException, IllegalArgumentException, IllegalAccessException{
		
		campo.setAccessible(true);
		
		if(campo.getType().equals(String.class) && (Utils.isNull(campo.get(requestCandidato)) || ((String)campo.get(requestCandidato)).isEmpty())){
			throw new CampoObrigatorioException(campo);
		}
		
		if(Utils.isNull(campo.get(requestCandidato))){
			throw new CampoObrigatorioException(campo);
		}
	}
	
	private void validarEmailDuplicado(Candidato requestCandidato) throws EmailDuplicadoException {
		if (!candidatoRepository.findByEmail(requestCandidato.getEmail()).isEmpty()){
			throw new EmailDuplicadoException();
		}
		
	}

}
