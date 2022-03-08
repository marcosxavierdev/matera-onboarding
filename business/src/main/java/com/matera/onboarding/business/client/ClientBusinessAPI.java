package com.matera.onboarding.business.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;
import com.matera.onboarding.entity.Client;

@Component
public interface ClientBusinessAPI {

	ClientResponseDTO toResponseDTO(Client client);

	List<ClientResponseDTO> toListResponseDTO(List<Client> clients);

	Client toEntity(ClientRequestDTO clientRequestDTO);

	List<ClientResponseDTO> getAllClients();

	ClientResponseDTO getClientByCpf(String cpf);

	ClientResponseDTO postNewClient(@Valid ClientRequestDTO clientRequestDTO);

	ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String cpf);

	void deleteClient(String cpf);

}
