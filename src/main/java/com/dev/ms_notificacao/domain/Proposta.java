package com.dev.ms_notificacao.domain;

import lombok.Data;

@Data
public class Proposta {

    private Long id;

    private String valorSolicitado;

    private int prazoPagamento;

    private Boolean aprovado;

    private boolean integrada;

    private String observacao;

    private Usuario usuario;
}
