package br.com.bemlonge.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.bemlonge.dto.ClienteDTO;
import br.com.bemlonge.model.Cliente;

public class ClienteConverter {
	
	static final Logger logger = LogManager.getLogger(ClienteConverter.class.getName());

	public static List<ClienteDTO> converterParaDTO(List<Cliente> clientes) {

		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		for (Cliente c : clientes) {
			ClienteDTO passeio = new ClienteDTO(c);
			clientesDto.add(passeio);
		}

		return clientesDto;
	}
}
