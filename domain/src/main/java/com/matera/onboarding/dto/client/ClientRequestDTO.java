package com.matera.onboarding.dto.client;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matera.onboarding.entity.MaritalStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequestDTO {

	@NotBlank
	@Size(max = 11, message = "cpf cannot be greather than eleven")
	private String cpf;

	@NotNull
	@Size(max = 50)
	private String name;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthday;

	@NotNull
	private MaritalStatus maritalStatus;

	@NotNull
	private Boolean indSpecialClient;

}
