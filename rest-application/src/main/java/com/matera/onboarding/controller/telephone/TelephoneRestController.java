package com.matera.onboarding.controller.telephone;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.telephone.TelephoneRequestDTO;
import com.matera.onboarding.dto.telephone.TelephoneResponseDTO;
import com.matera.onboarding.service.telephone.TelephoneServiceAPI;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TelephoneRestController implements TelephoneAPI {

	private final TelephoneServiceAPI telephoneServiceAPI;

	@Override
	public ResponseEntity<List<TelephoneResponseDTO>> getAllTelephones() {
		List<TelephoneResponseDTO> telephones = telephoneServiceAPI.getAllTelephones();
		return new ResponseEntity<List<TelephoneResponseDTO>>(telephones, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TelephoneResponseDTO>> getAllTelephonesByClient(String cpf) {
		List<TelephoneResponseDTO> telephonesByClient = telephoneServiceAPI.getAllTelephonesByClient(cpf);
		return new ResponseEntity<List<TelephoneResponseDTO>>(telephonesByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TelephoneResponseDTO> getTelephoneByClient(String cpf, Long id) {
		TelephoneResponseDTO telephoneByClient = telephoneServiceAPI.getTelephoneByClient(id, cpf);
		return new ResponseEntity<TelephoneResponseDTO>(telephoneByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TelephoneResponseDTO> postNewTelephoneInClient(TelephoneRequestDTO telephoneRequestDTO,
			String cpf) {
		TelephoneResponseDTO newTelephone = telephoneServiceAPI.postNewTelephoneInClient(telephoneRequestDTO, cpf);
		return new ResponseEntity<TelephoneResponseDTO>(newTelephone, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TelephoneResponseDTO> updateTelephoneByCpf(TelephoneRequestDTO telephoneRequestDTO, Long id,
			String cpf) {
		TelephoneResponseDTO updatingTelephone = telephoneServiceAPI.updateTelephoneByCpf(telephoneRequestDTO, id, cpf);
		return new ResponseEntity<TelephoneResponseDTO>(updatingTelephone, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteTelephoneByCpf(Long id, String cpf) {
		telephoneServiceAPI.deleteTelephoneByCpf(id, cpf);
		return ResponseEntity.noContent().build();
	}

}
