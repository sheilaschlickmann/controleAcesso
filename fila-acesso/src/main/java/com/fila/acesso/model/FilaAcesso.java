package com.fila.acesso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "filaacesso")
public class FilaAcesso {
	
	@Id
	private long id;

	@Column
	private boolean situacao;

}
