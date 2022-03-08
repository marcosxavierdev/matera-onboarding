package com.matera.onboarding.service.address;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;

@Service
public interface AddressServiceAPI {

	List<AddressResponseDTO> getAllAddressesByClient(String cpf);

	AddressResponseDTO getAdressByClient(Long id, String cpf);

	List<AddressResponseDTO> getAllAddresses();

	AddressResponseDTO postNewAddressInClient(AddressRequestDTO addressRequestDTO, String cpf);

	AddressResponseDTO updateAddressByCpf(AddressRequestDTO addressRequestDTO, Long id, String cpf);

	void deleteAddressByCpf(Long id, String cpf);

}
