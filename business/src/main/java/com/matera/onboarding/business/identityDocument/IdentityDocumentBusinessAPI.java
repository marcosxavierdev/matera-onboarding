package com.matera.onboarding.business.identityDocument;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;
import com.matera.onboarding.entity.IdentityDocument;

@Component
public interface IdentityDocumentBusinessAPI {
	
	IdentityDocumentResponseDTO toResponseDTO(IdentityDocument identityDocument);

	List<IdentityDocumentResponseDTO> toListResponseDTO(List<IdentityDocument> identityDocuments);

	IdentityDocument toEntity(IdentityDocumentRequestDTO identityDocumentRequestDTO);
	
	List<IdentityDocumentResponseDTO> getAllIdentityDocuments();

	List<IdentityDocumentResponseDTO> getAllIdentityDocumentByClient(String cpf);

	IdentityDocumentResponseDTO getIdentityDocumentByClient(Long id, String cpf);

	IdentityDocumentResponseDTO postNewIdentityDocumentInClient(
			@Valid IdentityDocumentRequestDTO identityDocumentRequestDTO, String cpf);

	IdentityDocumentResponseDTO updateIdentityDocumentByCpf(
			@Valid IdentityDocumentRequestDTO identityDocumentRequestDTO, Long id, String cpf);

	void deleteIdentityDocumentByCpf(Long id, String cpf);
	
	


}
