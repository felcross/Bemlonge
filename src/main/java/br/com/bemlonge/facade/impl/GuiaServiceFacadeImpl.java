package br.com.bemlonge.facade.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.converter.GuiaConverter;
import br.com.bemlonge.dao.impl.GuiaDAOImpl;
import br.com.bemlonge.dto.GuiaDTO;
import br.com.bemlonge.exception.GuiaException;
import br.com.bemlonge.facade.GuiaServiceFacade;
import br.com.bemlonge.model.Guia;
import br.com.bemlonge.util.FormatadorEspacosUtils;

public class GuiaServiceFacadeImpl implements GuiaServiceFacade {
	
	static final Logger logger = LogManager.getLogger(GuiaServiceFacadeImpl.class.getName());

	GuiaDTO guiaDto = new GuiaDTO();
	GuiaDAOImpl guiaDao = new GuiaDAOImpl();
	FormatadorEspacosUtils formatadorEspacos = new FormatadorEspacosUtils();

	@Override
	public Boolean validarCadastro(GuiaDTO guiaDto) {
		GuiaDAOImpl dao = new GuiaDAOImpl();		
        try {
            List<GuiaDTO> list = dao.consultarGuiaPorCpf(guiaDto.getCpf());
            if (list.isEmpty()) 
            	return Boolean.TRUE;            
        } catch (GuiaException e) {
        	logger.error("Erro ao validar cadastro do Guia");
        }
        return Boolean.FALSE;
	}

	@Override
	public String cadastrarGuia(GuiaDTO guiaDto) {
		try {
			Guia guia = guiaDto.converterParaGuia();
			guiaDao.cadastrar(guia);			
			return "SUCCESS";
		} catch (GuiaException e) {
			logger.error("Erro ao cadastrar Guia");
			return "ERROR";
		}

	}
	@Override
	public List<Guia> listar() throws GuiaException {
		return guiaDao.listar();
	}
	
	public List<GuiaDTO> listarGuias() throws GuiaException{
		List<GuiaDTO> guias = GuiaConverter.converterParaDTO(guiaDao.listar());
		return guias;
	}
	
	public List<GuiaDTO> filtrar(String nome) throws GuiaException{
		List<GuiaDTO> guias = GuiaConverter.converterParaDTO(guiaDao.consultarGuiaPorNome(nome));
		return guias;
	}
	
}
