package com.example.Portifolio.model.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CurriculoAtividadePK implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Column(name = "id_curriculo")
  private Long id_curriculo;

  @Column(name = "id_atv")
  private Long id_atv;
}
