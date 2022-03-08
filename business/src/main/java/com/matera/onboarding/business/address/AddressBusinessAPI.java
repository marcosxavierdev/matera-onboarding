package com.matera.onboarding.business.address;

import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;
import com.matera.onboarding.entity.Address;

@Component
public interface AddressBusinessAPI {

	AddressResponseDTO toResponseDTO(Address address);

	List<AddressResponseDTO> toListResponseDTO(List<Address> addresses);

	Address toEntity(AddressRequestDTO addressRequestDTO);

	List<AddressResponseDTO> getAllAddresses();

	List<AddressResponseDTO> getAllAddressesByClient(String cpf);

	AddressResponseDTO getAdressByClient(Long id, String cpf);

	AddressResponseDTO postNewAddressInClient(AddressRequestDTO addressRequestDTO, String cpf);

	AddressResponseDTO updateAddressByCpf(AddressRequestDTO addressRequestDTO, Long id, String cpf);

	void deleteAddressByCpf(Long id, String cpf);

}
