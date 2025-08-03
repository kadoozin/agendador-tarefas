package br.com.kadoozin.agendador_tarefas.bunisess.dto.out;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class EnderecoResponseDTO {
    private Long id;
    private Long numero;
    private String rua;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
}
