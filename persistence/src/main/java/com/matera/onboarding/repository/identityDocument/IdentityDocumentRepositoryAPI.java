package com.matera.onboarding.repository.identityDocument;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.IdentityDocument;

@Repository
public interface IdentityDocumentRepositoryAPI {

	List<IdentityDocument> findAll();

	Optional<IdentityDocument> findById(Long id);

	List<IdentityDocument> findAllByClientCPF(String cpf);

	Optional<IdentityDocument> findByIdentityDocumentIdAndClientCpf(Long id, String cpf);

	IdentityDocument save(IdentityDocument identityDocumentRequest);

	void delete(IdentityDocument identityDocumentById);

	Optional<IdentityDocument> findByClientCPF(String cpf);

}
