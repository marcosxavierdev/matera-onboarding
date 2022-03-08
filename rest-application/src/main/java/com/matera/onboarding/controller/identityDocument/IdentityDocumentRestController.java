package com.matera.onboarding.controller.identityDocument;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;
import com.matera.onboarding.service.identityDocument.IdentityDocumentServiceAPI;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IdentityDocumentRestController implements IdentityDocumentAPI {

	private final IdentityDocumentServiceAPI identityDocumentServiceAPI;

	@Override
	public ResponseEntity<List<IdentityDocumentResponseDTO>> getAllIdentityDocuments() {
		List<IdentityDocumentResponseDTO> identityDocuments = identityDocumentServiceAPI.getAllIdentityDocuments();
		return new ResponseEntity<List<IdentityDocumentResponseDTO>>(identityDocuments, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<IdentityDocumentResponseDTO>> getAllIdentityDocumentByClient(String cpf) {
		List<IdentityDocumentResponseDTO> identityDocumentsByClient = identityDocumentServiceAPI
				.getAllIdentityDocumentByClient(cpf);
		return new ResponseEntity<List<IdentityDocumentResponseDTO>>(identityDocumentsByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IdentityDocumentResponseDTO> getIdentityDocumentByClient(String cpf, Long id) {
		IdentityDocumentResponseDTO identityDocumentByClient = identityDocumentServiceAPI
				.getIdentityDocumentByClient(id, cpf);
		return new ResponseEntity<IdentityDocumentResponseDTO>(identityDocumentByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IdentityDocumentResponseDTO> postNewIdentityDocumentInClient(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, String cpf) {
		IdentityDocumentResponseDTO newIdentityDocument = identityDocumentServiceAPI
				.postNewIdentityDocumentInClient(identityDocumentRequestDTO, cpf);
		return new ResponseEntity<IdentityDocumentResponseDTO>(newIdentityDocument, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<IdentityDocumentResponseDTO> updateIdentityDocumentByCpf(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, Long id, String cpf) {
		IdentityDocumentResponseDTO updatingIdentityDocument = identityDocumentServiceAPI
				.updateIdentityDocumentByCpf(identityDocumentRequestDTO, id, cpf);
		return new ResponseEntity<IdentityDocumentResponseDTO>(updatingIdentityDocument, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteIdentityDocumentByCpf(Long id, String cpf) {
		identityDocumentServiceAPI.deleteIdentityDocumentByCpf(id, cpf);
		return ResponseEntity.noContent().build();
	}

}
