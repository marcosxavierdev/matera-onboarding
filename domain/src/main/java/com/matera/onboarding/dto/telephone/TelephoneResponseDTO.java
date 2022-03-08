package com.matera.onboarding.dto.telephone;

import com.matera.onboarding.dto.client.ClientSummaryResponseDTO;
import com.matera.onboarding.entity.TelephoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneResponseDTO {

	private ClientSummaryResponseDTO client;
	private Long id;
	private String number;
	private String ddd;
	private TelephoneType telephoneType;

}
