package com.matera.onboarding.service.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;

@Service
public interface ClientServiceAPI {

	List<ClientResponseDTO> getAllClients();

	ClientResponseDTO getClientByCpf(String cpf);

	ClientResponseDTO postNewClient(ClientRequestDTO clientRequestDTO);

	ClientResponseDTO updateClient(@Valid ClientUpdateRequestDTO clientUpdateRequestDTO, String cpf);

	void deleteClient(String cpf);

}
