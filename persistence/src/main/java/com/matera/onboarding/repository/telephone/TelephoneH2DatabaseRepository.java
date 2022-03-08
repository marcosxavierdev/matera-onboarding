package com.matera.onboarding.repository.telephone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matera.onboarding.entity.Telephone;

@Repository
public interface TelephoneH2DatabaseRepository extends JpaRepository<Telephone, Long> {

	List<Telephone> findAllByClientCpf(String cpf);

	Optional<Telephone> findByClientCpf(String cpf);

	@Query(value = "SELECT * FROM telephone t, Client c WHERE t.client_id = c.id AND t.id=:id AND c.cpf=:cpf", nativeQuery = true)
	Optional<Telephone> findByIdAndClientCpf(@Param("id") Long id, @Param("cpf") String cpf);

}
