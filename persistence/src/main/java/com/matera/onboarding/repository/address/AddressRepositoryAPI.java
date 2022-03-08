package com.matera.onboarding.repository.address;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Address;

@Repository
public interface AddressRepositoryAPI {

	Optional<Address> findByClientCPF(String cpf);

	List<Address> findAll();

	Optional<Address> findById(Long id);

	List<Address> findAllByClientCPF(String cpf);

	Address save(Address addressRequest);

	Optional<Address> findByAddressIdAndClientCpf(Long id, String cpf);

	void delete(Address addressById);

}
