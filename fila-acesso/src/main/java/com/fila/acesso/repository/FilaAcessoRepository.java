package com.fila.acesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila.acesso.model.FilaAcesso;

@Repository
public interface FilaAcessoRepository extends JpaRepository<FilaAcesso, Long> {

}
