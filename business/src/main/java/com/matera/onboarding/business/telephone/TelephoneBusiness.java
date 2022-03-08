package com.matera.onboarding.business.telephone;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.matera.onboarding.business.exceptions.ObjectNotFoundException;
import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;
import com.matera.onboarding.entity.Client;
import com.matera.onboarding.entity.Telephone;
import com.matera.onboarding.repository.client.ClientRepositoryAPI;
import com.matera.onboarding.repository.telephone.TelephoneRepositoryAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelephoneBusiness implements TelephoneBusinessAPI {

	private final TelephoneRepositoryAPI telephoneRepositoryAPI;
	private final ClientRepositoryAPI clientRepositoryAPI;
	private final ModelMapper modelMapper;

	@Override
	public TelephoneResponseDTO toResponseDTO(Telephone telephone) {
		return modelMapper.map(telephone, TelephoneResponseDTO.class);
	}

	@Override
	public List<TelephoneResponseDTO> toListResponseDTO(List<Telephone> telephones) {
		return telephones.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	@Override
	public Telephone toEntity(TelephoneRequestDTO telephoneRequestDTO) {
		return modelMapper.map(telephoneRequestDTO, Telephone.class);
	}

	@Override
	public List<TelephoneResponseDTO> getAllTelephones() {
		log.info("[start] getAllTelephones in TelephoneBusiness");
		List<Telephone> telephones = telephoneRepositoryAPI.findAll();
		log.info("[finish] getAllTelephones in TelephoneBusiness");
		return toListResponseDTO(telephones);
	}

	@Override
	public List<TelephoneResponseDTO> getAllTelephonesByClient(String cpf) {
		log.info("[start] getAllTelephonesByClient in TelephoneBusiness");
		List<Telephone> telephonesByClient = telephoneRepositoryAPI.findAllByClientCPF(cpf);
		if (telephonesByClient.isEmpty()) {
			log.info("[finish] getAllTelephonesByClient in TelephoneBusiness with exception");
			throw new ObjectNotFoundException("client not found");
		}
		log.info("[finish] getAllTelephonesByClient in TelephoneBusiness");
		return toListResponseDTO(telephonesByClient);
	}

	@Override
	public TelephoneResponseDTO getTelephoneByClient(Long id, String cpf) {
		log.info("[start] getTelephoneByClient in TelephoneBusiness");
		Telephone telephone = telephoneRepositoryAPI.findByTelephoneIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("telephone or client not found"));
		log.info("[finish] getTelephoneByClient in TelephoneBusiness");
		return toResponseDTO(telephone);
	}

	@Override
	public TelephoneResponseDTO postNewTelephoneInClient(TelephoneRequestDTO telephoneRequestDTO, String cpf) {
		log.info("[start] postNewTelephoneInClient in TelephoneBusiness");
		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException ("client not found"));
		Telephone telephoneRequest = toEntity(telephoneRequestDTO);
		telephoneRequest.setClient(clientByCpf);
		Telephone telephone = telephoneRepositoryAPI.save(telephoneRequest);
		log.info("[finish] postNewTelephoneInClient in TelephoneBusiness");
		return toResponseDTO(telephone);
	}

	@Override
	public TelephoneResponseDTO updateTelephoneByCpf(TelephoneRequestDTO telephoneRequestDTO, Long id, String cpf) {
		log.info("[start] updateTelephoneByCpf in TelephoneBusiness");
		Telephone telephoneById = telephoneRepositoryAPI.findByTelephoneIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException ("telephone or client not found"));
		Long telephoneId = telephoneById.getId();
		telephoneById.setId(telephoneId);
		telephoneById.setNumber(telephoneRequestDTO.getNumber());
		telephoneById.setDdd(telephoneRequestDTO.getDdd());
		telephoneById.setTelephoneType(telephoneRequestDTO.getTelephoneType());
		Telephone updatingTelephone = telephoneRepositoryAPI.save(telephoneById);
		log.info("[finish] updateTelephoneByCpf in TelephoneBusiness");
		return toResponseDTO(updatingTelephone);
	}

	@Override
	public void deleteTelephoneByCpf(Long id, String cpf) {
		log.info("[start] deleteTelephoneByCpf in TelephoneBusiness");
		Telephone telephoneById = telephoneRepositoryAPI.findByTelephoneIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("telephone or client not found"));
		log.info("[finish] deleteTelephoneByCpf in TelephoneBusiness");
		telephoneRepositoryAPI.delete(telephoneById);

	}

}
