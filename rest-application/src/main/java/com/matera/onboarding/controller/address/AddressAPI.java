package com.matera.onboarding.controller.address;

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

import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;

@RestController
@RequestMapping("/api/v1/onboarding/addresses")
public interface AddressAPI {
	
	@GetMapping("/all")
	ResponseEntity<List<AddressResponseDTO>> getAllAdresses();
	
	@GetMapping("/allByClient")
	ResponseEntity<List<AddressResponseDTO>> getAllAdressesByClient(@RequestParam String cpf);

	@GetMapping("/byClient")
	ResponseEntity<AddressResponseDTO> getAdressByClient(@RequestParam  String cpf, @RequestParam Long id);
	
	@PostMapping("/new")
	@Transactional
	ResponseEntity<AddressResponseDTO> postNewAddressInClient(@Valid @RequestBody AddressRequestDTO addressRequestDTO, @RequestParam String cpf);

	@PutMapping("/update")
	@Transactional
	ResponseEntity<AddressResponseDTO> updateAddressByCpf(@Valid @RequestBody AddressRequestDTO addressRequestDTO, @RequestParam  Long id, @RequestParam String cpf);

	@DeleteMapping("/delete")
	@Transactional
	ResponseEntity<?> deleteAddressByCpf(@RequestParam  Long id, @RequestParam String cpf);

}
