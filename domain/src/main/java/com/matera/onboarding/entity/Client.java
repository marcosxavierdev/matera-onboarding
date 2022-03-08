package com.matera.onboarding.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 13, nullable = false, unique = true)
	private String cpf;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthday;

	@Column(name = "ind_special_client", nullable = false)
	private Boolean indSpecialClient;

	@ManyToOne
	@JoinColumn(name = "marital_status_id", nullable = false)
	private MaritalStatus maritalStatus;

	@OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Address> Addresses;

	@OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<IdentityDocument> IdentityDocuments;

	@OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telephone> Telephones;

}
