package com.matera.onboarding.business.telephone;

import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;
import com.matera.onboarding.entity.Telephone;

@Component
public interface TelephoneBusinessAPI {
	
	TelephoneResponseDTO toResponseDTO(Telephone telephone);

	List<TelephoneResponseDTO> toListResponseDTO(List<Telephone> telephones);

	Telephone toEntity(TelephoneRequestDTO telephoneRequestDTO);
	
	List<TelephoneResponseDTO> getAllTelephones();

	List<TelephoneResponseDTO> getAllTelephonesByClient(String cpf);

	TelephoneResponseDTO getTelephoneByClient(Long id, String cpf);

	TelephoneResponseDTO postNewTelephoneInClient(TelephoneRequestDTO telephoneRequestDTO, String cpf);

	TelephoneResponseDTO updateTelephoneByCpf(TelephoneRequestDTO telephoneRequestDTO, Long id, String cpf);

	void deleteTelephoneByCpf(Long id, String cpf);

}
