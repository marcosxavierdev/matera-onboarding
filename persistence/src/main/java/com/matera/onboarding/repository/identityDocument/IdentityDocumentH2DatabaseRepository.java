package com.matera.onboarding.repository.identityDocument;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.IdentityDocument;

@Repository
public interface IdentityDocumentH2DatabaseRepository extends JpaRepository<IdentityDocument, Long> {

	List<IdentityDocument> findAllByClientCpf(String cpf);

	Optional<IdentityDocument> findByClientCpf(String cpf);

	@Query(value = "SELECT * FROM identity_document i, Client c WHERE i.client_id = c.id AND i.id=:id AND c.cpf=:cpf", nativeQuery = true)
	Optional<IdentityDocument> findByIdAndClientCpf(Long id, String cpf);

}
