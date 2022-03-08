package com.matera.onboarding.business.address;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.matera.onboarding.business.exceptions.ObjectNotFoundException;
import com.matera.onboarding.dto.address.AddressRequestDTO;
import com.matera.onboarding.dto.address.AddressResponseDTO;
import com.matera.onboarding.entity.Address;
import com.matera.onboarding.entity.Client;
import com.matera.onboarding.repository.address.AddressRepositoryAPI;
import com.matera.onboarding.repository.client.ClientRepositoryAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddressBusiness implements AddressBusinessAPI {

	private final AddressRepositoryAPI addressRepositoryAPI;
	private final ClientRepositoryAPI clientRepositoryAPI;
	private final ModelMapper modelMapper;

	@Override
	public AddressResponseDTO toResponseDTO(Address address) {
		return modelMapper.map(address, AddressResponseDTO.class);
	}

	@Override
	public List<AddressResponseDTO> toListResponseDTO(List<Address> addresses) {
		return addresses.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	@Override
	public Address toEntity(AddressRequestDTO addressRequestDTO) {
		return modelMapper.map(addressRequestDTO, Address.class);
	}

	@Override
	public List<AddressResponseDTO> getAllAddresses() {
		log.info("[start] getAllAddresses in AddressBusiness");
		List<Address> addresses = addressRepositoryAPI.findAll();
		log.info("[finish] getAllAddresses in AddressBusiness");
		return toListResponseDTO(addresses);
	}

	@Override
	public List<AddressResponseDTO> getAllAddressesByClient(String cpf) {
		log.info("[start] getAllAddressesByClient in AddressBusiness");
		List<Address> addressesByClient = addressRepositoryAPI.findAllByClientCPF(cpf);
		if (addressesByClient.isEmpty()) {
			log.info("[finish] getAllAddressesByClient in AddressBusiness with exception");
			throw new ObjectNotFoundException("addresses not found");
		}
		log.info("[finish] getAllAddressesByClient in AddressBusiness");
		return toListResponseDTO(addressesByClient);
	}

	@Override
	public AddressResponseDTO getAdressByClient(Long id, String cpf) {
		log.info("[start] getAdressByClient in AddressBusiness");
		Address address = addressRepositoryAPI.findByAddressIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("address or client not found"));
		log.info("[finish] getAdressByClient in AddressBusiness");
		return toResponseDTO(address);
	}

	@Override
	public AddressResponseDTO postNewAddressInClient(AddressRequestDTO addressRequestDTO, String cpf) {
		log.info("[start] postNewAddressInClient in AddressBusiness");
		Client clientByCpf = clientRepositoryAPI.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("client not found"));
		Address addressRequest = toEntity(addressRequestDTO);
		addressRequest.setClient(clientByCpf);
		Address address = addressRepositoryAPI.save(addressRequest);
		log.info("[finish] postNewAddressInClient in AddressBusiness");
		return toResponseDTO(address);
	}

	@Override
	public AddressResponseDTO updateAddressByCpf(AddressRequestDTO addressRequestDTO, Long id, String cpf) {
		log.info("[start] updateAddressByCpf in AddressBusiness");
		Address addressById = addressRepositoryAPI.findByAddressIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("address or client not found"));
		Long addressId = addressById.getId();
		addressById.setId(addressId);
		addressById.setStreetName(addressRequestDTO.getStreetName());
		addressById.setDistrict(addressRequestDTO.getDistrict());
		addressById.setCity(addressRequestDTO.getCity());
		addressById.setState(addressRequestDTO.getState());
		addressById.setZipCode(addressRequestDTO.getZipCode());
		addressById.setComplement(addressRequestDTO.getComplement());
		addressById.setNumber((long) addressRequestDTO.getNumber());
		Address updatingAddress = addressRepositoryAPI.save(addressById);
		log.info("[finish] updateAddressByCpf in AddressBusiness");
		return toResponseDTO(updatingAddress);
	}

	@Override
	public void deleteAddressByCpf(Long id, String cpf) {
		log.info("[start] deleteAddressByCpf (cpf: secret, id:" + id + ") in AddressBusiness");
		Address addressById = addressRepositoryAPI.findByAddressIdAndClientCpf(id, cpf)
				.orElseThrow(() -> new ObjectNotFoundException("address or client not found"));
		log.info("[finish] deleteAddressByCpf in AddressBusiness");
		addressRepositoryAPI.delete(addressById);
	}

}
