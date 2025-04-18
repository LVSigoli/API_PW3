package br.edu.ifsp.prw3.api_2025_2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank (message = "Marca do veiculo é obrigatória")
        String marca,

        @NotBlank (message = "Modelo do veiculo é obrigatório")
        String modelo,


        @Pattern(regexp = "\\d{4}", message = "O Ano do veículo deve estar no formato aaaa")
        String  ano,

        String cor,

        String placa

) {
}
