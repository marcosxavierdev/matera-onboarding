package com.matera.onboarding.dto.IdentityDocument;

import com.matera.onboarding.dto.client.ClientSummaryResponseDTO;
import com.matera.onboarding.entity.IdentityDocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityDocumentResponseDTO {

	private ClientSummaryResponseDTO client;
	private Long id;
	private String sequence;
	private IdentityDocumentType identityDocumentType;

}
