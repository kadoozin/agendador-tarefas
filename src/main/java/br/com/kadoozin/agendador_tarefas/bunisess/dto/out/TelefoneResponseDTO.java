package br.com.kadoozin.agendador_tarefas.bunisess.dto.out;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TelefoneResponseDTO {
    private Long id;
    private String numero;
    private String ddd;
}
