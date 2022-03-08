package com.matera.onboarding.controller.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;
import com.matera.onboarding.service.client.ClientServiceAPI;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientRestController implements ClientAPI {

	private final ClientServiceAPI clientServiceAPI;

	@Override
	public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
		List<ClientResponseDTO> clients = clientServiceAPI.getAllClients();
		return new ResponseEntity<List<ClientResponseDTO>>(clients, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClientResponseDTO> getClientByCpf(String cpf) {
		ClientResponseDTO client = clientServiceAPI.getClientByCpf(cpf);
		return new ResponseEntity<ClientResponseDTO>(client, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClientResponseDTO> postNewClient(@Valid ClientRequestDTO clientRequestDTO) {
		ClientResponseDTO newClient = clientServiceAPI.postNewClient(clientRequestDTO);
		return new ResponseEntity<ClientResponseDTO>(newClient, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ClientResponseDTO> updateClient(@Valid ClientUpdateRequestDTO clientUpdateRequestDTO,
			String cpf) {
		ClientResponseDTO updatingClient = clientServiceAPI.updateClient(clientUpdateRequestDTO, cpf);
		return new ResponseEntity<ClientResponseDTO>(updatingClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteClient(String cpf) {
		clientServiceAPI.deleteClient(cpf);
		return ResponseEntity.noContent().build();
	}

}
