package com.matera.onboarding.service.identityDocument;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;

@Service
public interface IdentityDocumentServiceAPI {

	List<IdentityDocumentResponseDTO> getAllIdentityDocuments();

	List<IdentityDocumentResponseDTO> getAllIdentityDocumentByClient(String cpf);

	IdentityDocumentResponseDTO getIdentityDocumentByClient(Long id, String cpf);

	IdentityDocumentResponseDTO postNewIdentityDocumentInClient(
			@Valid IdentityDocumentRequestDTO identityDocumentRequestDTO, String cpf);

	IdentityDocumentResponseDTO updateIdentityDocumentByCpf(
			@Valid IdentityDocumentRequestDTO identityDocumentRequestDTO, Long id, String cpf);

	void deleteIdentityDocumentByCpf(Long id, String cpf);

}
