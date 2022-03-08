package com.matera.onboarding.service.telephone;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.business.telephone.TelephoneBusinessAPI;
import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TelephoneService implements TelephoneServiceAPI {

	private final TelephoneBusinessAPI telephoneBusinessAPI;

	@Override
	public List<TelephoneResponseDTO> getAllTelephones() {
		return telephoneBusinessAPI.getAllTelephones();
	}

	@Override
	public List<TelephoneResponseDTO> getAllTelephonesByClient(String cpf) {
		return telephoneBusinessAPI.getAllTelephonesByClient(cpf);
	}

	@Override
	public TelephoneResponseDTO getTelephoneByClient(Long id, String cpf) {
		return telephoneBusinessAPI.getTelephoneByClient(id, cpf);
	}

	@Override
	public TelephoneResponseDTO postNewTelephoneInClient(TelephoneRequestDTO telephoneRequestDTO, String cpf) {
		return telephoneBusinessAPI.postNewTelephoneInClient(telephoneRequestDTO, cpf);
	}

	@Override
	public TelephoneResponseDTO updateTelephoneByCpf(TelephoneRequestDTO telephoneRequestDTO, Long id, String cpf) {
		return telephoneBusinessAPI.updateTelephoneByCpf(telephoneRequestDTO, id, cpf);
	}

	@Override
	public void deleteTelephoneByCpf(Long id, String cpf) {
		telephoneBusinessAPI.deleteTelephoneByCpf(id, cpf);
	}

}
