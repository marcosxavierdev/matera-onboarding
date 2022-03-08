package com.matera.onboarding.dto.address;

import com.matera.onboarding.dto.client.ClientSummaryResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {

	private ClientSummaryResponseDTO client;
	private Long id;
	private String streetName;
	private String district;
	private String city;
	private String state;
	private String zipCode;
	private String complement;
	private Long number;

}
