package com.matera.onboarding.controller.identityDocument;

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

import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;

@RestController
@RequestMapping("/api/v1/onboarding/identityDocuments")
public interface IdentityDocumentAPI {
	
	@GetMapping("/all")
	ResponseEntity<List<IdentityDocumentResponseDTO>> getAllIdentityDocuments();
	
	@GetMapping("/allByClient")
	ResponseEntity<List<IdentityDocumentResponseDTO>> getAllIdentityDocumentByClient(@RequestParam String cpf);

	@GetMapping("/byClient")
	ResponseEntity<IdentityDocumentResponseDTO> getIdentityDocumentByClient(@RequestParam  String cpf, @RequestParam  Long id);
	
	@PostMapping("/new")
	@Transactional
	ResponseEntity<IdentityDocumentResponseDTO> postNewIdentityDocumentInClient(@Valid @RequestBody IdentityDocumentRequestDTO identityDocumentRequestDTO, @RequestParam String cpf);

	@PutMapping("/update")
	@Transactional
	ResponseEntity<IdentityDocumentResponseDTO> updateIdentityDocumentByCpf(@Valid @RequestBody IdentityDocumentRequestDTO identityDocumentRequestDTO, @RequestParam Long id, @RequestParam String cpf);

	@DeleteMapping("/delete")
	@Transactional
	ResponseEntity<?> deleteIdentityDocumentByCpf(@RequestParam Long id, @RequestParam String cpf);

}
