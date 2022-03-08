package com.matera.onboarding.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Client;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClientRepository implements ClientRepositoryAPI {

	private final ClientH2DatabaseRepository clientH2DatabaseRepository;

	@Override
	public List<Client> findAll() {
		return clientH2DatabaseRepository.findAll();
	}

	@Override
	public Optional<Client> findByCpf(String cpf) {
		return clientH2DatabaseRepository.findByCpf(cpf);
	}

	@Override
	public Optional<Client> findById(Long id) {
		return clientH2DatabaseRepository.findById(id);
	}

	@Override
	public Client save(Client client) {
		return clientH2DatabaseRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		clientH2DatabaseRepository.delete(client);
	}

}
