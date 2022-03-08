package com.matera.onboarding.service.telephone;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;

@Service
public interface TelephoneServiceAPI {

	List<TelephoneResponseDTO> getAllTelephones();

	List<TelephoneResponseDTO> getAllTelephonesByClient(String cpf);

	TelephoneResponseDTO getTelephoneByClient(Long id, String cpf);

	TelephoneResponseDTO postNewTelephoneInClient(TelephoneRequestDTO telephoneRequestDTO, String cpf);

	TelephoneResponseDTO updateTelephoneByCpf(TelephoneRequestDTO telephoneRequestDTO, Long id, String cpf);

	void deleteTelephoneByCpf(Long id, String cpf);

}
