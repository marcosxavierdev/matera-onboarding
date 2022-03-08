package com.matera.onboarding.controller.telephone;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;

@RestController
@RequestMapping("/api/v1/onboarding/telephones")
public interface TelephoneAPI {
	
	@GetMapping("/all")
	ResponseEntity<List<TelephoneResponseDTO>> getAllTelephones();
	
	@GetMapping("/allByClient")
	ResponseEntity<List<TelephoneResponseDTO>> getAllTelephonesByClient(@RequestParam String cpf);

	@GetMapping("/byClient")
	ResponseEntity<TelephoneResponseDTO> getTelephoneByClient(@RequestParam  String cpf, @RequestParam  Long id);
	
	@PostMapping("/new")
	@Transactional
	ResponseEntity<TelephoneResponseDTO> postNewTelephoneInClient(@Valid @RequestBody TelephoneRequestDTO telephoneRequestDTO, @RequestParam String cpf);

	@PutMapping("/update")
	@Transactional
	ResponseEntity<TelephoneResponseDTO> updateTelephoneByCpf(@Valid @RequestBody TelephoneRequestDTO telephoneRequestDTO, @RequestParam Long id, @RequestParam String cpf);

	@DeleteMapping("/delete")
	@Transactional
	ResponseEntity<?> deleteTelephoneByCpf(@RequestParam Long id, @RequestParam String cpf);
	
}
