package com.matera.onboarding.dto.IdentityDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityDocumentTypeResponseDTO {

	private Long id;
	private String type;
	
}
