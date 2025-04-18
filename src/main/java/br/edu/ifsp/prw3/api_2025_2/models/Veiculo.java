package br.edu.ifsp.prw3.api_2025_2.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor // obrigatório para o JPA conseguir instanciar
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
}
