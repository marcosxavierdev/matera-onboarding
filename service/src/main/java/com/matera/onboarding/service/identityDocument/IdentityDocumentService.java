package com.matera.onboarding.service.identityDocument;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.business.identityDocument.IdentityDocumentBusinessAPI;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdentityDocumentService implements IdentityDocumentServiceAPI {

	private final IdentityDocumentBusinessAPI identityDocumentBusinessAPI;

	@Override
	public List<IdentityDocumentResponseDTO> getAllIdentityDocuments() {
		return identityDocumentBusinessAPI.getAllIdentityDocuments();
	}

	@Override
	public List<IdentityDocumentResponseDTO> getAllIdentityDocumentByClient(String cpf) {
		return identityDocumentBusinessAPI.getAllIdentityDocumentByClient(cpf);
	}

	@Override
	public IdentityDocumentResponseDTO getIdentityDocumentByClient(Long id, String cpf) {
		return identityDocumentBusinessAPI.getIdentityDocumentByClient(id, cpf);
	}

	@Override
	public IdentityDocumentResponseDTO postNewIdentityDocumentInClient(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, String cpf) {
		return identityDocumentBusinessAPI.postNewIdentityDocumentInClient(identityDocumentRequestDTO, cpf);
	}

	@Override
	public IdentityDocumentResponseDTO updateIdentityDocumentByCpf(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, Long id, String cpf) {
		return identityDocumentBusinessAPI.updateIdentityDocumentByCpf(identityDocumentRequestDTO, id, cpf);
	}

	@Override
	public void deleteIdentityDocumentByCpf(Long id, String cpf) {
		identityDocumentBusinessAPI.deleteIdentityDocumentByCpf(id, cpf);
	}

}
