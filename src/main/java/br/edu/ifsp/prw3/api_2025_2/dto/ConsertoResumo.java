package br.edu.ifsp.prw3.api_2025_2.dto;

import br.edu.ifsp.prw3.api_2025_2.models.Conserto;

public record ConsertoResumo(String dataEntrada, String dataSaida, String nomeMecanico, String marca, String modelo) {
    public ConsertoResumo(Conserto c) {
        this(c.getDataEntrada(), c.getDataSaida(), c.getMecanico().getNome(), c.getVeiculo().getMarca(), c.getVeiculo().getModelo());
    }
}