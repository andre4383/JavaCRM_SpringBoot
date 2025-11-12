package com.rocketseat.minicrm.repository;

import com.rocketseat.minicrm.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato,Long> {

}
