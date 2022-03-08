package com.matera.onboarding.repository.identityDocument;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.IdentityDocument;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class IdentityDocumentRepository implements IdentityDocumentRepositoryAPI {

	private final IdentityDocumentH2DatabaseRepository identityDocumentH2DatabaseRepository;

	@Override
	public List<IdentityDocument> findAll() {
		return identityDocumentH2DatabaseRepository.findAll();
	}

	@Override
	public Optional<IdentityDocument> findById(Long id) {
		return identityDocumentH2DatabaseRepository.findById(id);
	}

	@Override
	public List<IdentityDocument> findAllByClientCPF(String cpf) {
		return identityDocumentH2DatabaseRepository.findAllByClientCpf(cpf);
	}

	@Override
	public Optional<IdentityDocument> findByClientCPF(String cpf) {
		return identityDocumentH2DatabaseRepository.findByClientCpf(cpf);
	}

	@Override
	public Optional<IdentityDocument> findByIdentityDocumentIdAndClientCpf(Long id, String cpf) {
		return identityDocumentH2DatabaseRepository.findByIdAndClientCpf(id, cpf);
	}

	@Override
	public IdentityDocument save(IdentityDocument identityDocumentRequest) {
		return identityDocumentH2DatabaseRepository.save(identityDocumentRequest);
	}

	@Override
	public void delete(IdentityDocument identityDocumentById) {
		identityDocumentH2DatabaseRepository.delete(identityDocumentById);

	}

}
