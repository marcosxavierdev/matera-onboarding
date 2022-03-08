package com.matera.onboarding.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.business.client.ClientBusinessAPI;
import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServiceAPI {

	private final ClientBusinessAPI clientBusinessAPI;

	@Override
	public List<ClientResponseDTO> getAllClients() {
		return clientBusinessAPI.getAllClients();
	}

	@Override
	public ClientResponseDTO getClientByCpf(String cpf) {
		return clientBusinessAPI.getClientByCpf(cpf);
	}

	@Override
	public ClientResponseDTO postNewClient(ClientRequestDTO clientRequestDTO) {
		return clientBusinessAPI.postNewClient(clientRequestDTO);
	}

	@Override
	public ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String cpf) {
		return clientBusinessAPI.updateClient(clientUpdateRequestDTO, cpf);
	}

	@Override
	public void deleteClient(String cpf) {
		clientBusinessAPI.deleteClient(cpf);
	}

}
