package com.matera.onboarding.dto.telephone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneTypeResponseDTO {

	private Long id;
	private String type;

}
