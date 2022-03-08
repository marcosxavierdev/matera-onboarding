package com.matera.onboarding.dto.telephone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.matera.onboarding.entity.TelephoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelephoneRequestDTO {

	@NotBlank
	@Size(min = 2, max = 20)
	private String number;

	@NotBlank
	@Size(min = 2, max = 5)
	private String ddd;

	@NotNull
	private TelephoneType telephoneType;

}
