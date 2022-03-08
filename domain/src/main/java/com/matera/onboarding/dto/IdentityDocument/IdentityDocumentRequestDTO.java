package com.matera.onboarding.dto.IdentityDocument;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.matera.onboarding.entity.IdentityDocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdentityDocumentRequestDTO {

	@NotBlank
	@Size(min = 2, max = 20)
	private String sequence;

	@NotNull
	private IdentityDocumentType identityDocumentType;

}
