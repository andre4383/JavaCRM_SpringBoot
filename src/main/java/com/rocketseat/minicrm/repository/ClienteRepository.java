package com.rocketseat.minicrm.repository;

import com.rocketseat.minicrm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
