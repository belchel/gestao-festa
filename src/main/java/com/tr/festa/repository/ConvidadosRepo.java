package com.tr.festa.repository;

import com.tr.festa.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadosRepo extends JpaRepository<Convidado, Long> {

}
