package com.matera.onboarding.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Client;

@Repository
public interface ClientRepositoryAPI {

	List<Client> findAll();

	Optional<Client> findByCpf(String cpf);

	Optional<Client> findById(Long id);

	Client save(Client client);

	void delete(Client client);

}
