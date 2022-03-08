package com.matera.onboarding.service.address;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.business.address.AddressBusinessAPI;
import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService implements AddressServiceAPI {

	private final AddressBusinessAPI addressBusinessAPI;

	@Override
	public List<AddressResponseDTO> getAllAddresses() {
		return addressBusinessAPI.getAllAddresses();
	}

	@Override
	public List<AddressResponseDTO> getAllAddressesByClient(String cpf) {
		return addressBusinessAPI.getAllAddressesByClient(cpf);
	}

	@Override
	public AddressResponseDTO getAdressByClient(Long id, String cpf) {
		return addressBusinessAPI.getAdressByClient(id, cpf);
	}
	
	@Override
	public AddressResponseDTO postNewAddressInClient(AddressRequestDTO addressRequestDTO, String cpf) {
		return addressBusinessAPI.postNewAddressInClient(addressRequestDTO, cpf);
	}

	@Override
	public AddressResponseDTO updateAddressByCpf(AddressRequestDTO addressRequestDTO, Long id, String cpf) {
		return addressBusinessAPI.updateAddressByCpf(addressRequestDTO, id, cpf);
	}

	@Override
	public void deleteAddressByCpf(Long id, String cpf) {
		addressBusinessAPI.deleteAddressByCpf(id, cpf);
		
	}


}
