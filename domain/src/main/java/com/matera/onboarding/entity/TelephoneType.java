package com.matera.onboarding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "telephone_type")
public class TelephoneType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telephoneType_id")
	private Long telephoneTypeId;

	@Column(name = "type", length = 20, nullable = false)
	private String type;

}
