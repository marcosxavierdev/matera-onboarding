package com.matera.onboarding.repository.address;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Address;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressRepository implements AddressRepositoryAPI {

	private final AddressH2DatabaseRepository addressH2DatabaseRepository;
	
	@Override
	public List<Address> findAll() {
		return addressH2DatabaseRepository.findAll();
	}
	
	@Override
	public Optional<Address> findById(Long id) {
		return addressH2DatabaseRepository.findById(id);
	}
	
	
	@Override
	public List <Address> findAllByClientCPF(String cpf) {
		return addressH2DatabaseRepository.findAllByClientCpf(cpf);
	}
	
	@Override
	public Optional <Address> findByClientCPF(String cpf) {
		return addressH2DatabaseRepository.findByClientCpf(cpf);
	}

	@Override
	public Optional<Address> findByAddressIdAndClientCpf(Long id, String cpf) {
		return addressH2DatabaseRepository.findByAddressIdAndClientCpf(id,cpf);
	}

	@Override
	public Address save(Address addressRequest) {
		return addressH2DatabaseRepository.save(addressRequest);
	}

	@Override
	public void delete(Address addressRequest) {
		addressH2DatabaseRepository.delete(addressRequest);
	}


}
