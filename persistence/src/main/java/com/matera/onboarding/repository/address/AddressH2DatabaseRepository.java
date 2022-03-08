package com.matera.onboarding.repository.address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Address;

@Repository
public interface AddressH2DatabaseRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByClientCpf(String cpf);

	List<Address> findAllByClientCpf(String cpf);

	@Query(value="SELECT * FROM Address a, Client c WHERE a.client_id = c.id AND a.id=:id AND c.cpf=:cpf", nativeQuery = true)
	Optional<Address> findByAddressIdAndClientCpf(@Param("id") Long id, @Param("cpf") String cpf);

}
