package com.matera.onboarding.repository.telephone;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Telephone;

@Repository
public interface TelephoneRepositoryAPI {

	List<Telephone> findAll();

	Optional <Telephone> findById(Long id);

	List<Telephone> findAllByClientCPF(String cpf);

	Optional<Telephone> findByTelephoneIdAndClientCpf(Long id, String cpf);

	Telephone save(Telephone telephoneRequest);

	void delete(Telephone telephoneById);

	Optional<Telephone> findByClientCPF(String cpf);

}
