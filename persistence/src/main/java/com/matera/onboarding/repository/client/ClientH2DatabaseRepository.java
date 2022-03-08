package com.matera.onboarding.repository.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Client;

@Repository
public interface ClientH2DatabaseRepository extends JpaRepository<Client, Long> {

	Client findClientByCpf(String cpf);

	Optional<Client> findByCpf(String cpf);

	void deleteById(Client client);

}
