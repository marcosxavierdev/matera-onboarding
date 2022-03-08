package com.matera.onboarding.controller.address;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;
import com.matera.onboarding.service.address.AddressServiceAPI;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressRestController implements AddressAPI {

	private final AddressServiceAPI addressServiceAPI;

	@Override
	public ResponseEntity<List<AddressResponseDTO>> getAllAdresses() {
		List<AddressResponseDTO> addresses = addressServiceAPI.getAllAddresses();
		return new ResponseEntity<List<AddressResponseDTO>>(addresses, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<AddressResponseDTO>> getAllAdressesByClient(String cpf) {
		List<AddressResponseDTO> addressesByClient = addressServiceAPI.getAllAddressesByClient(cpf);
		return new ResponseEntity<List<AddressResponseDTO>>(addressesByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AddressResponseDTO> getAdressByClient(String cpf, Long id) {
		AddressResponseDTO addressByClient = addressServiceAPI.getAdressByClient(id, cpf);
		return new ResponseEntity<AddressResponseDTO>(addressByClient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AddressResponseDTO> postNewAddressInClient(AddressRequestDTO addressRequestDTO, String cpf) {
		AddressResponseDTO newAddress = addressServiceAPI.postNewAddressInClient(addressRequestDTO, cpf);
		return new ResponseEntity<AddressResponseDTO>(newAddress, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<AddressResponseDTO> updateAddressByCpf(AddressRequestDTO addressRequestDTO, Long id,
			String cpf) {
		AddressResponseDTO updatingAddress = addressServiceAPI.updateAddressByCpf(addressRequestDTO, id, cpf);
		return new ResponseEntity<AddressResponseDTO>(updatingAddress, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteAddressByCpf(Long id, String cpf) {
		addressServiceAPI.deleteAddressByCpf(id, cpf);
		return ResponseEntity.noContent().build();
	}

}
