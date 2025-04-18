package br.edu.ifsp.prw3.api_2025_2.models;





import br.edu.ifsp.prw3.api_2025_2.dto.DadosConserto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.ativo = dados.ativo();
        this.mecanico = new Mecanico(dados.mecanico().nome(), dados.mecanico().anosExperiencia());
        this.veiculo = new Veiculo(
                dados.veiculo().marca(),
                dados.veiculo().modelo(),
                dados.veiculo().ano(),
                dados.veiculo().cor(),
                dados.veiculo().placa()
        );
    }
}
