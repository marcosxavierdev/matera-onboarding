package com.matera.onboarding.dto.address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequestDTO {

	@NotNull
	@Size(min = 2, max = 100)
	private String streetName;

	@NotNull
	@Size(min = 2, max = 100)
	private String district;

	@NotNull
	@Size(min = 2, max = 100)
	private String city;

	@NotNull
	@Size(min = 2, max = 100)
	private String state;

	@NotNull
	@Size(min = 8, max = 100)
	private String zipCode;

	private String complement;

	@NotNull
	private int number;

}
