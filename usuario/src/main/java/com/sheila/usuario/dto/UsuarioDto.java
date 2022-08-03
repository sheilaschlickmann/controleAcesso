package com.sheila.usuario.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {
	
 public @JsonProperty("id") int id;
 
 public @JsonProperty("situacao")  boolean situacao;



}
