package br.edu.ifsp.prw3.api_2025_2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "A data de entrada deve  estar no formato dd/mm/aaaa" )
        String dataEntrada,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "A data de entrada deve  estar no formato dd/mm/aaaa" )
        String dataSaida,

        @Valid DadosMecanico mecanico,

       @Valid DadosVeiculo veiculo
) {
}
