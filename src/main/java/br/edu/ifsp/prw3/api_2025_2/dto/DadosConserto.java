package br.edu.ifsp.prw3.api_2025_2.dto;

public record DadosConserto(String dataEntrada, String dataSaida, DadosMecanico mecanico, DadosVeiculo veiculo) {
}
