package br.com.bemlonge.facade;

import java.util.List;

import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.model.Guia;


public interface GuiaServiceFacade {
	
	Boolean validarCadastro(GuiaDTO guiaDto) throws GuiaException;
	
	String cadastrarGuia(GuiaDTO guiaDto) throws GuiaException;
	
	List<Guia> listar() throws GuiaException;

}
