package com.matera.onboarding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "street_name", length = 100, nullable = false)
	private String streetName;

	@Column(name = "district", length = 100, nullable = false)
	private String district;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "state", length = 100, nullable = false)
	private String state;

	@Column(name = "zip_code", length = 100, nullable = false)
	private String zipCode;

	@Column(name = "complement", length = 100, nullable = true)
	private String complement;

	@Column(name = "number", nullable = false)
	private Long number;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	public void setClient(Client clientByCpf) {
		this.client = clientByCpf;
	}
}
