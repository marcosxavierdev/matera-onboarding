package com.matera.onboarding.repository.telephone;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Telephone;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TelephoneRepository implements TelephoneRepositoryAPI {

	private final TelephoneH2DatabaseRepository telephoneH2DatabaseRepository;

	@Override
	public List<Telephone> findAll() {
		return telephoneH2DatabaseRepository.findAll();
	}

	@Override
	public Optional<Telephone> findById(Long id) {
		return telephoneH2DatabaseRepository.findById(id);
	}

	@Override
	public List<Telephone> findAllByClientCPF(String cpf) {
		return telephoneH2DatabaseRepository.findAllByClientCpf(cpf);
	}

	@Override
	public Optional<Telephone> findByClientCPF(String cpf) {
		return telephoneH2DatabaseRepository.findByClientCpf(cpf);
	}

	@Override
	public Optional<Telephone> findByTelephoneIdAndClientCpf(Long id, String cpf) {
		return telephoneH2DatabaseRepository.findByIdAndClientCpf(id, cpf);
	}

	@Override
	public Telephone save(Telephone telephoneRequest) {
		return telephoneH2DatabaseRepository.save(telephoneRequest);
	}

	@Override
	public void delete(Telephone telephoneById) {
		telephoneH2DatabaseRepository.delete(telephoneById);
	}

}
