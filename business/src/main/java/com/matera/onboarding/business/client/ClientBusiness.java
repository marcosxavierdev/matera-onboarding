package com.matera.onboarding.business.client;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.matera.onboarding.business.exceptions.ObjectNotFoundException;
import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;
import com.matera.onboarding.entity.Client;
import com.matera.onboarding.repository.client.ClientRepositoryAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientBusiness implements ClientBusinessAPI {

	private final ClientRepositoryAPI clientRepositoryAPI;
	private final ModelMapper modelMapper;

	@Override
	public ClientResponseDTO toResponseDTO(Client client) {
		return modelMapper.map(client, ClientResponseDTO.class);
	}

	@Override
	public List<ClientResponseDTO> toListResponseDTO(List<Client> clients) {
		return clients.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	@Override
	public Client toEntity(ClientRequestDTO clientRequestDTO) {
		return modelMapper.map(clientRequestDTO, Client.class);
	}

	@Override
	public List<ClientResponseDTO> getAllClients() {
		log.info("[start] getAllClients in ClientBusiness");
		List<Client> clients = clientRepositoryAPI.findAll();
		log.info("[finish getAllClients in ClientBusiness");
		return toListResponseDTO(clients);
	}

	@Override
	public ClientResponseDTO getClientByCpf(String cpf) {
		log.info("[start] getClientByCpf in ClientBusiness");
		Client client = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("client not found"));
		log.info("[finish] getClientByCpf in ClientBusiness");
		return toResponseDTO(client);
	}
	
	@Override
	public ClientResponseDTO postNewClient(ClientRequestDTO clientRequestDTO) {
		
		log.info("[start] postNewClient in ClientBusiness");
		Client client = toEntity(clientRequestDTO);
		Client savingClient = clientRepositoryAPI.save(client);
		log.info("[finish] postNewClient in ClientBusiness");
		return toResponseDTO(savingClient);
	}

	@Override
	public ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String cpf) {
		log.info("[start] updateClient in ClientBusiness");
		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("client not found"));
		Long clientId = clientByCpf.getId();
		clientByCpf.setId(clientId);
		clientByCpf.setName(clientUpdateRequestDTO.getName());
		clientByCpf.setBirthday(clientUpdateRequestDTO.getBirthday());
		clientByCpf.setMaritalStatus(clientUpdateRequestDTO.getMaritalStatus());
		clientByCpf.setIndSpecialClient(clientUpdateRequestDTO.getIndSpecialClient());
		Client updatingClient = clientRepositoryAPI.save(clientByCpf);
		log.info("[finish] updateClient in ClientBusiness");
		return toResponseDTO(updatingClient);
	}

	@Override
	public void deleteClient(String cpf) {
		log.info("[start] deleteClient in ClientBusiness");
		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("client not found"));
		log.info("[finish] deleteClient in ClientBusiness");
		clientRepositoryAPI.delete(clientByCpf);
	}
	
}
