package com.matera.onboarding.dto.client;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matera.onboarding.entity.MaritalStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

	private Long id;
	private String cpf;
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthday;
	private Boolean indSpecialClient;
	private MaritalStatus maritalStatus;

}
