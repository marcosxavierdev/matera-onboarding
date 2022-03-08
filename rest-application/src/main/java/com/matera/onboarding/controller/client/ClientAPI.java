package com.matera.onboarding.controller.client;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.client.ClientRequestDTO;
import com.matera.onboarding.dto.client.ClientResponseDTO;
import com.matera.onboarding.dto.client.ClientUpdateRequestDTO;

@RestController
@RequestMapping("api/v1/onboarding/clients")
public interface ClientAPI {

	@GetMapping("/all")
	ResponseEntity<List<ClientResponseDTO>> getAllClients();

	@GetMapping("/{cpf}")
	ResponseEntity<ClientResponseDTO> getClientByCpf(@PathVariable String cpf);

	@PostMapping("/new")
	@Transactional
	ResponseEntity<ClientResponseDTO> postNewClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO);

	@PutMapping("/update/{cpf}")
	@Transactional
	ResponseEntity<ClientResponseDTO> updateClient(@Valid @RequestBody ClientUpdateRequestDTO clientUpdateRequestDTO,
			@PathVariable String cpf);

	@DeleteMapping("/delete/{cpf}")
	@Transactional
	ResponseEntity<?> deleteClient(@PathVariable String cpf);

}
