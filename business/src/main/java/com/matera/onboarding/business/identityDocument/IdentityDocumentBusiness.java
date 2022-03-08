package com.matera.onboarding.business.identityDocument;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.matera.onboarding.business.exceptions.ObjectNotFoundException;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentRequestDTO;
import com.matera.onboarding.dto.IdentityDocument.IdentityDocumentResponseDTO;
import com.matera.onboarding.entity.Client;
import com.matera.onboarding.entity.IdentityDocument;
import com.matera.onboarding.repository.client.ClientRepositoryAPI;
import com.matera.onboarding.repository.identityDocument.IdentityDocumentRepositoryAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class IdentityDocumentBusiness implements IdentityDocumentBusinessAPI {

	private final IdentityDocumentRepositoryAPI identityDocumentRepositoryAPI;
	private final ClientRepositoryAPI clientRepositoryAPI;
	private final ModelMapper modelMapper;

	@Override
	public IdentityDocumentResponseDTO toResponseDTO(IdentityDocument identityDocument) {
		return modelMapper.map(identityDocument, IdentityDocumentResponseDTO.class);
	}

	@Override
	public List<IdentityDocumentResponseDTO> toListResponseDTO(List<IdentityDocument> identityDocuments) {
		return identityDocuments.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	@Override
	public IdentityDocument toEntity(IdentityDocumentRequestDTO identityDocumentRequestDTO) {
		return modelMapper.map(identityDocumentRequestDTO, IdentityDocument.class);
	}

	@Override
	public List<IdentityDocumentResponseDTO> getAllIdentityDocuments() {
		log.info("[start] getAllIdentityDocuments in IdentityDocumentBusiness");
		List<IdentityDocument> identitiesDocuments = identityDocumentRepositoryAPI.findAll();
		log.info("[finish] getAllIdentityDocuments in IdentityDocumentBusiness");
		return toListResponseDTO(identitiesDocuments);
	}

	@Override
	public List<IdentityDocumentResponseDTO> getAllIdentityDocumentByClient(String cpf) {
		log.info("[start] getAllIdentityDocumentByClient in IdentityDocumentBusiness");
		List<IdentityDocument> identitiesDocumentByClient = identityDocumentRepositoryAPI.findAllByClientCPF(cpf);
		if (identitiesDocumentByClient.isEmpty()) {
			log.info("[finish] getAllIdentityDocumentByClient in IdentityDocumentBusiness with exception");
			throw new ObjectNotFoundException("client not found");
		}
		log.info("[finish] getAllIdentityDocumentByClient in IdentityDocumentBusiness");
		return toListResponseDTO(identitiesDocumentByClient);
	}

	@Override
	public IdentityDocumentResponseDTO getIdentityDocumentByClient(Long id, String cpf) {
		log.info("[start] getIdentityDocumentByClient in IdentityDocumentBusiness");
		IdentityDocument identityDocument = identityDocumentRepositoryAPI.findByIdentityDocumentIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("identity document or client not found"));
		log.info("[finish] getIdentityDocumentByClient in IdentityDocumentBusiness");
		return toResponseDTO(identityDocument);
	}

	@Override
	public IdentityDocumentResponseDTO postNewIdentityDocumentInClient(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, String cpf) {
		log.info("[start] postNewIdentityDocumentInClient in IdentityDocumentBusiness");
		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("client not found"));
		IdentityDocument identityDocumentRequest = toEntity(identityDocumentRequestDTO);
		identityDocumentRequest.setClient(clientByCpf);
		IdentityDocument identityDocument = identityDocumentRepositoryAPI.save(identityDocumentRequest);
		log.info("[finish] postNewIdentityDocumentInClient in IdentityDocumentBusiness");
		return toResponseDTO(identityDocument);
	}

	@Override
	public IdentityDocumentResponseDTO updateIdentityDocumentByCpf(
			IdentityDocumentRequestDTO identityDocumentRequestDTO, Long id, String cpf) {
		log.info("[start] updateIdentityDocumentByCpf in IdentityDocumentBusiness");
		IdentityDocument identityDocumentById = identityDocumentRepositoryAPI
				.findByIdentityDocumentIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("identity document or client not found"));
		Long identityDocumentId = identityDocumentById.getId();
		identityDocumentById.setId(identityDocumentId);
		identityDocumentById.setSequence(identityDocumentRequestDTO.getSequence());
		identityDocumentById.setIdentityDocumentType(identityDocumentRequestDTO.getIdentityDocumentType());
		IdentityDocument updatingIdentityDocument = identityDocumentRepositoryAPI.save(identityDocumentById);
		log.info("[finish] updateIdentityDocumentByCpf in IdentityDocumentBusiness");
		return toResponseDTO(updatingIdentityDocument);
	}

	@Override
	public void deleteIdentityDocumentByCpf(Long id, String cpf) {
		log.info("[start] deleteIdentityDocumentByCpf in IdentityDocumentBusiness");
		IdentityDocument identityDocumentById = identityDocumentRepositoryAPI
				.findByIdentityDocumentIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("identity document or client not found"));
		log.info("[finish] deleteIdentityDocumentByCpf in IdentityDocumentBusiness");
		identityDocumentRepositoryAPI.delete(identityDocumentById);
	}

}
